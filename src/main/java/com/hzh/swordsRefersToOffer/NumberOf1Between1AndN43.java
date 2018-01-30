package com.hzh.swordsRefersToOffer;

public class NumberOf1Between1AndN43 {
    public static void solution(int n) {
        System.out.println(getNumberOf1Core(n));
    }

    public static int getNumberOf1Core(int n) {
        if(n < 10 && n >= 1) {
            return 1;
        }
        else if(n == 0) {
            return 0;
        }
        int highVal = 0, numbers = 0;
        int digits = 0, temp = n;
        while(temp != 0) {
            highVal = temp % 10;
            temp = temp / 10;
            digits ++;
        }
        int remain = (int)Math.pow(10, digits - 1);
        for(int i = 0; i < highVal; i++) {
            if(i != 1) {
                numbers += getNumberOf1Core(remain - 1);
            }
        }

        if(highVal != 1) {
            numbers += getNumberOf1Core(remain - 1) + remain - 1 +
                    getNumberOf1Core(n - highVal * remain);
        }
        else {
            numbers += getNumberOf1Core(n - highVal * remain) + n - highVal * remain + 1;
        }

        //numbers += getNumberOf1Core(n - highVal * remain);

        return numbers;
    }

    public static void main(String[] args) {
        solution(999999);
    }
}
