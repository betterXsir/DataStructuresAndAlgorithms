package com.hzh.queue;

/**
 * Created by huzhenhua on 2017/10/18.
 */
public class EmptyQueueException extends IndexOutOfBoundsException{
    public EmptyQueueException(){}
    public EmptyQueueException(String gripe){
        super(gripe);
    }
}
