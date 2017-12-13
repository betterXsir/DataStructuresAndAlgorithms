package com.hzh.sorting;

/**
 * Created by huzhenhua on 2017/11/14.
 */
public class FindSecondEfficiently {
    // TODO: 2017/11/14 使用锦标赛赛方法,补足数组的元素使其能构建完全二叉树
    public static int solution(int[] A, int n) {
        int treeSize = 1;
        int shift = 0;
        while(treeSize < n){
            shift ++;
            treeSize <<= 1;
        }
        int entireArraySize = (int)Math.pow(2, shift);
        treeSize = (int)Math.pow(2, shift+1) - 1;
        int[] tree = new int[treeSize];
        int count = n-1;
        for(int i = treeSize-1; i >= treeSize - entireArraySize; i--){
            if(i >= treeSize-entireArraySize + n){
                tree[i] = -1;
            }
            else{
                tree[i] = count--;
            }
        }
        return 0;
    }
}
