package com.hzh.swordsRefersToOffer;

import com.hzh.tree.BinarySearchTree;
import com.hzh.tree.BinaryTree;
import com.hzh.tree.BinaryTreeNode;

/**
 * Created by huzhenhua on 2017/12/19.
 */
public class BinarySearchTreeToBilateralList36 {
    private static class BilateralList {
        public BinaryTreeNode head;
        public BinaryTreeNode tail;

        public BilateralList() {
            head = null;
            tail = null;
        }

        public BilateralList(BinaryTreeNode head, BinaryTreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static BinaryTreeNode solution(BinarySearchTree bst) {
        BinaryTreeNode p = bst.getRoot();
        if(bst == null || p == null) {
            return null;
        }
        return convert(p).tail;
    }

    public static BilateralList convert(BinaryTreeNode root) {
        if(root == null) {
            return new BilateralList();
        }
        BilateralList listLeft = convert(root.getLeft());
        if(listLeft.tail != null) {
            listLeft.tail.setRight(root);
            root.setLeft(listLeft.tail);
        }
        else {
            root.setLeft(listLeft.tail);
            listLeft.tail = root;
            listLeft.head = root;
        }
        BilateralList listRight = convert(root.getRight());
        if(listRight.head != null) {
            listRight.head.setLeft(root);
            root.setRight(listRight.head);
        }
        else {
            root.setRight(listRight.head);
            listRight.head = root;
            listRight.tail = root;
        }
        return new BilateralList(listLeft.head, listRight.tail);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(8);
        bst.insert(6);
        bst.insert(12);
        bst.insert(5);
        bst.insert(7);
        bst.insert(10);
        bst.insert(13);
        BinaryTreeNode tail = solution(bst);
        while(tail != null) {
            System.out.println(tail.getData());
            tail = tail.getLeft();
        }
    }
}
