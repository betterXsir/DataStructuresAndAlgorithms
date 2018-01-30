package com.hzh.swordsRefersToOffer;

import com.hzh.tree.Heap;

/**
 * Created by huzhenhua on 2017/12/27.
 */
public class LeastKNumbers40 {
    /**
     * 假设允许修改输入的数组,利用快速排序的思想
     * @param numbers
     * @param k
     */
    public static void solution1(int[] numbers, int n, int k) {
        if(numbers == null || n <= 0 || k <= 0 || k > n) {
            throw new IllegalArgumentException();
        }
        int start = 0, end = n - 1;
        int index = partition(numbers, start, end);
        while(index != k) {
            if(k > index) {
                start = index + 1;
                index = partition(numbers, start, end);
            }
            else {
                end = index - 1;
                index = partition(numbers, start, end);
            }
        }
        for(int i = 0; i < k; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    /**
     * 不能修改输入的数组,且适用于处理海量数据,
     * 使用大小为k的数据容器来存储最下的k个数字,
     * 这里使用最大堆做为数据容器.
     * @param numbers
     * @param n
     * @param k
     */
    public static void solution2(int[] numbers, int n, int k) {
        if(numbers == null || n <= 0 || k <= 0 || k > n) {
            throw new IllegalArgumentException();
        }
        Heap docker = new Heap(k, 1);
        for(int i = 0; i < n; i ++) {
            if(i < k) {
                docker.insert(numbers[i]);
            }
            else if((Integer)docker.getExtremum() > numbers[i]) {
                docker.deleteExtreme();
                docker.insert(numbers[i]);
            }
        }
        // TODO: 2017/12/27 遍历该最大堆
    }

    public static int partition(int[] numbers, int start, int end) {
        int pivotItem = numbers[start];
        int temp = numbers[end];
        numbers[end] = pivotItem;
        numbers[start] = temp;

        int small = start - 1;
        int index = start;
        while(index < end) {
            if(numbers[index] < pivotItem ) {
                small ++;
                if(small != index) {
                    int tempPartial = numbers[index];
                    numbers[index] = numbers[small];
                    numbers[small] = tempPartial;
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
}
