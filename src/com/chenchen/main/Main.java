package com.chenchen.main;

import java.io.*;

/**
 * Created by chenchenhu on 10/27/17.
 */
public class Main {

    public static void main(String[] args){
        if (args.length < 3){
            System.out.println("Usage: [inputPath] [medians_by_zip path] [medians_by_date path]");
            return;
        }

        String inputPath = args[0];
        String zipOutPath = args[1];
        String dateOutPath = args[2];
        DateMap dateMap = new DateMap();
        ZipMap zipMap = new ZipMap();
        BufferedWriter dateOut;


        try (BufferedReader br = new BufferedReader(new FileReader(inputPath)); BufferedWriter zipOut = new BufferedWriter(new FileWriter(zipOutPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Infor cur = new Infor(line);
                if (cur.isValid){
                    dateMap.add(cur);
                    zipMap.add(cur);
                    String curout = zipMap.getCurResult(cur);
                    zipOut.write(curout);
                    zipOut.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            dateOut = new BufferedWriter(new FileWriter(dateOutPath));
            dateMap.writeResult(dateOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
