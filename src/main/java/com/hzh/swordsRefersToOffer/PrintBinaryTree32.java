package com.hzh.swordsRefersToOffer;

import com.hzh.queue.DynamicArrayQueue;
import com.hzh.stack.ArrayStack;
import com.hzh.tree.BinarySearchTree;
import com.hzh.tree.BinaryTreeNode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.beans.BeanInfo;

public class PrintBinaryTree32 {
    /**
     *按行打印二叉树
     * @param root
     */
    public static void solution2(BinaryTreeNode<Integer> root) {
        System.out.println("coming");
        if(root == null) {
            System.out.println("二叉树为空");
        }
        DynamicArrayQueue<BinaryTreeNode> queue = new DynamicArrayQueue();
        queue.enQueue(root);
        queue.enQueue(null);
        while(!queue.isEmpty()) {
            BinaryTreeNode nodeToPrint = queue.deQueue();
            if(nodeToPrint != null) {
                System.out.print(nodeToPrint.getData());
                if(nodeToPrint.getLeft() != null) {
                    queue.enQueue(nodeToPrint.getLeft());
                }
                if(nodeToPrint.getRight() != null) {
                    queue.enQueue(nodeToPrint.getRight());
                }
            }
            else {
                System.out.println();
                if(!queue.isEmpty()) {
                    queue.enQueue(null);
                }
            }
        }
    }

    /**
     * 之字形打印二叉树
     * @param root
     */
    public static void solution3(BinaryTreeNode<Integer> root) {
        if(root == null) {
            System.out.println("二叉树为空");
        }

        ArrayStack<BinaryTreeNode> s1 = new ArrayStack<>();
        ArrayStack<BinaryTreeNode> s2 = new ArrayStack<>();

        boolean leftToRight = true;
        s1.push(root);
        while(!s1.isEmpty() && !s2.isEmpty()) {
            if(leftToRight) {
                BinaryTreeNode out = s1.pop();
                System.out.print(out.getData() + " ");
                if(out.getLeft() != null) {
                    s2.push(out.getLeft());
                }
                if(out.getRight() != null) {
                    s2.push(out.getRight());
                }
                if(s1.isEmpty()) {
                    leftToRight = false;
                }
            }
            else {
                BinaryTreeNode out = s2.pop();
                System.out.print(out.getData() + " ");
                if(out.getRight() != null) {
                    s1.push(out.getRight());
                }
                if(out.getLeft() != null) {
                    s1.push(out.getLeft());
                }
                if(s2.isEmpty()) {
                    leftToRight = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        for(int i = 0; i < 1; i++) {
            bst.insert(i);
        }
        solution2(bst.getRoot());
    }
}
