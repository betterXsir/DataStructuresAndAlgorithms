package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/7.
 */
public class QuickSort {
    public static void quickSort(int[] A, int low, int high){
        int pivot;
        if(low < high){
            pivot = partition(A, low, high);
            quickSort(A, low, pivot - 1);
            quickSort(A, pivot+1, high);
        }
    }

    public static int partition(int[] A, int low, int high){
        int pivotItem = A[low];
        int left = low;
        while(low < high){
            while(A[high] > pivotItem && low < high){
                high --;
            }
            while(A[low] <= pivotItem && low < high){
                low ++;
            }
            if(low < high) {
                int temp = A[low];
                A[low] = A[high];
                A[high] = temp;
            }
        }
        A[left] = A[high];
        A[high] = pivotItem;
        return high;
    }

    public static void main(String[] args) {
        int[] A = {5,4,7,8,5,2,3,4};
        quickSort(A, 0, 7);
        for(int i = 0; i < 8; i++){
            System.out.println(A[i]);
        }
    }
}
