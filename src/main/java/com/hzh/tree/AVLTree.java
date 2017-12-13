package com.hzh.tree;

/**
 * Created by huzhenhua on 2017/10/27.
 */
public class AVLTree<T extends Comparable> {
    private AVLTreeNode root;

    private class AVLTreeNode {
        private T data;
        private int height;
        private AVLTreeNode left;
        private AVLTreeNode right;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public AVLTreeNode getLeft() {
            return left;
        }

        public void setLeft(AVLTreeNode left) {
            this.left = left;
        }

        public AVLTreeNode getRight() {
            return right;
        }

        public void setRight(AVLTreeNode right) {
            this.right = right;
        }
    }

    public int heightDifference(AVLTreeNode left, AVLTreeNode right){
        return Math.abs(left.getHeight() - right.getHeight());
    }

    public AVLTreeNode singleRotateLeft(AVLTreeNode unblancedNode){
        AVLTreeNode leftChild = unblancedNode.getLeft();
        unblancedNode.setLeft(leftChild.getRight());
        leftChild.setRight(unblancedNode);

        unblancedNode.setHeight(Math.max(unblancedNode.getLeft().getHeight(), unblancedNode.getRight().getHeight()) + 1);
        leftChild.setHeight(Math.max(leftChild.getRight().getHeight(), leftChild.getLeft().getHeight()) + 1);

        return leftChild;
    }

    public AVLTreeNode singleRotateRight(AVLTreeNode unblancedNode){
        AVLTreeNode rightChild = unblancedNode.getRight();
        unblancedNode.setRight(rightChild.getLeft());
        rightChild.setLeft(unblancedNode);

        unblancedNode.setHeight(Math.max(unblancedNode.getLeft().getHeight(), unblancedNode.getRight().getHeight()) + 1);
        rightChild.setHeight(Math.max(rightChild.getLeft().getHeight(), rightChild.getRight().getHeight()) + 1);

        return rightChild;
    }

    public AVLTreeNode doubleRotateWithLeft(AVLTreeNode unblancedNode){
        unblancedNode.setLeft(singleRotateRight(unblancedNode.getLeft()));
        return singleRotateLeft(unblancedNode);
    }

    public AVLTreeNode doubleRotateWithRight(AVLTreeNode unblancedNode){
        unblancedNode.setRight(singleRotateLeft(unblancedNode.getRight()));
        return singleRotateRight(unblancedNode);
    }

    public AVLTreeNode insert(AVLTreeNode root, T data){
        if(root == null){
            root = new AVLTreeNode();
            root.setData(data);
            root.setHeight(0);
            root.setLeft(null);
            root.setRight(null);
        }
        else if(data.compareTo(root.getData()) < 0){
            root.setLeft(insert(root.getLeft(), data));
            if(heightDifference(root.getLeft(), root.getRight()) == 2){
                if(data.compareTo(root.getLeft().getData()) < 0){
                    root = singleRotateLeft(root);
                }
                else{
                    root = doubleRotateWithLeft(root);
                }
            }
        }
        else if(data.compareTo(root.getData()) > 0){
            root.setRight(insert(root.getRight(), data));
            if(heightDifference(root.getLeft(), root.getRight()) == 2){
                if(data.compareTo(root.getRight().getData()) > 0){
                    root = singleRotateRight(root);
                }
                else{
                    root = doubleRotateWithRight(root);
                }
            }
        }
        root.setHeight(Math.max(root.getLeft().getHeight(), root.getRight().getHeight()) + 1);
        return root;
    }
}
