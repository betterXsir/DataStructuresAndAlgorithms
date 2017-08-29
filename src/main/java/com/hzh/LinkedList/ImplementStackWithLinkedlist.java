package com.hzh.LinkedList;

/**
 * Created by huzhenhua on 2017/8/29.
 */
public class ImplementStackWithLinkedlist {
    static class Stack<T>{
        private class Node<T>{
            private T data;
            private Node<T> next;
            public Node(T data, Node<T> next){
                this.data = data;
                this.next = next;
            }
        }

        private Node<T> top;
        private int size;
        private int limitedSize;

        public Stack(int limitedSize) {
            clear(limitedSize);
        }

        public void clear(int limitedSize){
            top = new Node<T>(null, null);
            size = 0;
            this.limitedSize = limitedSize;
        }

        public int getSize(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public boolean isFull(){
            System.out.print("size: " + size + " , limitedSize: " + limitedSize);
            return size == limitedSize;
        }

        public void push(T data){
            if(isFull()){
                throw new IndexOutOfBoundsException();
            }
            Node<T> newNode = new Node<T>(data, null);
            Node<T> temp = top.next;
            newNode.next = temp;
            top.next = newNode;
            size ++;
        }

        public T pop(){
            if(isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            Node<T> temp = top.next;
            top.next = temp.next;
            size --;
            return temp.data;
        }

        public T getTop(){
            if(isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            return top.next.data;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack(10);
        for(int i = 0; i < 10; i++){
            stack.push("Number " + i);
        }
        try {
            stack.push("Exception Test");
        }catch (IndexOutOfBoundsException var){
            var.printStackTrace();
        }
        System.out.println("出栈: " + stack.pop());
        System.out.println("栈顶元素: " + stack.getTop());
    }
}
