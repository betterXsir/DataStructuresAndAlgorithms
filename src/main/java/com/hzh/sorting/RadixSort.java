package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/7.
 */
public class RadixSort {
    public static void radixSort(int[] A, int n, int[] B, int digits){
        int[] C = new int[10];
        for(int j = 0; j < digits; j++) {
            int divisor = (int)Math.pow(10, j);
            for (int i = 0; i < n; i++) {
                C[A[i] / divisor % 10] += 1;
            }
            for (int i = 1; i < 10; i++) {
                C[i] += C[i - 1];
            }
            for (int i = n-1; i >= 0; i--) {
                B[C[A[i] / divisor % 10] - 1] = A[i];
                C[A[i] / divisor % 10] -= 1;
            }
            for(int i = 0; i < n; i++){
                A[i] = B[i];
                C[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {11,23,240,45,46,39,60};
        int[] B = new int[7];
        radixSort(A, 7, B, 3);
        for(int i = 0; i < 7; i++){
            System.out.println(B[i]);
        }
    }
}
