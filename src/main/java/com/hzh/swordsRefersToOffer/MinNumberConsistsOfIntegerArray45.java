package com.hzh.swordsRefersToOffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 数字拼接需考虑大数问题
 * Created by huzhenhua on 2017/12/29.
 */
public class MinNumberConsistsOfIntegerArray45 {
    public static String solution(int[] array, int n) {
        if(array == null || n <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i < n; i++) {
            int pivotItem = array[i];
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(comapre(pivotItem, array[j]) < 0) {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = pivotItem;
        }
        for(int i = 0; i < n; i++) {
            stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }

    public static int comapre(int a, int b) {
        String strA = intToString(a);
        String strB = intToString(b);

        //大数问题
        String m = strA + strB;
        String n = strB + strA;

        for(int i = 0; i < m.length(); i++) {
            if(m.charAt(i) < n.charAt(i)) {
                return -1;
            }
            else if(m.charAt(i) > n.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }

    public static String intToString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while(n != 0) {
            stringBuilder.insert(0, n % 10);
            n /= 10;
        }
        return stringBuilder.toString();
    }

    public static class Car<T> {
        public void run(){
            System.out.println("car is running");
        }
    }

    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int[] array = {3, 32, 321};
        System.out.println(solution(array, array.length));
        Car<Integer>[] cars = (Car<Integer>[])new Object[19];
    }
}
