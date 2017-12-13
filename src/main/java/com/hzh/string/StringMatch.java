package com.hzh.string;

/**
 * Created by huzhenhua on 2017/11/21.
 */
public class StringMatch {
    public static int forceSolution(char[] T, int n, char[] P, int m){
        for(int i = 0; i < n-m+1; i++){
            int j;
            for(j = 0; j < m; j++){
                if(T[i+j] != P[j]){
                    break;
                }
            }
            if(j == m){
                return i;
            }
        }
        return -1;
    }

    /**
     * @Description 假设字符串中的字符都是整数
     * @param T
     * @param n
     * @param P
     * @param m, 假设情况下，m有限制
     * @return
     */
    public static int robinKarpSolution(char[] T, int n, char[] P, int m){
        long[] hash = new long[n-m+1];
        long p = 0;
        for(int i = 0; i < m; i++){
            p = p * 10;
            p += P[i];
        }
        for(int i = 0; i < m; i++){
            hash[0] = hash[0] * 10;
            hash[0] += T[i];
        }
        for(int i = 1; i < n-m+1; i++){
            hash[i] = (hash[i-1] - T[i-1] * (long)Math.pow(10, m-1)) * 10 + T[i + m - 1];
        }
        for(int i = 0; i < n-m+1; i++){
            if(hash[i] == p){
                return i;
            }
        }
        return -1;
    }

    /**
     * @Description 寻找最长前缀后缀
     * @param P
     * @param m
     * @return
     */
    public static void prefixTable(char[] P, int m, int[] F){
        //i代表前缀，j代表后缀
        int i = 0, j = 1;
        while(j < m){
            if(P[j] == P[i]){
                F[j] = F[i] + 1;
                i++;
                j++;
            }
            else if(i == 0){
                F[j] = 0;
                j++;
            }
            else{
                j = F[j-1];
            }
        }
    }

    public static int kMPSolution(char[] T, int n, char[] P, int m){
        int[] F = new int[m];
        prefixTable(P, m, F);
        int i = 0, j = 0;
        while(i < n){
            if(T[i] == P[j]){
                if(j == m-1){
                    return i-j;
                }
                else {
                    i++;
                    j++;
                }
            }
            else if(j > 0){
                j = F[j-1];
            }
            else{
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] T = "349944823039445".toCharArray();
        char[] P = "94".toCharArray();
        int result = forceSolution("df kdfjak jjj".toCharArray(), 13, "jjj".toCharArray(), 1);
        System.out.println("字符串P在文本字符串T中第一次出现的位置: " + kMPSolution(T, T.length, P, P.length));
    }
}
