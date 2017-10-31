package com.chenchen.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by chenchenhu on 10/28/17.
 * This class keeps all information need for a line in the input
 */
public class Infor {
    public static SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
    String ID; //CMTE_ID
    Date date; //TRANSACTION_DT
    Long val; //TRANSACTION_AMT
    String zip; //ZIP_CODE
    boolean isValid; //indicate whether the input line is a valid record

    public Infor(String line){
        if (line == null || line.length() == 0) {
            isValid = false;
            return;
        }
        parse(line);
    }

    void parse(String line) {
        String[] segs = line.split("\\|");
        if (segs.length != 21) return;
        if (segs[0].length() ==0) return; //recipient ID
        if (segs[14].length() == 0) return; //transaction_amt
        if (segs[15].length()!= 0) return; //otherID
        this.ID = segs[0];
        this.val = Long.parseLong(segs[14]);
        String zip = segs[10];
        if (zip.length()<5) this.zip = null;
        else {
            try {
                int temp = Integer.parseInt(zip.substring(0,5));
                this.zip = zip.substring(0,5);
            } catch (NumberFormatException e) {
                this.zip = null;
            }
        }
        try {
            this.date = sdf.parse(segs[13]);
        } catch (ParseException e) {
            this.date = null;
        }
        if (this.date == null && this.zip == null) return;
        this.isValid = true;
    }
}
