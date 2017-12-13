package com.hzh.swordsRefersToOffer;

import com.hzh.tree.BinaryTreeNode;

/**
 * Created by huzhenhua on 2017/11/29.
 */
public class GetNextOfBinaryTree8 {
    /**
     * @Description 给定一颗二叉树和其中一个节点，找出中序遍历的下一个节点，节点还包含指向父节点的指针
     * @param root
     */
    public static BinaryTreeNode solution(BinaryTreeNode root) {
        BinaryTreeNode nextNode = root.getRight();
        BinaryTreeNode parent = root.getParent();
        if(nextNode != null) {
            while(nextNode.getLeft() != null) {
                nextNode = nextNode.getLeft();
            }
            return nextNode;
        }
        else if(parent != null) {
            while(parent != null && parent.getRight() == root) {
                root = parent;
                parent = root.getParent();
            }
        }
        return parent;
    }
}
