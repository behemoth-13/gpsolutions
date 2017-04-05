package com.gpsolutions.task08;

import java.io.*;
import java.util.Scanner;


/**
 * Created by Alex on 16.03.2017.
 */
public class Task08 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task08\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task08\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(inputFile);
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        double dept = Double.MAX_VALUE;
        int n = in.nextInt();
        double c = in.nextInt();
        double p = in.nextLong();
        double[][] arr = new double[n][2];
        double[] inet = new double[2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }
        inet[0] = in.nextInt();
        inet[1] = in.nextInt();

        for (int i = 0; i < n; i++) {
            double length = Math.sqrt(Math.pow(Math.abs(arr[i][0] - inet[0]), 2) + Math.pow(Math.abs(arr[i][1] - inet[1]), 2));
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    length += Math.sqrt(Math.pow(Math.abs(arr[j][0] - arr[i][0]), 2) + Math.pow(Math.abs(arr[j][1] - arr[i][1]), 2));
                }
            }
            double tempDept = c * length;
            if (tempDept < dept) {
                dept = tempDept;
            }
        }
        if (dept > p) {
            writer.print("NO");
        }
        else {
            writer.print("YES");
        }
        writer.close();
    }
}