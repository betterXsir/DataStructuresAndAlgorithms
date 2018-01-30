package com.hzh.swordsRefersToOffer;

public class LongestSubStringWithSameChar48 {
    public static int solution(String str) {
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int longestLength = 1;
        int[] lengthEndWithChar = new int[str.length()];
        lengthEndWithChar[0] = 1;
        for(int i = 1; i < str.length(); i++) {
            int sameCharIndex = findSameChar(str, str.charAt(i), lengthEndWithChar[i-1], i);
            if(sameCharIndex >= 0) {
                lengthEndWithChar[i] = i - sameCharIndex;
            }
            else {
                lengthEndWithChar[i] = lengthEndWithChar[i-1] + 1;
            }
            if(lengthEndWithChar[i] > longestLength)
                longestLength = lengthEndWithChar[i];
        }
        return longestLength;
    }

    public static int findSameChar(String str, char character, int lengthBefore, int indexNow) {
        int result = -1;
        for(int i = indexNow - lengthBefore; i < indexNow; i++) {
            if(str.charAt(i) == character)
                if(i > result)
                    result = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = LongestSubStringWithSameChar48.solution("aaaaafffwndhnndjfflkk");
        System.out.println(result);
    }
}
