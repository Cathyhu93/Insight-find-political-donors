package com.chenchen.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by chenchenhu on 10/31/17.
 */
public class MinMaxHeapTest {
    MinMaxHeap heap;
    @Before
    public void setUp() throws Exception {
        this.heap = new MinMaxHeap();
        heap.add((long) 50);
        heap.add((long) 5);
        heap.add((long) 24);
    }

    @Test
    public void findMedian1() throws Exception {
        Double result = heap.findMedian();
        assertEquals("odd size", 24.0, result,0.0001);
    }

    @Test
    public void findMedian2() throws Exception {
        heap.add((long) 25);
        Double result = heap.findMedian();
        assertEquals("odd size", 24.5, result,0.0001);
    }

}