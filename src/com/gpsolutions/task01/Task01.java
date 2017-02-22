package com.gpsolutions.task01;

import java.io.*;

public class Task01 {

    private static final File inputFile = new File("src\\com\\gpsolutions\\task01\\INPUT.TXT");
    private static final File outputFile = new File("src\\com\\gpsolutions\\task01\\OUTPUT.TXT");

    public static void main(String[] args) {
        //long startTime = System.currentTimeMillis();

        int k1, l1, m1, k2, l2, m2 , restedBolt, restedNut, result;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String boltInput = reader.readLine();
            String nutInput = reader.readLine();

            if (boltInput == null || nutInput == null) {        //есть ли 2 строки
                throw new IllegalArgumentException();
            }

            String[] boltArray = boltInput.split("\\s+"); //1 или более пробелов между числами
            String[] nutArray = nutInput.split("\\s+");

            if (boltArray.length < 3 || nutArray.length < 3) {
                throw new IllegalArgumentException();
            }
            k1 = Integer.parseInt(boltArray[0]);
            l1 = Integer.parseInt(boltArray[1]);
            m1 = Integer.parseInt(boltArray[2]);

            k2 = Integer.parseInt(nutArray[0]);
            l2 = Integer.parseInt(nutArray[1]);
            m2 = Integer.parseInt(nutArray[2]);

            if (k1 < 100 || k1 > 30000 || l1 < 0 || l1 > 100 || m1 < 1 || m1 > 100 ||
                    k2 < 100 || k2 > 30000 || l2 < 0 || l2 > 100 || m2 < 1 || m2 > 100) {  //проверка значений
                throw new IllegalArgumentException();
            }

            restedBolt = k1 - (k1*l1)/100;
            restedNut = k2 - (k2*l2)/100;

            if (restedBolt < restedNut) {
                result = (k1 - restedBolt)*m1 + (k2 - restedBolt)*m2;
            }
            else {
                result = (k1 - restedNut)*m1 + (k2 - restedNut)*m2;
            }

            writer.write(String.valueOf(result));
        }
        catch (NumberFormatException e) {
            System.out.println("Data is not number");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Wrong input data");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("Error IO");
        }
        //long stopTime = System.currentTimeMillis();
        //System.out.println("Calculating time: " + (stopTime - startTime) + " milliseconds");
    }
}