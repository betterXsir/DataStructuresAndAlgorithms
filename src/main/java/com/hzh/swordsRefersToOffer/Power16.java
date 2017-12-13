package com.hzh.swordsRefersToOffer;

import java.util.HashMap;

/**
 * Created by huzhenhua on 2017/12/5.
 */
public class Power16 {
    public static double solution(double base, int exponent) {
        int absExponent = Math.abs(exponent);
        double result = 1.0;
        for(int i = 0; i < absExponent; i++) {
            result *= base;
        }
        if(exponent < 0) {
            if(base == 0) {
                result = Double.POSITIVE_INFINITY;
            }
            else {
                result = 1 / result;
            }
        }
        return result;
    }

    /**
     * 快速乘方
     * @param base
     * @param exponent
     * @return
     */
    public static double powerWithUnsignedExponent(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }
        return powerWithUnsignedExponent(base, exponent%2) *
                powerWithUnsignedExponent(base, exponent >> 1) * powerWithUnsignedExponent(base, exponent >> 1);
    }

    public static void main(String[] args) {
        System.out.println(solution(0,-2));
        System.out.println(powerWithUnsignedExponent(-3, 5));
    }
}
