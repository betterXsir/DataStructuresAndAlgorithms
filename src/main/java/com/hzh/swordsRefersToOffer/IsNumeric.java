package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/13.
 */
public class IsNumeric {
    public static int index = 0;
    public static boolean solution(char[] str) {
        if(str == null) {
            return false;
        }
        //可能不含整数部分，为.B[e|EC]模式
        boolean numeric = scanInteger(str, index);
        if(str[index] == '.') {
            index ++;
            numeric = numeric || scanUnsingedInteger(str, index);
        }
        if(str[index] == 'e' || str[index] == 'E') {
            numeric = numeric && scanInteger(str, index ++);
        }
        return numeric && str[index] == '\0';
    }

    public static boolean scanInteger(char[] str, int index) {
        if(str[index] == '+' || str[index] == '-') {
            index += 1;
        }
        return scanUnsingedInteger(str, index);
    }

    public static boolean scanUnsingedInteger(char[] str, int index) {
        int before = index;
        while(str[index] != '\0' && str[index] >= '0' && str[index] <= '9') {
            index ++;
        }
        return index > before;
    }
}
