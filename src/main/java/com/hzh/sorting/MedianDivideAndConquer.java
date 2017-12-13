package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/14.
 * Unsolved
 */
public class MedianDivideAndConquer {
    public static double solution(int[] A, int a1, int a2, int[] B, int b1, int b2, int drop, int total){
        double m1, m2;
        int m = a2 - a1 + 1;
        int n = b2 - b1 + 1;
        m1 = getMedian(A, a1, a2);
        m2 = getMedian(B, b1, b2);
        if(m1 == m2){
            return m1;
        }
        else if(m1 < m2){
            drop += m / 2;
            return solution(A, a1 + drop, a2, B, b1, b2 - n/2 + 1, drop, total);
        }
        else{
            drop += n / 2;
            return solution(A, a1, a1 - m/2 +1, B, b1 + drop, b2, drop, total);
        }
    }

    /**
     * @Description 获得有序序列的中位数
     * @param A
     * @param start
     * @param end
     */
    public static double getMedian(int[] A, int start, int end){
        int n = end - start + 1;
        if(n % 2 == 0){
            return (A[start + n/2 - 1] + A[start + n/2])/2.0;
        }
        else{
            return (double)A[start + n/2];
        }
    }
}
