package com.hzh.swordsRefersToOffer;

import com.hzh.stack.ArrayStack;

public class IsPopOrder {
    public static boolean solution(int[] pushOrder, int[] popOrder, int n) {
        if(pushOrder == null || popOrder == null || n <= 0) {
            return false;
        }
        ArrayStack<Integer> stack = new ArrayStack<>();
        int pushIndex = 0, popIndex = 0;
        while(popIndex < n && pushIndex < n) {
            if(popOrder[popIndex] != pushOrder[pushIndex]) {
                if(!stack.isEmpty() && popOrder[popIndex] == stack.getTop()) {
                    popIndex ++;
                    stack.pop();
                }
                else if(pushIndex < n) {
                    stack.push(pushOrder[pushIndex++]);
                }
                else {
                    return false;
                }
            }
            else {
                pushIndex++;
                popIndex ++;
            }
        }
        while(popIndex < n) {
            if(stack.getTop() == popOrder[popIndex]) {
                stack.pop();
            }
            popIndex ++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushOrder = {1,2,3};
        int[] popOrder = {3,2,1};
        System.out.println(solution(pushOrder, popOrder, pushOrder.length));
    }
}
