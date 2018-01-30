package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/20.
 */
public class MoreThanHalfNum39 {
    public static int solution(int[] numbers, int n) {
        if(numbers == null || n <= 0) {
            throw new IllegalArgumentException("数组为空");
        }

        int result = moreThanHalfNumCore(numbers, 0, n - 1, n >> 1);

        // 检查该中位数在数组中是否超过一半长度，即检查该数组是否为有效输入
        int count = 0;
        for(int i = 0; i < n ; i++) {
            if(numbers[i] == result) {
                count ++;
            }
        }
        if(count <= n/2) {
            throw new IllegalArgumentException("无效输入");
        }
        return result;
    }

    public static int moreThanHalfNumCore(int[] numbers, int start, int end, int k) {
        if(start == end) {
            return numbers[start];
        }
        int pivot = partion(numbers, start, end);
        if(pivot == k) {
            return numbers[pivot];
        }
        else if(k < pivot) {
            return moreThanHalfNumCore(numbers, start, pivot-1, k);
        }
        else {
            return moreThanHalfNumCore(numbers, pivot + 1, end, k);
        }
    }

    public static int partion(int[] numbers, int start, int end) {
        int pivotItem = numbers[start];
        int temp = numbers[end];
        numbers[end] = pivotItem;
        numbers[start] = temp;

        int small = start - 1;
        int index = start;

        while(index < end) {
            if(numbers[index] < pivotItem) {
                small ++;
                if(small != index) {
                    int tempPartial = numbers[small];
                    numbers[small] = numbers[index];
                    numbers[index] = tempPartial;
                }
            }
            index ++;
        }

        small ++;
        temp = numbers[small];
        numbers[small] = pivotItem;
        numbers[end] = temp;
        return small;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,3,3,3,3,3};
        System.out.println(solution(nums, nums.length));
    }
}
