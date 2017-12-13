package com.hzh.swordsRefersToOffer;

import com.hzh.tree.Heap;

/**
 * Created by huzhenhua on 2017/11/23.
 */
public class DoubleCheckLockSingleton1 {
    private volatile static Heap instance;

    public static Heap getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLockSingleton1.class){
                if(instance == null){
                    instance = new Heap(10,1);
                }
            }
        }
        return instance;
    }
}
