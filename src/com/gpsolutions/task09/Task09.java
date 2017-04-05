package com.gpsolutions.task09;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Alex on 16.03.2017.
 */
public class Task09 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task09\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task09\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String in = reader.readLine();
        if (in == null) {
            writer.print("ERROR");
        }
        else {
            in = in.replaceAll(" ", "");
            Pattern p = Pattern.compile("^(-|\\+)?\\d+(\\+|-|\\*|/)(-|\\+)?\\d+=(-|\\+)?\\d+$");
            Matcher m = p.matcher(in);

            Pattern p8 = Pattern.compile("(.*-|\\+)?0\\d+.*");
            Matcher m8 = p8.matcher(in);
            if (!m.matches() || m8.matches() || in.equals("") ) {
                writer.print("ERROR");
            }
            else {

                Pattern p1 = Pattern.compile("^(-|\\+)?\\d+");
                Matcher m1 = p1.matcher(in);
                double i1 = 0;
                if(m1.find()){
                    i1 = Double.parseDouble(m1.group());
                }
                Pattern p2 = Pattern.compile("(\\+|-|\\*|/)(-|\\+)?\\d+=");
                Matcher m2 = p2.matcher(in);
                double i2 = 0;
                if(m2.find()){
                    String temp = m2.group();
                    i2 = Double.parseDouble(temp.substring(1,temp.length()-1));
                }
                Pattern p3 = Pattern.compile("=(-|\\+)?\\d+");
                Matcher m3 = p3.matcher(in);
                double i3 = 0;
                if(m3.find()){
                    i3 = Double.parseDouble(m3.group().substring(1));
                }
                Pattern p4 = Pattern.compile("(\\+|-|\\*|/)(-|\\+)?\\d+=");
                Matcher m4 = p4.matcher(in);
                String i4 = "";
                if(m4.find()){
                    i4 = m4.group().substring(0,1);
                }
                if (i4.equals("/") && i2 == 0) {
                    writer.print("NO");
                }
                else {
                    if (Math.abs(i1) > 30000 || Math.abs(i2) > 30000 || Math.abs(i3) > 30000) {
                        writer.print("ERROR");
                    } else {
                        double result = 0;
                        switch (i4) {
                            case "-" : result = i1 - i2;
                                break;
                            case "+" : result = i1 + i2;
                                break;
                            case "*" : result = i1 * i2;
                                break;
                            case "/" : result = i1 / i2;
                                break;
                        }
                        if (result == i3) {
                            writer.print("YES");
                        }
                        else {
                            writer.print("NO");
                        }
                    }
                }
            }
        }

        reader.close();
        writer.close();
    }
}