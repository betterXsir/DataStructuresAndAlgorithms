package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/2.
 */
public class CountingSort {
    public static void countingSort(int[] A, int n, int[] B, int K){
        int[] C = new int[K];
        for(int i = 0; i < n; i++){
            C[A[i]] += 1;
        }
        for(int i = 1; i < K; i++){
            C[i] += C[i-1];
        }
        for(int i = n-1; i >= 0; i--){
            B[C[A[i]] - 1] = A[i];
            C[A[i]] -= 1;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,2,7,6,9,4,2};
        int[] B = new int[8];
        CountingSort.countingSort(A, 8, B, 10);
        for(int i = 0; i < 8; i++){
            System.out.println(B[i]);
        }
    }
}
