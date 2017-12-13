package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/11/30.
 */
public class SmallestNumberOfRotateArray11 {
    /**
     * @Description 例如，数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转
     * 把一个数组最开始的若干个元素搬到数组的末尾，称之为数组的旋转
     * @param array
     * @param n
     */
    public static int solution(int[] array, int n) {
        if(array == null || n <= 0) {
            return -1;
        }
        boolean isBinaryFind = true;
        int left = 0, right = n-1;
        int middle = left;

        while(array[left] >= array[right]) {
            middle = (left + right) >> 1;

            if(left + 1 == right) {
                middle = right;
                break;
            }

            if(array[left] == array[right] && array[middle] == array[left]) {
                return minInOrder(array, left, right);
            }

            if(array[middle] >= array[left]) {
                left = middle;
            }
            else if(array[middle] <= array[right]) {
                right = middle;
            }
        }
        return array[middle];
    }

    public static int minInOrder(int[] array, int start, int end){
        int result = array[start];
        for(int i = start + 1; i <= end; i++) {
            if(array[i] < array[i-1]) {
                result = array[i];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1};
        System.out.println(solution(array, array.length));
    }
}
