package com.gpsolutions.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task02 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task02\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task02\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException {

        int count;
        String even = "";
        String odd = "";
        List<Integer> evenList = new ArrayList<>();  //четный   4
        List<Integer> oddList = new ArrayList<>();   //нечетный 3

        Scanner in = new Scanner(inputFile);
        PrintWriter pw = new PrintWriter(outputFile);
        count = in.nextInt();

        for (int i = 0; i < count; i++) {
            int day = in.nextInt();
            if (day % 2 == 0) {
                evenList.add(day);
            }
            else {
                oddList.add(day);
            }
        }

        for (int i = 0; i < oddList.size() - 1; i++) {
            odd += (oddList.get(i) + " ");
        }
        odd += (oddList.get(oddList.size() - 1));

        for (int i = 0; i < evenList.size() - 1; i++) {
            even += (evenList.get(i) + " ");
        }
        even += (evenList.get(evenList.size() - 1));
        pw.println(odd);
        pw.println(even);
        if (evenList.size() >= oddList.size()) {
            pw.print("YES");
        }
        else {
            pw.print("NO");
        }
        pw.close();
    }
}