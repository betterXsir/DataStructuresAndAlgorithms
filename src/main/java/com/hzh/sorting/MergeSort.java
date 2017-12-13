package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/2.
 */
public class MergeSort {
    public static void mergeSort(int A[], int temp[], int left, int right){
        int mid;
        if(left < right){
            mid = (left + right) / 2;
            mergeSort(A, temp, left, mid);
            mergeSort(A, temp, mid + 1, right);
            merge(A, temp, left, mid, right);
        }
    }

    public static void merge(int[] A, int[] temp, int left, int mid, int right){
        int secondArrayPos = mid + 1;
        int tempPos = left;
        int size = right - left + 1;
        while(left <= mid && secondArrayPos <= right){
            if(A[left] <= A[secondArrayPos]){
                temp[tempPos++] = A[left];
                left ++;
            }
            else{
                temp[tempPos++] = A[secondArrayPos];
                secondArrayPos ++;
            }
        }
        while(left <= mid){
            temp[tempPos++] = A[left++];
        }
        while(secondArrayPos <= right){
            temp[tempPos++] = A[secondArrayPos++];
        }

        for(int i = 0; i < size; i++){
            A[right] = temp[right];
            right --;
        }
    }

    public static void main(String[] args) {
        int[] A = {3,4,1,6,8,2,82,4,45,456,67,34};
        int[] temp = new int[12];
        mergeSort(A, temp, 0, 11);
        for(int i = 0; i < A.length; i++){
            System.out.println(A[i]);
        }
    }
}
