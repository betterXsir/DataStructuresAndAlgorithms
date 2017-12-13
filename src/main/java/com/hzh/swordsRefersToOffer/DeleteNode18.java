package com.hzh.swordsRefersToOffer;

import com.hzh.LinkedList.Node;
import com.hzh.tree.BinaryTreeNode;

/**
 * Created by huzhenhua on 2017/12/13.
 */
public class DeleteNode18 {
    public static void solution(Node head, Node pToBeDeleted) {
        if(head == null || pToBeDeleted == null || pToBeDeleted.getData() == null) {
            throw new IllegalArgumentException();
        }
        if(pToBeDeleted.getNext() != null) {
            pToBeDeleted.setData(pToBeDeleted.getNext().getData());
            pToBeDeleted.setNext(pToBeDeleted.getNext().getNext());
        }
        else if(pToBeDeleted != head) {
            Node pos = head;
            while(pos.getNext() != null && pos.getNext() != pToBeDeleted) {
                pos = pos.getNext();
            }
            if(pos.getNext() == null) {
                throw new IllegalArgumentException("待删除节点不在链表中");
            }
            pos.setNext(null);
            pToBeDeleted = null;
        }
        else {
            head = null;
        }
    }
}
