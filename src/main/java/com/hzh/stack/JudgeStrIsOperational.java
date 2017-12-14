package com.hzh.Stack;

import java.util.Scanner;

public class JudgeStrIsOperational {
    private static boolean judgeStr(String str){
        int len = str.length();
        int pushFrequency = 0;
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            if(Character.compare(c,'S') == 0){
                pushFrequency++;
            }
            else {
                pushFrequency--;
            }
            if(pushFrequency < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Str: ");
        String str = sc.nextLine();
        if(judgeStr(str)){
            System.out.println("Operational");
        }
        else {
            System.out.println("Not operational");
        }
    }
}
