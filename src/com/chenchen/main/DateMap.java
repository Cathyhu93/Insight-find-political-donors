package com.chenchen.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chenchenhu on 10/28/17.
 * This class keeps all records and group them by (CMTE_ID, TRANSACTION_DT)
 */
public class DateMap {
    TreeMap<String,TreeMap<Date,DateList>> map;
    public DateMap(){
        this.map = new TreeMap<>();
    }

    public void add(Infor a) {
        TreeMap<Date,DateList> submap = map.get(a.ID);
        if (submap == null){
            submap = new TreeMap<>();
            DateList list = new DateList();
            list.add(a.val);
            submap.put(a.date,list);
            map.put(a.ID, submap);
        }else{
            DateList list = submap.get(a.date);
            if (list == null){
                list = new DateList();
            }
            list.add(a.val);
            submap.put(a.date,list);
        }
    }

    public void writeResult(BufferedWriter out) throws IOException {
        for (Map.Entry<String,TreeMap<Date,DateList>> submap: this.map.entrySet()){
            String ID = submap.getKey();
            for(Map.Entry<Date,DateList> entry: submap.getValue().entrySet()){
                OutputInfor result = new OutputInfor();
                DateList list = entry.getValue();
                result.ID = ID;
                result.date = entry.getKey();
                result.count = list.size();
                result.median = list.findMedian();
                result.acc = list.acc;
                String curout = result.toString(false);
                out.write(curout);
                out.newLine();
            }

        }

    }

}
