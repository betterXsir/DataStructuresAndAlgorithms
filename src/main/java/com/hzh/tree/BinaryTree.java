package com.hzh.tree;

import javax.xml.soap.Node;

/**
 * Created by huzhenhua on 2017/10/24.
 */
public class BinaryTree<T extends Comparable> {
    private class BinaryTreeNode {
        private T data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(T data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BinaryTree() {

    }

    public int findByBinary(T[] sequence, int low, int high, T target) {
        while(low < high){
            int middle = (low + high) / 2;
            if (target.equals(sequence[middle])){
                return middle;
            }
            else if (target.compareTo(sequence[middle]) > 0){
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        if (low == high) {
            if (target == sequence[low]) {
                return low;
            }
        }
        throw new IndexOutOfBoundsException("sequece doesn't exist the element you find");
    }

    public BinaryTreeNode buildTreeByMiddleAndPreSequence(T[] middleSequence, int middleStart, int middleEnd,
                                                 T[] preSequence, int preStart, int preEnd){
        BinaryTreeNode node = new BinaryTreeNode(null);
        node.data = preSequence[preStart];

        //查找所选节点在中序序列中的索引
        int inIndex = -1;
        for(int i=middleStart; i<middleEnd; i++){
            if(middleSequence[i] == preSequence[preStart]){
                inIndex = i;
            }
        }
        if(inIndex == -1){
            throw new IndexOutOfBoundsException("sequece doesn't exist the element you find");
        }

        if(inIndex-1 >= middleStart) {
            node.left = buildTreeByMiddleAndPreSequence(middleSequence, middleStart, inIndex - 1,
                    preSequence, preStart + 1, preStart + inIndex - middleStart);
        }
        if(inIndex+1 <= middleEnd) {
            node.right = buildTreeByMiddleAndPreSequence(middleSequence, inIndex + 1, middleEnd,
                    preSequence, preStart + 1 + inIndex - middleStart, preEnd);
        }
        return node;
    }

    public void buildTree(T[] sequence1, T[] sequence2) {
        buildTreeByMiddleAndPreSequence(sequence1, 0, sequence1.length,
                sequence2, 0, sequence2.length);
    }

    public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        BinaryTreeNode left, right;
        if (root == null){
            return null;
        }
        if (root.equals(a) || root.equals(b)){
            return root;
        }
        left = LCA(root.left, a, b);
        right = LCA(root.right, a, b);
        if (left != null && right != null) {
            return root;
        }
        else {
            return left != null ? left : right;
        }
    }


}
