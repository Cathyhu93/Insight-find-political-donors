package com.chenchen.main;

import static org.junit.Assert.*;

/**
 * Created by chenchenhu on 10/29/17.
 */
public class DateListTest {
    DateList dl;
    @org.junit.Before
    public void setUp() throws Exception {
        this.dl = new DateList();
        dl.add((long) 5);
        dl.add((long) 500);
        dl.add((long) 24);
    }

    @org.junit.Test
    public void findMedian1() throws Exception {
        Double result = dl.findMedian();
        assertEquals("odd length",24.0,result,0.001);
    }

    @org.junit.Test
    public void findMedian2() throws Exception {
        dl.add((long) 25);
        Double result = dl.findMedian();
        assertEquals("even length", 24.5,result, 0.001);
    }

}