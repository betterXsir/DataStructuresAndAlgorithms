package com.hzh.stack;

public class ComputeSpan {
    private static int[] computeSpan(int[] inputArray){
        int[] spans = new int[inputArray.length];
        ArrayStack<Integer> stack = new ArrayStack<>();
        int p = 0;
        for(int i=0; i<inputArray.length; i++){
            while (!stack.isEmpty() && inputArray[(Integer)stack.getTop()] <= inputArray[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                p = -1;
            }
            else{
                p = stack.getTop();
            }
            spans[i] = i-p;
            stack.push(i);
        }
        return spans;
    }

    public static void main(String[] args) {
        int[] inputArray = {6,3,3,5,2};
        int[] spans = computeSpan(inputArray);
        for(int i=0; i<spans.length; i++){
            System.out.println(spans[i]+",");
        }
    }
}
