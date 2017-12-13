package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/11/29.
 */
public class MergeSortedArray5 {
    /**
     * @Description A数组末尾有足够多的空余空间可以容纳B数组，
     * 将B中所有数字插入A中，并且所有数字是排序的
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void solution(int[] A, int m, int[] B, int n){
        if(m + n > A.length){
            throw new IndexOutOfBoundsException("A数组空间不足");
        }
        int posA = m-1, posB = n-1, posNew = m+n-1;
        while(posA >= 0 && posB >= 0) {
            if(A[posA] > B[posB]) {
                A[posNew--] = A[posA--];
            }
            else {
                A[posNew--] = B[posB--];
            }
        }
        while(posB >= 0){
            A[posNew--] = B[posB--];
        }
    }

    public static void main(String[] args) {
        int[] A = {1,3,5,9,13,0,0,-9,0,0,-1};
        int[] B = {2,4,5,10,20,2,39,34,9};
        solution(A, 5, B, B.length);
        for(int i = 0; i < A.length; i++) {
            System.out.println(A[i] + " ");
        }
    }
}
