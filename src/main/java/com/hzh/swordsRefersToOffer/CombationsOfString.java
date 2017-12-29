package com.hzh.swordsRefersToOffer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by huzhenhua on 2017/12/19.
 */
public class CombationsOfString {
    public static void solution(String str) {
        combinationsCore("", str);
    }

    public static void combinationsCore(String prefix, String str) {
        if(str.length() > 0) {
            System.out.println(prefix + str.charAt(0));
            combinationsCore(prefix + str.charAt(0), str.substring(1));
            combinationsCore(prefix, str.substring(1));
        }
    }

    public static void main(String[] args) {
        solution("abcb");
        System.out.println(-1 << Integer.SIZE - 3);
    }
}
