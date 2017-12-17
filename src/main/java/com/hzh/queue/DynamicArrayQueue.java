package com.hzh.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by huzhenhua on 2017/10/18.
 */
public class DynamicArrayQueue<T>{
    private int front;
    private int rear;
    private int capacity;
    private Object[] array;

    public DynamicArrayQueue(){
        front = -1;
        rear = -1;
        capacity = 1;
        array = new Object[capacity];
    }

    public static DynamicArrayQueue createDynamicArrayQueue(){
        return new DynamicArrayQueue();
    }

    public void resizeQueue(){
        Object[] oldArray = array;
        int initCapacity = capacity;
        array = new Object[capacity<<1];
        for(int i = 0; i < oldArray.length; i++){
            array[i] = oldArray[i];
        }
        if(rear < front){
            for(int i = 0; i < front; i++){
                array[i + initCapacity] = array[i];
                array[i] = null;
            }
            rear += initCapacity;
        }
        capacity = capacity << 1;
    }

    public void enQueue(T t) {
        if(isFull()){
            resizeQueue();
        }
        array[(rear + 1)%capacity] = t;
        rear = (rear + 1) % capacity;
        if(front == -1){
            front = rear;
        }
    }

    public T deQueue(){
        if(isEmpty()){
            throw new EmptyQueueException("Queue Empty");
        }
        Object data = array[front];
        if(front == rear){
            front = rear = -1;
        }else{
            front = (front+1)%capacity;
        }
        return (T)data;
    }

    public int size() {
        if(front == -1){
            return 0;
        }
        int size = (rear-front+1+capacity)%capacity;
        if(size == 0){
            return capacity;
        }
        return size;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull(){
        return (rear+1)%capacity == front;
    }

    public boolean contains(Object o) {
        return false;
    }

    public void clear() {
        front = rear = -1;
    }
}
