package com.hzh.find;

/**
 * Created by huzhenhua on 2017/11/9.
 */
public class FirstRepeatNumber {
    public static int solution(int[] A, int len, int n){
        int[] B = new int[n+1];
        for(int i = 0; i < len; i++){
            if(B[Math.abs(A[i])] > 0){
                B[A[i]] = -B[A[i]];
            }
            else if(B[Math.abs(A[i])] == 0){
                B[Math.abs(A[i])] = i+1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= n; i++){
            if(B[i] < 0 && B[i] > max){
                max = B[i];
            }
        }
        int maxIndex = -max;
        return A[maxIndex-1];
    }

    public static void main(String[] args) {
        int[] A = {3,2,1,2,2,3};
        System.out.println(solution(A, 6, 3));
    }
}
