package com.hzh.swordsRefersToOffer;

import com.hzh.queue.DynamicArrayQueue;
import com.hzh.tree.BinarySearchTree;
import com.hzh.tree.BinaryTreeNode;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.beans.BeanInfo;

public class PrintBinaryTree {
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

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        for(int i = 0; i < 10; i++) {
            bst.insert(i);
        }
        solution2(bst.getRoot());
    }
}
