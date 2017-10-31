package com.chenchen.main;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenchenhu on 10/29/17.
 * this class specifies the output format
 */
public class OutputInfor {
    public static SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
    public String ID;
    public String zip;
    public Date date;
    public Integer count;
    public Long acc;
    public Double median;

    public String toString(boolean iszip){
        StringBuilder sb = new StringBuilder();
        sb.append(ID+"|");
        if (iszip) sb.append(this.zip);
        else sb.append(sdf.format(date));
        sb.append("|");
        sb.append(Math.round(median)+"|");
        sb.append(count+"|");
        sb.append(acc);
        return sb.toString();
    }
}
