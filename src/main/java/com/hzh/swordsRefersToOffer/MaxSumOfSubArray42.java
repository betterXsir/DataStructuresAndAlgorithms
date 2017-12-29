package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/27.
 */
public class MaxSumOfSubArray42 {
    /**
     * 两个由连续多个整数组成的子数组,求两个子数组的总和的最大值
     * @param array
     * @param n
     */
    public static void solution(int[] array, int n) {
        if(array == null || n <= 0) {
            throw new IllegalArgumentException();
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(array[i] < 0 && i != 0 && i != n-1) {
                sum = getMaxSumCore(array, 0, i-1) + getMaxSumCore(array, i + 1, n - 1);

            }
            else {
                sum = getMaxSumCore(array, 0, n - 1);
            }
            if(sum > maxSum) {
                maxSum = sum;
            }
        }
        System.out.println(maxSum);
    }

    public static int getMaxSumCore(int[] array, int start, int end) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = start; i <= end; i++) {
            if(i == start || sum < 0) {
                sum = array[i];
            }
            else {
                sum += array[i];
                if(sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        solution(array, array.length);
    }
}
