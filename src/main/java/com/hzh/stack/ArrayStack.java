package com.hzh.Stack;


import java.util.ArrayList;

public class ArrayStack<E extends Object> {
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 1<<4;
    private int size = DEFAULT_CAPACITY;
    private int top;

    public ArrayStack(int initialCapacity){
        if(initialCapacity > 0){
            elementData = new Object[initialCapacity];
            size = initialCapacity;
        }
        else if(initialCapacity == 0){
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
            throw new IllegalArgumentException("Illegal initialCapacity: " + initialCapacity);
        }
    }

    public ArrayStack(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void push(E data){
        if(top == DEFAULT_CAPACITY){
            throw new IndexOutOfBoundsException("栈满");
        }
        elementData[top] = data;
        top +=1;
    }

    public E pop(){
        if(isEmpty()){
            throw new IndexOutOfBoundsException("栈空");
        }
        return (E)elementData[--top];
    }

    public E getTop(){
        return (E)elementData[top-1];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == size;
    }

    public void insertBottom(E data){
        if(top == DEFAULT_CAPACITY){
            throw new IndexOutOfBoundsException("栈满");
        }
        for(int i=top; i>0; i--){
            elementData[i] = elementData[i-1];
        }
        top ++;
        elementData[0] = data;
    }

    public void inverse(){
        E temp = pop();
        if(isEmpty()){
            push(temp);
            return;
        }
        inverse();
        insertBottom(temp);
    }

    @Override
    public String toString() {
        String body =  "[Stack][";
        for(int i=0; i<top; i++){
            body += elementData[i] + " , ";
        }
        body += " ]";
        return body;
    }
}
