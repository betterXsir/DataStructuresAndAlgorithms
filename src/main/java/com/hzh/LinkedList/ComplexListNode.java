package com.hzh.LinkedList;

/**
 * Created by huzhenhua on 2017/12/19.
 */
public class ComplexListNode<T> {
    private T data;
    private ComplexListNode next;
    private ComplexListNode pSibling;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ComplexListNode getNext() {
        return next;
    }

    public void setNext(ComplexListNode next) {
        this.next = next;
    }

    public ComplexListNode getpSibling() {
        return pSibling;
    }

    public void setpSibling(ComplexListNode pSibling) {
        this.pSibling = pSibling;
    }
}
