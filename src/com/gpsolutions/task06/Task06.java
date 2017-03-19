package com.gpsolutions.task06;

import java.io.*;

/**
 * Created by Alex on 16.03.2017.
 */
public class Task06 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task06\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task06\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String s = reader.readLine();

        int count = 0;
        if (s != null) {
            char[] chars = s.toCharArray();
            if (chars.length > 4) {
                for (int i = 0; i < chars.length - 4; i++) {
                    if (chars[i] == '>') {
                        if (chars[i + 1] == '>') {
                            if (chars[i + 2] == '-') {
                                if (chars[i + 3] == '-') {
                                    if (chars[i + 4] == '>') {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                    else if (chars[i] == '<') {
                        if (chars[i + 1] == '-') {
                            if (chars[i + 2] == '-') {
                                if (chars[i + 3] == '<') {
                                    if (chars[i + 4] == '<') {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        writer.print(count);
        reader.close();
        writer.close();
    }
}