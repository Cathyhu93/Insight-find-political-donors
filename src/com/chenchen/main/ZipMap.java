package com.chenchen.main;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by chenchenhu on 10/28/17.
 * this class keeps all records and group them by (CMTE_ID,ZIP_CODE)
 */
public class ZipMap {
    HashMap<String, HashMap<String,MinMaxHeap>> map;

    public ZipMap(){
        this.map = new HashMap<>();
    }

    public void add(Infor a) {
        HashMap<String,MinMaxHeap> submap = map.get(a.ID);
        if (submap == null) {
            submap = new HashMap<>();
            MinMaxHeap heap = new MinMaxHeap();
            heap.add(a.val);
            submap.put(a.zip,heap);
            map.put(a.ID, submap);
        }else{
            MinMaxHeap heap = submap.get(a.zip);
            if (heap == null){
                heap = new MinMaxHeap();
            }
            heap.add(a.val);
            submap.put(a.zip,heap);
        }
    }

    public String getCurResult(Infor a) {
//        if (map.get(a.ID) == null || map.get(a.ID).get(a.zip) == null) return "";
        OutputInfor out = new OutputInfor();
        MinMaxHeap heap = map.get(a.ID).get(a.zip);
        out.median = heap.findMedian();
        out.acc = heap.acc;
        out.count = heap.count;
        out.zip = a.zip;
        out.ID = a.ID;
        return out.toString(true);
    }
}
