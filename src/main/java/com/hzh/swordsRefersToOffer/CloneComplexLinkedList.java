package com.hzh.swordsRefersToOffer;

import com.hzh.LinkedList.ComplexListNode;

import java.util.HashMap;

/**
 * Created by huzhenhua on 2017/12/19.
 */
public class CloneComplexLinkedList {
    public static void solution(ComplexListNode head) {
        if(head == null) {
            throw new IllegalArgumentException("空链表");
        }
        ComplexListNode p = head;
        ComplexListNode newHead = null;
        ComplexListNode newP = null;

        HashMap<ComplexListNode, ComplexListNode> register = new HashMap<>();

        while(p != null) {
            ComplexListNode node = new ComplexListNode();
            node.setData(p.getData());
            node.setNext(null);
            node.setpSibling(null);

            if(newHead == null) {
                newHead = node;
                newP = node;
            }
            else {
                newP.setNext(node);
                newP = node;
            }

            register.put(p, node);

            p = p.getNext();
        }

        p = head;
        while(p != null) {
            ComplexListNode copyNode = register.get(p);
            ComplexListNode copySibling = register.get(p.getpSibling());
            copyNode.setpSibling(copySibling);
            p = p.getNext();
        }
    }
}
