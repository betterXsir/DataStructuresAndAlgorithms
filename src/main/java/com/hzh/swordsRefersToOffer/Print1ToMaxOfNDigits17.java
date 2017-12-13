package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/7.
 */
public class Print1ToMaxOfNDigits17 {
    /**
     * 考虑大数问题，可能发生溢出，在字符串上模拟数字加法的解法
     * @param n
     */
    public static void solution1(int n) {
        if(n < 1) {
            throw new IllegalArgumentException();
        }
        char[] strNumber = new char[n];
        strNumber[n-1] = '0';
        for(int k = 0; k < n-1; k++) {
            strNumber[k] = '0';
        }
        int currentDigit = 1;
        while(true) {
            while(currentDigit <= n && strNumber[n-currentDigit] == '9') {
                strNumber[n-currentDigit] = '0';
                currentDigit ++;
            }
            if(currentDigit > n) {
                break;
            }
            strNumber[n-currentDigit] += 1;
            printNumber(strNumber);
            currentDigit = 1;
        }
    }

    public static void solution2(char[] strNumber, int currentDigit, int n) {
        for(int i = 0; i < 10; i++) {
            strNumber[n - currentDigit] = (char)('0' + i);
            if(currentDigit == 1) {
                printNumber(strNumber);
            }
            else {
                solution2(strNumber, currentDigit - 1, n);
            }
        }
    }

    public static void printNumber(char[] strNumber) {
        boolean flag = (strNumber[0] == '0');
        int i;
        for(i = 0; i < strNumber.length; i++) {
            if(flag && strNumber[i] == '0') {
                continue;
            }
            System.out.print(strNumber[i]);
            flag = false;
        }
        if(flag && i == strNumber.length) {
            return;
        }
        System.out.print('\n');
    }

    public static void main(String[] args) {
//        solution1(5);
        char[] strNumber = {'0','0','0'};
        solution2(strNumber, 3, 3);
    }
}
