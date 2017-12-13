package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/8.
 */
public class Question16QuickSort {
    public static void solution(int[] A, int n){
        int left = 0, right = n-1, pos = 0;
        while(pos <= right){
            if(A[pos] < 1){
                int temp = A[left];
                A[left++] = A[pos];
                A[pos] = temp;
            }
            else if(A[pos] > 1 && pos < right){
                int temp = A[right];
                A[right--] = A[pos];
                A[pos] = temp;
                if(A[pos] < 1){
                    int partTemp = A[left];
                    A[left++] = A[pos];
                    A[pos] = partTemp;
                }
            }
            pos ++;
        }
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int[] B = {0, 2, 2, 0, 0, 0, 2, 0, 0, 2, 0, 2};
        solution(B, 12);
        for(int i = 0; i < 12; i++){
            System.out.print(B[i] + " , ");
        }
    }
}
