package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/12/5.
 */
public class MovingCount13 {
    public static int solution(int rows, int columns, int k) {
        if(rows <= 0 || columns <=0 || k < 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * columns];
        return movingCountCore(rows, columns, 0, 0, k, visited);
    }

    public static int movingCountCore(int rows, int columns, int row, int column, int k, boolean[] visited) {
        int count = 0;
        if(check(rows, columns, row, column, k, visited)) {
            count = 1 + movingCountCore(rows, columns, row - 1, column, k, visited) +
                    movingCountCore(rows, columns, row + 1, column, k, visited) +
                    movingCountCore(rows, columns, row, column - 1, k, visited) +
                    movingCountCore(rows, columns, row, column + 1, k, visited);
        }
        return count;
    }

    public static boolean check(int rows, int columns, int row, int column, int k, boolean[] visited) {
        if(row < 0 || row >= rows || column < 0 || column >= columns ||
                visited[row * columns + column]) {
            return false;
        }
        visited[row * columns + column] = true;
        if((getDigitSum(row) + getDigitSum(column)) > k) {
            return false;
        }
        return true;
    }

    public static int getDigitSum(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(4,1, 0));
    }
}
