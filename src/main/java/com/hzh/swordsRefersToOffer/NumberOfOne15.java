package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/5.
 */
public class NumberOfOne15 {
    /**
     * @param n, n可能为负数
     * @return
     */
    public static int solution1(int n) {
        int compare = 1;
        int count = 0;
        if(n == 0) {
            return 0;
        }
        while(compare != 0) {
            if((n & compare) != 0) {
                count ++;
            }
            compare <<= 1;
        }
        return count;
    }

    public static int solution2(int n) {
        int count = 0;
        if(n == 0) {
            return 0;
        }
        while(n != 0) {
            n &= (n-1);
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution1(Integer.MAX_VALUE));
        System.out.println(Math.pow(0,-2));
    }
}
