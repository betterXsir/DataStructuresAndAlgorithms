package com.hzh.LinkedList;

/**
 * Created by huzhenhua on 2017/8/30.
 */
public class FindKthReverse<T> {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        for(int i=1; i<=10; i++){
            list.add("Node " + i);
        }
        System.out.println(list.findKthReverseComplex(8));
        System.out.println(list.findKthReverseEasy(11));
    }
}
