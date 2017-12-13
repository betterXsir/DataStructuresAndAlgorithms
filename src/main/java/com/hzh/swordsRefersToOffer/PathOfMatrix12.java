package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/11/30.
 */
public class PathOfMatrix12 {
    public static boolean solution(char[][] matrix, int rows, int columns, String str) {
        if(matrix == null || rows <= 0 || columns <= 0) {
            return false;
        }
        boolean[][] visited = new boolean[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(matrix[i][j] == str.charAt(0)) {
                    if(hasPathCore(matrix, i, j, rows, columns, visited, str, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[][] matrix, int row, int column, int rows, int columns, boolean[][] visited, String str, int index) {
        visited[row][column] = true;
        if(column - 1 >= 0 && !visited[row][column - 1] && matrix[row][column - 1] == str.charAt(index)) {
            if(index + 1 == str.length() || hasPathCore(matrix, row, column - 1, rows, columns, visited, str, index + 1)) {
                return true;
            }
        }
        if(column + 1 < columns && !visited[row][column + 1] && matrix[row][column + 1] == str.charAt(index)) {
            if(index + 1 == str.length() || hasPathCore(matrix, row, column + 1, rows, columns, visited, str, index + 1)) {
                return true;
            }
        }
        if(row - 1 >= 0 && !visited[row-1][column] && matrix[row - 1][column] == str.charAt(index)) {
            if(index + 1 == str.length() || hasPathCore(matrix, row - 1, column, row, columns, visited, str, index + 1)) {
                return true;
            }
        }
        if(row + 1 < rows && !visited[row + 1][column] && matrix[row + 1][column] == str.charAt(index)) {
            if(index + 1 == str.length() || hasPathCore(matrix, row + 1, column, rows, columns, visited, str, index + 1)) {
                return true;
            }
        }
        visited[row][column] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'}};
        if(solution(matrix, 1, 4, "ab")) {
            System.out.println("包含");
        }
        else {
            System.out.println("不包含");
        }
    }
}
