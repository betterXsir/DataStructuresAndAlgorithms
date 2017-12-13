package com.hzh.swordsRefersToOffer;

import java.util.Random;

/**
 * Created by huzhenhua on 2017/11/30.
 */
public class QuickSort {
    public static void solution(int[] array, int start, int end) {
        if(array == null || start < 0 || start > end) {
            throw new IllegalArgumentException();
        }
        if(start == end) {
            return;
        }
        int index = partition(array, start, end);
        if(index > start) {
            solution(array, start, index-1);
        }
        if(index < end) {
            solution(array, index+1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int index = new Random().nextInt(end-start) + end;
        int small = start - 1;

        int temp = array[end];
        array[end] = array[index];
        array[index] = temp;

        for(index = start; index < end; index++) {
            if(array[index] < array[end]) {
                small++;
                if(small != index) {
                    temp = array[index];
                    array[index] = array[small];
                    array[small] = temp;
                }
            }
        }

        small++;
        temp = array[end];
        array[end] = array[small];
        array[small+1] = temp;

        return small;
    }
}
