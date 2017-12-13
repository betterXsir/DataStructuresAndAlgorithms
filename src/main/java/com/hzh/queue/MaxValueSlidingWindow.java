package com.hzh.queue;

import com.hzh.tree.Heap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huzhenhua on 2017/10/19.
 */
public class MaxValueSlidingWindow {
    public static void maxSlidingWindowViolence(int[] A, int n, int w, int[] B){
        int front = 0;
        int count = 0;
        while(front + w -1 < n){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<w; i++){
                if(A[front+i] > max){
                    max = A[front+i];
                }
            }
            B[count++] = max;
            front += 1;
        }
        System.out.print("[");
        for(int j = 0; j < count; j++){
            System.out.print(B[j] + ", ");
        }
        System.out.print("]");
    }

    /**
     * @description 使用堆数据结构保存位于窗口部分的元素，降低算法复杂度
     * @param A
     * @param n A数组的长度
     * @param w 窗口长度
     * @param B 长度要大于等于n
     */
    public static void maxSlidingWindowHeap(int[] A, int n, int w, int[] B){
        //最大堆
        Heap<Integer> windowFrame = new Heap<>(w+1, 1);
        int count = 0, i;
        for(; count < w; count++){
            int toDelete = windowFrame.insert(A[count]);
            B[count] = toDelete;
        }
        for(i = w; i < n; i ++){
            int toDelete = B[i-w];
            B[i-w] = windowFrame.getExtremum();
            windowFrame.delete(toDelete);
            B[count++] = windowFrame.insert(A[i]);
        }
        B[i-1] = windowFrame.getExtremum();
    }

    /**
     * @description 使用双端队列，存放的是窗口部分元素在原数组中的下标
     * @param A
     * @param n
     * @param w
     * @param B
     */
    public static void maxSlidingWindowDoubleEndedQueue(int A[], int n, int w, int[] B){

    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for(int i = 0; i < 5; i++){
            array[i] = i;
        }
        System.out.println(array.length);
    }
}
