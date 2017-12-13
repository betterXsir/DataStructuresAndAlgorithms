package com.hzh.tree;

/**
 * Created by huzhenhua on 2017/10/24.
 */
public class BinarySearchTree<T extends Comparable> {
    private class BinarySearchTreeNode {
        private T data;
        private BinarySearchTreeNode left;
        private BinarySearchTreeNode right;

        public BinarySearchTreeNode(T data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    private BinarySearchTreeNode root;

    public void insert(T data){
        BinarySearchTreeNode pre = null;
        BinarySearchTreeNode pos = root;
        boolean isLeft = false;
        if(root == null){
            root = new BinarySearchTreeNode(data);
        }
        else{
            while(pos != null){
                if(data.compareTo(pos.data) < 0){
                    pre = pos;
                    pos = pos.left;
                    isLeft = true;
                }
                else if(data.compareTo(pos.data) > 0){
                    pre = pos;
                    pos = pos.right;
                    isLeft = false;
                }
                else{
                    throw new IllegalArgumentException("the data you want to insert has existed");
                }
            }
            BinarySearchTreeNode node = new BinarySearchTreeNode(data);
            if(isLeft){
                pre.left = node;
            }
            else{
                pre.right = node;
            }
        }
    }

    public BinarySearchTreeNode delete(BinarySearchTreeNode root, T data){
        if(root == null){
            return null;
        }
        else if(root.data.compareTo(data) < 0){
            root.left = delete(root.left, data);
        }
        else if(root.data.compareTo(data) > 0){
            root.right = delete(root.right, data);
        }
        else{
            if(root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }
            else{
                BinarySearchTreeNode pre = root;
                BinarySearchTreeNode p = root.left;
                while(p.right != null){
                    pre = p;
                    p = p.right;
                }
                if(p == root.left){
                    root.data = p.data;
                    pre.left = p.left;
                }
                else{
                    root.data = p.data;
                    pre.right = p.left;
                    p = null;
                }
            }
        }
        return root;
    }

    public BinarySearchTreeNode findKthElement(BinarySearchTreeNode root, int k, int count){
        if(root == null){
            return null;
        }
        BinarySearchTreeNode left = findKthElement(root.left, k, count);
        if(left != null){
            return left;
        }
        else if(++count == k){
            return root;
        }
        return findKthElement(root.right, k, count);
    }
}
