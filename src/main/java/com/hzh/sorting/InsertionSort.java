package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/2.
 */
public class InsertionSort {
    public static void insertionSort(int[] A, int n){
        int i, j;
        for(i = 0; i < n; i++){
            int temp = A[i];
            for(j = i-1; j >= 0; j--){
                if(temp < A[j]){
                    A[j+1] = A[j];
                }else {
                    A[j+1] = temp;
                    break;
                }
            }
            if(j < 0) {
                A[0] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {3};
        InsertionSort.insertionSort(A, 1);
        for(int i = 0; i < 1; i++){
            System.out.println(A[i]+ " ");
        }
    }
}
