package com.hzh.Stack;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxRectangleAreaWithHistogram {
    private static class Node{
        public int height;
        public int index;

        public Node(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
    private static int maxRectangleArea(int[] heightArray, int n, int width){
        int maxArea = 0;
        if(heightArray == null || n == 0){
            return maxArea;
        }
        // TODO: 2017/9/28 更新最大矩形面积
        ArrayStack<Node> stack = new ArrayStack<>();
        for(int i=0; i<n; i++){
            if(stack.isEmpty() || (heightArray[i] > stack.getTop().height)){
                stack.push(new Node(heightArray[i],i));
            }
            else if(heightArray[i] < stack.getTop().height){
                // TODO: 2017/9/28 用栈顶元素更新最大矩形面积
                Node topElement = stack.pop();
                int areaToUpdate = topElement.height * (i - topElement.index) * width;
                if(areaToUpdate > maxArea){
                    maxArea = areaToUpdate;
                }
                i--;
            }
        }
        while (!stack.isEmpty()){
            Node topElement = stack.pop();
            int areaToUpdate = topElement.height * (n - topElement.index) * width;
            if(areaToUpdate > maxArea){
                maxArea = areaToUpdate;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heightArray = new int[100];
        int i=0,j=0;
        String numberStr = sc.nextLine();
        String[] numbers = numberStr.trim().split(" ");
        for(; j<numbers.length; j++){
            int height = Integer.valueOf(numbers[j].trim());
            heightArray[j] = height;
        }
        int maxRectangleArea = maxRectangleArea(heightArray, j,1);
        System.out.println(maxRectangleArea);
    }
}
