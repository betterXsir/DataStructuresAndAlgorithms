package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/13.
 */
public class RegexMatching19 {
    public static boolean solution(char[] str, char[] pattern) {
        if(str == null || pattern == null) {
            return false;
        }

        return matchCore(str, 0, pattern, 0);
    }

    public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if(str[strIndex] == '\0' && pattern[patternIndex] == '\0') {
            return true;
        }
        if(str[strIndex] != '\0' && pattern[patternIndex] == '\0') {
            return false;
        }
        if(str[strIndex] == '\0' && pattern[patternIndex] != '\0') {
            return false;
        }
        if(pattern[patternIndex+1] == '*') {
            if(str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex) ||
                        matchCore(str, strIndex, pattern, patternIndex + 2);
            }
            else return matchCore(str, strIndex, pattern, patternIndex + 2);
        }
        else {
            if(str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
            }
        }
        return false;
    }
}
