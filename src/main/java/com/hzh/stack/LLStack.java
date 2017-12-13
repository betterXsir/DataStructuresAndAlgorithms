package com.hzh.stack;

import com.hzh.LinkedList.Node;

import java.util.EmptyStackException;

/**
 * Created by huzhenhua on 2017/11/29.
 */
public class LLStack<T> {
    private Node<T> headNode;
    private int size;

    public LLStack() {
        this.headNode = null;
        this.size = 0;
    }

    public void push(T data){
        if(headNode == null) {
            headNode = new Node<T>(data);
        }
        else if(headNode.getData() == null) {
            headNode.setData(data);
        }
        else {
            Node node = new Node<T>(data);
            node.setNext(headNode);
            headNode = node;
        }
        size ++;
    }

    public T top() {
        if(headNode == null) {
            return null;
        }
        else {
            return headNode.getData();
        }
    }

    public T pop() {
        if(headNode == null) {
            throw new EmptyStackException();
        }
        else {
            T data = headNode.getData();
            headNode = headNode.getNext();
            size --;
            return data;
        }
    }

    public boolean isEmpty() {
        return headNode == null ? true : false;
    }

    public void deleteStack() {
        headNode = null;
        size = 0;
    }
}
