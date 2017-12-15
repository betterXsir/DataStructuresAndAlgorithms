package com.hzh.stack;

public class JudgePalindromeByStack {
    public static boolean isPalindrome(String str){
        char inputChar[] = str.toCharArray();
        ArrayStack<Character> s = new ArrayStack<>();
        int i = 0;
        while (inputChar[i] != 'X'){
            s.push(inputChar[i]);
            i++;
        }
        i++;
        while(!s.isEmpty()){
            char c = s.pop().charValue();
            if(inputChar[i] != c){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("ababa...ababXbabab...baaa"));
        System.out.println(isPalindrome("ababa...ababXbaba...ababa"));
    }
}
