package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/5.
 */
public class MaxProductAfterCutting14 {
    /**
     * 采用动态规划的思想,时间复杂度O(n²),空间复杂度O(n)
     * @param length
     * @return
     */
    public static int solution1(int length) {
        if(length < 2) {
            return 0;
        }
        if(length == 2) {
            return 1;
        }
        if(length == 3) {
            return 2;
        }
        int[] product = new int[length + 1];
        int max = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;
        for(int i = 4; i < length + 1; i++) {
            for(int j = 1; j <= i/2; j++) {
                int productTemp = product[j] * product[i-j];
                if(productTemp > max) {
                    max = productTemp;
                }
            }
            product[i] = max;
            max = 0;
        }
        return product[length];
    }

    public static void main(String[] args) {
        System.out.println(solution1(8));
        System.out.println(-5 >>> 3);
    }
}
