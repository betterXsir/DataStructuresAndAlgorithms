package com.hzh.swordsRefersToOffer;

import java.io.PrintStream;

public class PrintMatrixClockwise {
    public static void solution(int[][] matrix, int rows, int cols) {
        if(matrix == null || rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException();
        }
        int x = 0, y = 0;
        while(rows > 0 && cols > 0) {
            int i = x, j = y;
            for(; j < y + cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            j --;
            if(++i >= x + rows) {
                break;
            }
            for(; i < x + rows; i++) {
                System.out.print(matrix[i][j] + " ");
            }
            i --;
            if(--j < y) {
                break;
            }
            for(; j >= y ; j--) {
                System.out.print(matrix[i][j] + " ");
            }
            j ++;
            for(i -= 1; i > x; i--) {
                System.out.print(matrix[i][j] + " ");
            }
            rows -= 2;
            cols -= 2;
            x ++;
            y ++;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20}};
        int[][] matrix1 = {{1,2,3,4}};
        int[][] matrix2 = {{1},{2},{3},{4}};
        int[][] matrix3 = {{1}};
        solution(matrix, 4, 5);
        System.out.println();
        solution(matrix1, 1, 4);
        System.out.println();
        solution(matrix2, 4, 1);
        System.out.println();
        solution(matrix3, 1, 1);
    }
}
