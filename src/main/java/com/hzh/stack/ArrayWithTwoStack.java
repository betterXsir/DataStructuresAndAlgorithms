package com.hzh.Stack;


public class ArrayWithTwoStack<E extends Object> {
    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 1<<4;
    private int arrayLen;
    private int top1,top2;

    public ArrayWithTwoStack(){
        elementData = new Object[DEFAULT_CAPACITY];
        arrayLen = DEFAULT_CAPACITY;
        top1 = -1;
        top2 = arrayLen;
    }

    public void push1(E data){
        if(top1 + 1 == top2){
            throw new IndexOutOfBoundsException("栈满");
        }
        elementData[++top1] = data;
    }

    public void push2(E data){
        if(top2-1 == top1){
            throw new IndexOutOfBoundsException("栈满");
        }
        elementData[--top2] = data;
    }

    public E pop1(){
        if(top1 == -1){
            throw new IndexOutOfBoundsException("栈空");
        }
        return (E)elementData[top1--];
    }

    public E pop2(){
        if(top2 == arrayLen){
            throw new IndexOutOfBoundsException("栈空");
        }
        return (E)elementData[top2++];
    }

    public boolean stack1IsEmpty(){
        return top1 == -1;
    }

    public boolean stack1IsFull(){
        return top1+1 == top2;
    }

    public boolean stack2IsEmpty(){
        return top2 == arrayLen;
    }

    public boolean stack2IsFull(){
        return top2-1 == top1;
    }
}
