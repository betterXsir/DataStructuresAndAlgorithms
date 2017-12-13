package com.hzh.swordsRefersToOffer;

import com.hzh.tree.Heap;

/**
 * @Description 基于类的初始化，在执行类的初始化期间，JVM会去获取一个锁
 * Created by huzhenhua on 2017/11/23.
 */
public class ClassInitialization2 {
    private static class InstanceHolder {
        public static Heap instance = new Heap(10,1);
    }

    public static Heap getInstance(){
        return InstanceHolder.instance;
    }
}
