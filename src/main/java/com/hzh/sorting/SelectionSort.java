package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/2.
 */
public class SelectionSort {
    public static void selectionSort(int[] A, int n){
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i + 1; j < n; j++){
                if(A[j] < A[min]){
                    min = j;
                }
            }
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
        }
    }
}
