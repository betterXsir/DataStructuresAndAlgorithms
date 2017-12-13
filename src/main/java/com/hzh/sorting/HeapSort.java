package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/7.
 */
public class HeapSort {
    private static class Heap {
        private int[] array;
        private int count;
        private int capacity;
        private int heapType;

        public Heap(int capacity, int headType){
            this.capacity = capacity;
            this.heapType = headType;
            this.count = 0;
            this.array = new int[capacity];
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

        public int getExtremum(){
            if(this.count == 0){
                throw new IndexOutOfBoundsException("empty heap");
            }
            return this.array[0];
        }

        public void percolateDown(int i){
            if(i < 0){
                return;
            }
            int l = getLeftChild(i);
            int r = getRightChild(i);
            int temp;
            int extremum;
            if(l == -1){
                extremum = i;
            }
            else if(r == -1){
                extremum = l;
            }
            else{
                if(heapType == 1) {
                    extremum = array[l] > array[r] ? l : r;
                    extremum = array[extremum] > array[i] ? extremum : i;
                } else {
                    extremum = array[l] < array[r] ? l : r;
                    extremum = array[extremum] < array[i] ? extremum : i;
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

        public int insert(int data){
            if(count + 1 > capacity){
                throw new IndexOutOfBoundsException();
            }
            array[count++] = data;
            int i = count-1;
            if(heapType == 1) {
                while (i >= 0 && data > array[(i - 1) / 2]) {
                    array[i] = array[(i - 1) / 2];
                    i = (i - 1) / 2;
                }
            } else {
                while(i >= 0 && data < array[(i - 1) / 2]){
                    array[i] = array[(i - 1) / 2];
                    i = (i - 1) / 2;
                }
            }
            array[i] = data;
            return i;
        }

        public int delete(int i){
            if(count == 0){
                throw new IndexOutOfBoundsException("Empty Heap");
            }
            int val = array[i];
            array[i] = array[count-1];
            count --;
            percolateDown(i);
            return val;
        }

        public int deleteExtreme(){
            if(count == 0){
                throw new IndexOutOfBoundsException("Empty Heap");
            }
            int val = array[0];
            array[0] = array[count-1];
            count--;
            percolateDown(0);
            return val;
        }
    }

    public static void heapSort(int[] A, int n){
        Heap heap = new Heap(n, 0);
        for(int i = 0; i < n; i++){
            heap.array[i] = A[i];
        }
        heap.count = n;
        for(int i = (n-2)/2; i >= 0; i--){
            heap.percolateDown(i);
        }
        for(int i = n-1; i > 0; i--){
            int temp = heap.array[0];
            heap.array[0] = heap.array[i];
            heap.array[i] = temp;
            heap.count --;
            heap.percolateDown(0);
        }
        for(int i = 0; i < n; i++){
            System.out.println(heap.array[i]);
        }
    }

    public static void main(String[] args) {
        int[] A = {1,2,34,46,36,8,9,42,23,15};
        heapSort(A, 10);
    }
}
