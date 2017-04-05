package com.gpsolutions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final File inputFile = new File("INPUT.TXT");
    private static final File outputFile = new File("OUTPUT.TXT");

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(outputFile));
        String[] s1 = reader.readLine().split(" ");
        int level = Integer.parseInt(s1[0]);
        int width = Integer.parseInt(s1[1]);
        int length = Integer.parseInt(s1[2]);
        int[] prince = new int[3];
        //prince     2
        //princess  -2
        //column   -1
        //place     0

        int[][][] cave = new int[level][width][length];
        for (int i1 = 0; i1 < level; i1++) {
            for (int i2 = 0; i2 < width; i2++) {
                String s2 = reader.readLine();
                for (int i3 = 0; i3 < length; i3++) {
                    switch (s2.charAt(i3)) {
                        case '.': cave[i1][i2][i3] = 0; break;
                        case 'o': cave[i1][i2][i3] = -1; break;
                        case '1': cave[i1][i2][i3] = 2; prince[1] = i2; prince[2] = i3; break;
                        case '2': cave[i1][i2][i3] = -2; break;
                    }
                }
            }
            reader.readLine();
        }
        List<int[]> list = new ArrayList<>();
        list.add(prince);
        int start = 0;
        int end = 1;
        int marker = 3;
 label: while (true) {
            for (int i = start; i < end; i++) {
                int[] point = list.get(i);
                int a = point[0];
                int b = point[1];
                int c = point[2];
                //down
                if ((a + 1) < level) {
                    if ((cave[a + 1][b][c] != -1) && ((cave[a + 1][b][c] == 0) ||  (cave[a + 1][b][c] == -2))) {
                        if (cave[a + 1][b][c] == -2) {
                            break label;
                        } else {
                            cave[a + 1][b][c] = marker;
                            list.add(new int[] {a + 1, b, c});
                        }
                    }
                }
                //left
                if ((b - 1) >= 0) {
                    if ((cave[a][b - 1][c] != -1) && ((cave[a][b - 1][c] == 0) ||  (cave[a][b - 1][c] == -2))) {
                        if (cave[a][b - 1][c] == -2) {
                            break label;
                        } else {
                            cave[a][b - 1][c] = marker;
                            list.add(new int[] {a, b - 1, c});
                        }
                    }
                }
                //right
                if ((b + 1) < width) {
                    if ((cave[a][b + 1][c] != -1) && ((cave[a][b + 1][c] == 0) ||  (cave[a][b + 1][c] == -2))) {
                        if (cave[a][b + 1][c] == -2) {
                            break label;
                        } else {
                            cave[a][b + 1][c] = marker;
                            list.add(new int[] {a, b + 1, c});
                        }
                    }
                }
                //back
                if ((c - 1) >= 0) {
                    if ((cave[a][b][c - 1] != -1) && ((cave[a][b][c - 1] == 0) ||  (cave[a][b][c - 1] == -2))) {
                        if (cave[a][b][c - 1] == -2) {
                            break label;
                        } else {
                            cave[a][b][c - 1] = marker;
                            list.add(new int[] {a, b, c - 1});
                        }
                    }
                }
                //forward
                if ((c + 1) < length) {
                    if ((cave[a][b][c + 1] != -1) && ((cave[a][b][c + 1] == 0) ||  (cave[a][b][c + 1] == -2))) {
                        if (cave[a][b][c + 1] == -2) {
                            break label;
                        } else {
                            cave[a][b][c + 1] = marker;
                            list.add(new int[] {a, b, c + 1});
                        }
                    }
                }
            }
            start = end;
            end = list.size();
            marker++;
        }
        writer.print((marker - 2) * 5);
        reader.close();
        writer.close();
    }
}
