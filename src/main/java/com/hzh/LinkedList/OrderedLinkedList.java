package com.hzh.LinkedList;

/**
 * Created by huzhenhua on 2017/8/30.
 */
public class OrderedLinkedList<T extends Comparable<Object>> {
    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
        }
    }

    private Node<T> head;

    public OrderedLinkedList(){
        head = new Node<T>(null);
        head.next = null;
    }

    public void insert(T data){
        Node<T> pos = head;
        Node<T> newNode = new Node<>(data);
        if(pos.next == null){
            pos.next = newNode;
            return;
        }
        pos = pos.next;
        while (pos != null){
            if(pos.data.compareTo(data) < 0){
                pos = pos.next;
            }
            else{
                Node<T> temp = pos.next;
                pos.next = newNode;
                newNode.next = temp;
            }
        }
    }

    public void inverse(){
        Node<T> cursor = head.next;
        if(cursor == null || cursor.next == null){
            return;
        }
        Node<T> record = null;
        while(cursor.next != null){
            Node<T> temp = cursor.next;
            cursor.next = record;
            record = cursor;
            cursor = temp;
        }
        head.next = cursor;
    }
}
