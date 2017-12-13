package com.hzh.string;

/**
 * Created by huzhenhua on 2017/11/21.
 */
public class ReverseString {
    public static String solution(String str){
        StringBuilder strBuilder = new StringBuilder(str);
        int i = 0, j = str.length()-1;
        char temp;
        for(; i < j; i++,j--){
            temp = strBuilder.charAt(i);
            strBuilder.setCharAt(i, str.charAt(j));
            strBuilder.setCharAt(j, temp);
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("dklfjaiojjdsx"));
        String s = new String("diadkf".toCharArray());
        System.out.println(s);
    }
}
