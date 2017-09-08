package com.hzh;

import com.hzh.LinkedList.LinkedList;

/**
 * Created by huzhenhua on 2017/9/8.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        for(int i=0; i<6; i++){
            list.add("Node" + i);
        }
        list.inverseAllInPair();
        System.out.println(list);
    }
}
