package com.hzh;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by huzhenhua on 2017/12/13.
 */
public class ThreadId {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        for(int i = 0; i < 4; i++) {
            Thread thread = new Thread() {
                public void run() {
                    ThreadId.threadId.set(2);
                    System.out.println(Thread.currentThread().getId() + "-->" + ThreadId.get());
                }
            };
            thread.start();
        }
    }
}
