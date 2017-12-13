package com.hzh.swordsRefersToOffer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by huzhenhua on 2017/12/7.
 */
public class Sum18 {
    public static int solution(int a, int b) {
        StringBuilder aStr = new StringBuilder();
        StringBuilder bStr = new StringBuilder();
        absOfIntToString(aStr, bStr, a, b);
        if(a > 0 && b > 0) {
            printNumber(addString(aStr, bStr));
        }
        else if(a <= 0 || b <= 0) {
            System.out.println(a + b);
        }
        return 0;
    }

    public static char[] addString(StringBuilder sa, StringBuilder sb) {
        int lengthA = sa.length();
        int lengthB = sb.length();
        int posA = lengthA - 1, posB = lengthB - 1, posSum = lengthA > lengthB ? lengthA : lengthB;
        int carry = 0;
        char[] sumStr = new char[posSum + 1];

        for(int i = 0; i <= posSum; i++) {
            sumStr[i] = '0';
        }

        while(posA >= 0 && posB >= 0) {
            int currentNumberA = sa.charAt(posA) - '0';
            int currentNumberB = sb.charAt(posB) - '0';
            int sum = currentNumberA + currentNumberB + carry;
            carry = 0;
            carry += (sum / 10);
            sumStr[posSum--] += sum % 10;
            posA --;
            posB --;
        }
        while(posA >= 0) {
            int currentNumber = sa.charAt(posA) - '0';
            int sum = currentNumber + carry;
            carry = 0;
            carry += (sum / 10);
            sumStr[posSum--] += sum % 10;
            posA --;
        }
        while(posB >= 0) {
            int currentNumber = sb.charAt(posB) - '0';
            int sum = currentNumber + carry;
            carry = 0;
            carry += (sum / 10);
            sumStr[posSum--] += sum % 10;
            posB --;
        }
        if(carry > 0) {
            sumStr[posSum] += carry;
        }
        return sumStr;
    }

    public static void absOfIntToString(StringBuilder aStr, StringBuilder bStr, int a, int b) {
        int at = a, bt = b;
        int aDigit = 0, bDigit = 0;
        while(at != 0) {
            aDigit ++;
            at /= 10;
        }
        while(bt != 0) {
            bDigit ++;
            bt /= 10;
        }
        while(a != 0) {
            int divisor = (int)Math.pow(10, aDigit - 1);
            aStr.append(Math.abs(a / divisor));
            a %= divisor;
            aDigit --;
        }
        while(b != 0) {
            int divisor = (int)Math.pow(10, bDigit - 1);
            bStr.append(Math.abs(b / divisor));
            b %= divisor;
            bDigit --;
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
        solution(8, 9);
    }
}
