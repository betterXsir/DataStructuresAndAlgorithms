package com.hzh.tree;

import java.util.ArrayList;

/**
 * Created by huzhenhua on 2017/11/1.
 */
public class MedianOfInifiteSeries {
    public static <E extends Comparable> double medianOfInifiteSeries(E[] source, int n){
        Heap maxHeap = new Heap(n/2 + 1, 1);
        Heap minHeap = new Heap(n/2 + 1, 0);
        maxHeap.insert(source[0]);
        for(int i = 1; i < n; i++){
            if(source[i].compareTo(maxHeap.getExtremum()) <= 0){
                if(maxHeap.count + 1 > (i + 2)/2){
                    E data = (E)maxHeap.deleteExtreme();
                    minHeap.insert(data);
                }
                maxHeap.insert(source[i]);
            }
            else if(source[i].compareTo(minHeap.getExtremum()) >= 0) {
                if(minHeap.count + 1 > (i + 1)/2){
                    E data = (E)minHeap.deleteExtreme();
                    maxHeap.insert(data);
                }
                minHeap.insert(source[i]);
            }
            else{
                minHeap.insert(source[i]);
                if(minHeap.count > (i + 1)/2){
                    maxHeap.insert(minHeap.deleteExtreme());
                }
            }
        }
        if(n % 2 == 0){
            return 1;
        }
        else
            return 0;
    }
}
