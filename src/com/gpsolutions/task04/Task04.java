package com.gpsolutions.task04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Alex on 03.03.2017.
 */
public class Task04 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task04\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task04\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException{

        int count, min, minPos, max, maxPos, sum, mult, start, end;

        List<Integer> list = new ArrayList<>();

        Scanner in = new Scanner(inputFile);
        PrintWriter pw = new PrintWriter(outputFile);
        count = in.nextInt();

        if (count == 0) {
            pw.print("0 0");
            pw.close();
        } else {
            for (int i = 0; i < count; i++) {
                list.add(in.nextInt());
            }

            min = list.get(0);
            minPos = 0;
            for (int i = 1; i < list.size(); i++) { //find min
                if (min > list.get(i)) {
                    min = list.get(i);
                    minPos = i;
                }
            }

            max = list.get(0);
            maxPos = 0;
            for (int i = 1; i < list.size(); i++) { //find max
                if (max < list.get(i)) {
                    max = list.get(i);
                    maxPos = i;
                }
            }

            sum = 0;
            for (int i : list) {                    //find sum
                if (i > 0) {
                    sum += i;
                }
            }

            start = Math.min(minPos, maxPos);
            end = Math.max(minPos, maxPos);

            mult = 1;
            for (int i = ++start; i < end; i++) {   //find mult
                mult *= list.get(i);
            }

            pw.print(sum + " " + mult);
            pw.close();
        }
    }
}