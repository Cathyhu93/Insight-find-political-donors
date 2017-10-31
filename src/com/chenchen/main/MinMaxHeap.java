package com.chenchen.main;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by chenchenhu on 10/29/17.
 * This class keeps all record for a specific (CMTE_ID, ZIP_CODE) key in two heaps
 */
public class MinMaxHeap {
    private Queue<Long> min;
    private Queue<Long> max;
    int count;
    Long acc = (long) 0;

    public MinMaxHeap(){
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>();
    }

    public void add(Long num) {
        max.add(num);
        min.add(-max.poll());
        if (max.size() < min.size())
            max.add(-min.poll());
        count++;
        acc+=num;
    }

    public double findMedian() {
        return max.size() > min.size()
                ? max.peek()
                : (max.peek() - min.peek()) / 2.0;
    }
}
