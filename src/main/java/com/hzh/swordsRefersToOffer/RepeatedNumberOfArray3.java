package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/11/23.
 */
public class RepeatedNumberOfArray3 {
    /**
     * @Description 利用hash表,时间复杂度O(n),空间复杂度O(n)
     * @param array
     * @param n, 数组长度, 所有数字都在0～n-1的范围内
     */
    public static void solution1(int[] array, int n){
        if(array == null && n > 0){
            throw new NullPointerException("数组为空");
        }
        int[] countArray = new int[n];
        System.out.print("数组中重复的数字: ");
        for(int i = 0; i < n; i++){
            if(array[i] >= n || array[i] < 0){
                throw new IllegalArgumentException("长度为n的数组中包含0～n-1之外的数");
            }
            if((++countArray[array[i]]) > 1){
                System.out.print(array[i] + " ");
            }
        }
    }

    /**
     * @Description 空间复杂度位O(1),数组可重排
     * @param array
     * @param n
     */
    public static void solution2(int[] array, int n){
        //加入边界检查
        if(array == null && n > 0){
            throw new NullPointerException("数组为空");
        }
        System.out.print("数组中重复的数字: ");
        for(int i = 0; i < n; i++){
            if(array[i] >= n || array[i] < 0){
                throw new IllegalArgumentException("长度为n的数组中包含0～n-1之外的数");
            }
            if(array[i] != i) {
                int temp = array[array[i]];
                if(temp == array[i]){
                    System.out.print(temp + " ");
                    continue;
                }
                array[array[i]] = array[i];
                array[i] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,0,2,5,3};
        int[] array1 = {0,3,2,5,4};
        solution2(array1, array1.length);
    }
}
