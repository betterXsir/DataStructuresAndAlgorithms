package com.hzh.swordsRefersToOffer;

import com.hzh.LinkedList.LinkedList;
import com.hzh.LinkedList.Node;
import com.hzh.stack.LLStack;

/**
 * Created by huzhenhua on 2017/11/29.
 */
public class PrintLinklistInTurn6 {
    /**
     * @Description  修改链表结构，指针反转
     * @param head
     */
    public static void solution1(Node head) {
        Node pos = head;
        Node pre = null, temp = null;
        while(pos != null){
            temp = pos.getNext();
            pos.setNext(pre);
            pre = pos;
            pos = temp;
        }
        while(pre != null){
            System.out.println(pre.getData());
            pre = pre.getNext();
        }
    }

    /**
     * @Description 不修改链表结构，利用栈实现反向打印
     * @param head
     */
    public static void solution2(Node head){
        LLStack stack = new LLStack();
        while(head != null) {
            stack.push(head.getData());
            head = head.getNext();
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        Node head = null, p = null;
        for(int i = 0; i < 10; i++) {
            Node node = new Node<Integer>(i);
            if(p == null) {
                head = node;
                p = node;
            }
            else {
                p.setNext(node);
                p = node;
            }
        }
        solution1(head);
//        solution2(head);
    }
}
