package com.hzh.swordsRefersToOffer;

import com.hzh.LinkedList.Node;
import com.hzh.tree.BinaryTree;
import com.hzh.tree.BinaryTreeNode;

/**
 * 假设输入的前序遍历和中序遍历都不含重复的数字
 * Created by huzhenhua on 2017/11/29.
 */
public class RebuildBinaryTree7 {
    public static BinaryTreeNode solution(int[] inSequence, int inStart, int inEnd, int[] preSequence, int preStart, int preEnd) {
        if(inStart > inEnd) {
            return null;
        }
        int rootPos = findNumber(inSequence, inStart, inEnd, preSequence[preStart]);
        if(rootPos < 0) {
            throw new IllegalArgumentException("序列错误，无法重建二叉树");
        }
        BinaryTreeNode root = new BinaryTreeNode(inSequence[rootPos]);
        try {
            root.setLeft(solution(inSequence, inStart, rootPos - 1, preSequence, preStart + 1, preStart + rootPos - inStart));
            root.setRight(solution(inSequence, rootPos + 1, inEnd, preSequence, preEnd - inEnd + rootPos + 1, preEnd));
        }catch (IllegalArgumentException iae){
            throw iae;
        }
        return root;
    }

    public static int findNumber(int[] sequence, int start, int end, int number) {
        for(int i = start; i <= end; i++) {
            if(sequence[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public static void inOrderTraverse(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        inOrderTraverse(root.getLeft());
        System.out.println(root.getData());
        inOrderTraverse(root.getRight());
    }

    public static void preOrderTraverse(BinaryTreeNode root) {
        if(root == null) {
            return;
        }
        System.out.println(root.getData());
        preOrderTraverse(root.getLeft());
        preOrderTraverse(root.getRight());
    }

    public static void main(String[] args) {
        int[] preSequence = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inSequence = {4, 7, 2, 1, 5, 3, 8, 6};
        int[] preSequence1 = {1, 2, 7, 4};
        int[] inSequence1 = {4, 7, 2, 1};
        BinaryTreeNode root = solution(inSequence, 0, inSequence.length-1, preSequence, 0, preSequence.length-1);
        BinaryTreeNode root1 = solution(inSequence1,0,inSequence1.length-1, preSequence1,0,preSequence1.length-1);
        inOrderTraverse(root1);
    }
}
