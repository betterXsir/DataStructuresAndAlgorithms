package com.hzh.swordsRefersToOffer;

/**
 * Created by huzhenhua on 2017/11/23.
 */
public class FindFromTwoDimensionalArray4 {
    public static boolean solution(int[][] array, int rowStart, int rowEnd, int columnStart, int columnEnd, int number){
        if(array == null || rowStart > rowEnd || columnStart > columnEnd){
            return false;
        }
        int rowMiddle = ((rowEnd - rowStart) >> 1) + rowStart;
        int columnMiddle = ((columnEnd - columnStart) >> 1) + columnStart;
        if(array[rowMiddle][columnMiddle] == number){
            return true;
        }
        else if(rowMiddle == rowEnd && columnMiddle == columnEnd){
            return false;
        }
        else if(array[rowMiddle][columnMiddle] < number){
            return solution(array, rowStart, rowMiddle, columnMiddle+1, columnEnd, number) ||
                    solution(array, rowMiddle+1, rowEnd, columnStart, columnMiddle, number) ||
                    solution(array, rowMiddle+1, rowEnd, columnMiddle+1, columnEnd, number);
        }
        else{
            return solution(array, rowMiddle, rowEnd, columnStart, columnMiddle-1, number) ||
                    solution(array, rowStart, rowMiddle-1, columnMiddle, columnEnd, number) ||
                    solution(array, rowStart, rowMiddle-1, columnStart, columnMiddle-1, number);
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        if(solution(array, 0, 3, 0, 3, 0)){
            System.out.println("查找成功");
        }
        else {
            System.out.println("查找失败");
        }
        String str1 = "abcdef";
        String str2 = new String("abcdef");
        System.out.println(str1 == str2 ? "str1 and str2 are same." : "str1 and str2 are not same.");
    }
}
