package com.gpsolutions.task05;

import java.io.*;
import java.util.*;

/**
 * Created by Alex on 16.03.2017.
 */
public class Task05 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task05\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task05\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException{

        int count;
        int arr[];

        Scanner in = new Scanner(inputFile);
        PrintWriter pw = new PrintWriter(outputFile);
        count = in.nextInt();
        count--;
        arr = new int[count*2];
        for (int i = 0; i < count; i++) {
            int c = in.nextInt();
            if (i > 0) {
                arr[i - 1] = c;
                arr[i + count - 1] = c;
            }
            else {
                arr[count - 1] = c;
                arr[count*2 - 1] = c;
            }
        }
        label : for (int i = 1; i <= count; i++) {
            if (count % i == 0) {
                int iter = arr.length / (i);
                for (int j = 1; j < iter; j++) {
                    for (int k = 0; k < i; k++) {
                        if (arr[k] != arr[k + i*j]) {
                            continue label;
                        }
                    }
                }
                pw.print(i);
                break;
            }
        }
        pw.close();
    }
}