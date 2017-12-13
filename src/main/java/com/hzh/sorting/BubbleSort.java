package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/2.
 */
public class BubbleSort {
    public static void bubbleSort(int[] A, int n){
        boolean isExchange = true;
        for(int i = n-1; i > 0 && isExchange; i--){
            isExchange = false;
            for(int j = 0; j < i; j++){
                if(A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    isExchange = true;
                }
            }
        }
    }
}
