package com.hzh.LinkedList;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * Created by huzhenhua on 2017/8/30.
 */
public class LinkedList<T> {
    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            next = null;
        }
    }

    private Node<T> head;
    private Node<T> cursor;

    public LinkedList(){
        head = new Node<T>(null);
        cursor = head;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        cursor.next = newNode;
        cursor = newNode;
    }

    public void remove(){
        Node<T> pos = head;
        if(pos == cursor){
            throw new IndexOutOfBoundsException();
        }
        while (pos.next != cursor){
            pos = pos.next;
        }
        pos.next = null;
        cursor = pos;
    }

    /*
    对链表进行两次扫描
     */
    public T findKthReverseComplex(int k){
        Node<T> pos = head;
        int size = 0;
        while(pos.next != null){
            size ++;
            pos = pos.next;
        }
        pos = head;
        for(int i=0; i<size-k+1; i++){
            pos = pos.next;
        }
        if(pos == head)
            throw new IndexOutOfBoundsException();
        return pos.data;
    }

    /**
     * @Description 只需扫描一次链表
     * @param k
     * @return
     */
    public T findKthReverseEasy(int k){
        if(head.next == null){
            throw new IndexOutOfBoundsException();
        }
        Node<T> prePos = head.next;
        Node<T> pos = prePos;
        for(int i=1; i<k && pos!=null; i++){
            pos = pos.next;
        }
        if(pos == null){
            throw new IndexOutOfBoundsException();
        }
        while(pos.next != null){
            prePos = prePos.next;
            pos = pos.next;
        }
        return prePos.data;
    }

    public void inverseAllInPair(){
        Node pre = head;
        Node pos = head.next;
        if(pos == null){
            throw new IndexOutOfBoundsException();
        }
        while(pos != null && pos.next != null){
            inversePair(pre, pos);
            pre = pre.next.next;
            pos = pos.next.next;
        }
    }

    public void inversePair(Node pre, Node start){
        pre.next = start.next;
        Node temp = start.next.next;
        start.next.next = start;
        start.next = temp;
    }

    @Override
    public String toString() {
        Node pos = head.next;
        String body = "LinkedList{";
        while(pos != null){
            body += pos.data + "-->";
        }
        body += " }";
        return body;
    }
}
