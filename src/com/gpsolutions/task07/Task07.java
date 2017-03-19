package com.gpsolutions.task07;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 16.03.2017.
 */
public class Task07 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task07\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task07\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException{
        int answer = 1;
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] p1 = s1.toCharArray();
        char[] p2 = s2.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p1.length; i++) {

            boolean[] b1 = new boolean[10];
            if (p1[i] > 47 && p1[i] < 58) {
                int var = p1[i] - 48;
                b1[var] = true;
            } else if (p1[i] >= 97 && p1[i] < 104) {
                int var = p1[i] - 97;
                for (int j = 0; j < 4; j++) {
                    b1[var++] = true;
                }
            } else if (p1[i] == '?') {
                for (int k = 0; k < b1.length; k++) {
                    b1[k] = true;
                }
            }

            boolean[] b2 = new boolean[10];
            if (p2[i] > 47 && p2[i] < 58) {
                int var = p2[i] - 48;
                b2[var] = true;
            } else if (p2[i] >= 97 && p2[i] < 104) {
                int var = p2[i] - 97;
                for (int j = 0; j < 4; j++) {
                    b2[var++] = true;
                }
            } else if (p2[i] == '?') {
                for (int k = 0; k < b2.length; k++) {
                    b2[k] = true;
                }
            }
            int coincidence = 0;
            for (int k = 0; k < 10; k++) {
                if (b1[k] && b2[k]) {
                    coincidence++;
                }
            }
            answer = answer * coincidence;
        }
        writer.print(answer);
        reader.close();
        writer.close();
    }
}