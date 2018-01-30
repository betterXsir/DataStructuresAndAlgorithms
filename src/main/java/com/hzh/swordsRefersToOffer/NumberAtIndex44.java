package com.hzh.swordsRefersToOffer;

public class NumberAtIndex44 {
    public static int solution(String str, int n) {
        if(n < 10) {
            return str.charAt(n) - '0';
        }
        int sum = 0, number = 0;
        int i = 0;
        int period = 1;
        while(period < n) {
            sum += period;
            i ++;
            period = (int)(i * 9 * Math.pow(10, i - 1));
        }
        //i为第n位对应的数字的位数
        int remain = (n + 1 - sum) % i;
        if(remain != 0) {
            int index = n - remain + 1;
        }
        int index = remain != 0 ? n - remain + 1 : n - i + 1;
        for(int j = 0; j < i; j++) {
            number = 10 * number + str.charAt(index + j) - '0';
        }
        return number;
    }

    public static String serializeNumbers(int n) {
        StringBuilder strBuilder = new StringBuilder();
        for(int i = 0 ; i <= n; i++) {
            strBuilder.append(i);
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        String str = serializeNumbers(100000);
        System.out.println(solution(str, 5));
    }
}
