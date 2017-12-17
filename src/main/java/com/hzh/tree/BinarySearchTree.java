package com.hzh.tree;

/**
 * Created by huzhenhua on 2017/10/24.
 */
public class BinarySearchTree<T extends Comparable> {
//    private class BinarySearchTreeNode {
//        private T data;
//        private BinarySearchTreeNode left;
//        private BinarySearchTreeNode right;
//
//        public BinarySearchTreeNode(T data){
//            this.data = data;
//            left = null;
//            right = null;
//        }
//    }

    private BinaryTreeNode root;

    public void insert(T data){
        BinaryTreeNode pre = null;
        BinaryTreeNode pos = root;
        boolean isLeft = false;
        if(root == null){
            root = new BinaryTreeNode(data);
        }
        else{
            while(pos != null){
                if(data.compareTo(pos.getData()) < 0){
                    pre = pos;
                    pos = pos.getLeft();
                    isLeft = true;
                }
                else if(data.compareTo(pos.getData()) > 0){
                    pre = pos;
                    pos = pos.getRight();
                    isLeft = false;
                }
                else{
                    throw new IllegalArgumentException("the data you want to insert has existed");
                }
            }
            BinaryTreeNode node = new BinaryTreeNode(data);
            if(isLeft){
                pre.setLeft(node);
            }
            else{
                pre.setRight(node);
            }
        }
    }

    public BinaryTreeNode delete(BinaryTreeNode root, T data){
        if(root == null){
            return null;
        }
        else if(root.getData().compareTo(data) < 0){
            root.setLeft(delete(root.getLeft(), data));
        }
        else if(root.getData().compareTo(data) > 0){
            root.setRight(delete(root.getRight(), data));
        }
        else{
            if(root.getLeft() == null || root.getRight() == null){
                return root.getLeft() == null ? root.getRight() : root.getLeft();
            }
            else{
                BinaryTreeNode pre = root;
                BinaryTreeNode p = root.getLeft();
                while(p.getRight() != null){
                    pre = p;
                    p = p.getRight();
                }
                if(p == root.getLeft()){
                    root.setData(p.getData());
                    pre.setLeft(p.getLeft());
                }
                else{
                    root.setData(p.getData());
                    pre.setRight(p.getLeft());
                    p = null;
                }
            }
        }
        return root;
    }

    public BinaryTreeNode findKthElement(BinaryTreeNode root, int k, int count){
        if(root == null){
            return null;
        }
        BinaryTreeNode left = findKthElement(root.getLeft(), k, count);
        if(left != null){
            return left;
        }
        else if(++count == k){
            return root;
        }
        return findKthElement(root.getRight(), k, count);
    }

    public BinaryTreeNode getRoot() {
        return root;
    }
}
