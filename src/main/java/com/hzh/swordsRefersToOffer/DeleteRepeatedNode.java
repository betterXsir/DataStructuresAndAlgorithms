package com.hzh.swordsRefersToOffer;

import com.hzh.LinkedList.Node;

/**
 * 在一个排序的链表中删除重复的节点
 * Created by huzhenhua on 2017/12/13.
 */
public class DeleteRepeatedNode {
    public static void soultion(Node head) {
        if(head == null) {
            throw new NullPointerException("空链表");
        }
        Node pre = null;
        Node pos = head;
        while(pos != null) {
            if(pre != null) {
                if(pos.getData() == pre.getData()) {
                    pre.setNext(pos.getNext());
                }
            }
            pre = pos;
            pos = pos.getNext();
        }
    }
}
