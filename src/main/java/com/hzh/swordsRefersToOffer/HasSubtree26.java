package com.hzh.swordsRefersToOffer;

import com.hzh.tree.BinaryTreeNode;

public class HasSubtree26 {
    public static boolean solution(BinaryTreeNode A, BinaryTreeNode B) {
        if(A == null || B == null) {
            return false;
        }
        return isSubTreeCore(A, B);
    }

    public static boolean isSubTreeCore(BinaryTreeNode A, BinaryTreeNode B) {
        if(A == null) {
            return false;
        }
        if(A.getData() == B.getData()) {
            return isSameStruct(A, B);
        }
        else {
            return isSubTreeCore(A.getLeft(), B) || isSubTreeCore(A.getRight(), B);
        }
    }

    public static boolean isSameStruct(BinaryTreeNode A, BinaryTreeNode B) {
        if(A == null && B == null) {
            return true;
        }
        if(A.getData() == B.getData()) {
            return isSameStruct(A.getLeft(), B.getLeft()) &&
                    isSameStruct(A.getRight(), B.getRight());
        }
        return false;
    }
}
