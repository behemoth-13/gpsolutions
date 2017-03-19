package com.gpsolutions.task03;

import java.io.*;

/**
 * Created by Alex on 02.03.2017.
 */
public class Task03 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task03\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task03\\OUTPUT.TXT");

    public static void main(String[] args) throws IOException {

        char startLetter, finishLetter, startInt, finishInt;
        String result;

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String in = reader.readLine();
        String isNull = reader.readLine();
        if (in.length() != 5 || isNull != null) {
            result = "ERROR";
        }
        else {
            in = in.toUpperCase();
            startLetter = in.charAt(0);
            startInt = in.charAt(1);
            finishLetter = in.charAt(3);
            finishInt = in.charAt(4);

            boolean startL = (startLetter >= 'A' && startLetter <= 'H') || (startLetter >= 'a' && startLetter <= 'h');
            boolean finishL = (finishLetter >= 'A' && finishLetter <= 'H') || (finishLetter >= 'a' && finishLetter <= 'h');

            if ( !startL || !finishL
                    || startInt > '8' || finishInt > '8' || startInt < '1' || finishInt < '1' || in.charAt(2) != '-') {
                result = "ERROR";
            }
            else {
                int difLetter = Math.abs(startLetter - finishLetter);
                int difInt = Math.abs(startInt - finishInt);
                int sum = difLetter + difInt;
                if (difLetter < 1 || difLetter > 2 || sum != 3) {
                    result = "NO";
                }
                else {
                    result = "YES";
                }
            }
        }
        writer.write(result);
        reader.close();
        writer.close();
    }
}