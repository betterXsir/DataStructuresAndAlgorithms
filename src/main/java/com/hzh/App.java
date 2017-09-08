package com.hzh;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1<<30)) ? (1<<30) : n + 1;
    }
    public static void main( String[] args )
    {
        int res = tableSizeFor(17);
        int h=0;
        res = (h = "111".hashCode()) ^ (h>>>16);
        System.out.println( "Hello World!" +  "hash: " + res);
    }
}
