package com.chenchen.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by chenchenhu on 10/29/17.
 * this class keeps all record for a specific (RecipientID, Transaction_DT) key
 */
public class DateList {
    List<Long> list;
    Long acc = (long) 0;
    public DateList(){
        this.list = new ArrayList<>();
    }
    public void add(Long val){
        this.list.add(val);
        acc+= val;
    }
    public double findMedian(){
        Integer size = list.size();
        if (size % 2 == 0){
            Long left = quickSelect(size/2);
            Long right = quickSelect(size/2+1);
            return (left+right)*1.0/2;
        }
        return quickSelect(size/2+1);
    }

    public int size(){return this.list.size();}

    //this method find the kth largest element in a list
    public long quickSelect(int k) {
        int left = 0, right = list.size()-1;
        while(left<right){
            int pos = partition(left, right);
            if (pos+1 == k) return list.get(pos);
            else if (pos+1 < k){
                left = pos+1;
            }else{
                right = pos-1;
            }
        }
        return list.get(left);
    }
    public int partition(int left, int right){
        Random rd = new Random();
        int ind = rd.nextInt(right-left)+left;
        Long pivot = list.get(ind);
        Collections.swap(list,ind,left);

        while (left<right){
            while(left<right && list.get(right)<= pivot){
                right--;
            }
            list.set(left,list.get(right));
            while(left<right && list.get(left)>= pivot){
                left++;
            }
            list.set(right,list.get(left));
        }
        list.set(left,pivot);
        return left;
    }

}
