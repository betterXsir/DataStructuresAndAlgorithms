package com.hzh.tree;

/**
 * Created by huzhenhua on 2017/10/27.
 */
public class Heap<T extends Comparable> {
    public T[] array;
    public int count;
    public int capacity;
    public int heapType;

    /**
     *
     * @param capacity
     * @param heapType, 1代表最大堆，0代表最小堆
     */
    public Heap(int capacity, int heapType){
        this.heapType = heapType;
        this.count = 0;
        this.capacity = capacity;
        this.array = (T[])new Object[capacity];
    }

    public int getParent(int i){
        if(i <= 0 || i >= this.count){
            return -1;
        }
        return (i-1)/2;
    }

    public int getLeftChild(int i){
        int left = 2*i + 1;
        if(left >= count){
            return -1;
        }
        return left;
    }

    public int getRightChild(int i){
        int right = 2*i + 2;
        if(right >= count){
            return -1;
        }
        return right;
    }

    public T getExtremum(){
        if(this.count == 0){
            return null;
        }
        return this.array[0];
    }

    public void percolateDown(int i){
        if(i < 0){
            return;
        }
        int l = getLeftChild(i);
        int r = getRightChild(i);
        T temp;
        int extremum;
        if(l == -1){
            extremum = i;
        }
        else if(r == -1){
            extremum = l;
        }
        else{
            if(heapType == 1) {
                extremum = array[l].compareTo(array[r]) > 0 ? l : r;
                extremum = array[extremum].compareTo(array[i]) > 0 ? extremum : i;
            } else {
                extremum = array[l].compareTo(array[r]) < 0 ? l : r;
                extremum = array[extremum].compareTo(array[i]) < 0 ? extremum : i;
            }
        }
        if(extremum != i){
            temp = array[i];
            array[i] = array[extremum];
            array[extremum] = temp;
            percolateDown(extremum);
        }
        else{
            return;
        }
    }

    public int insert(T data){
        if(count + 1 > capacity){
            throw new IndexOutOfBoundsException();
        }
        array[count++] = data;
        int i = count-1;
        if(heapType == 1) {
            while (i >= 0 && data.compareTo(array[(i - 1) / 2]) > 0) {
                array[i] = array[(i - 1) / 2];
                i = (i - 1) / 2;
            }
        } else {
            while(i >= 0 && data.compareTo(array[(i - 1) / 2]) < 0){
                array[i] = array[(i - 1) / 2];
                i = (i - 1) / 2;
            }
        }
        array[i] = data;
        return i;
    }

    public T delete(int i){
        if(count == 0){
            throw new IndexOutOfBoundsException("Empty Heap");
        }
        T val = array[i];
        array[i] = array[count-1];
        count --;
        percolateDown(i);
        return val;
    }

    public T deleteExtreme(){
        if(count == 0){
            throw new IndexOutOfBoundsException("Empty Heap");
        }
        T val = array[0];
        array[0] = array[count-1];
        count--;
        percolateDown(0);
        return val;
    }
}
