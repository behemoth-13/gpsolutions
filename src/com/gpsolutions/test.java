package com.gpsolutions;

import java.util.*;

public class test {

    public static int ARRAY_LENGTH = 30;
    private static int[] array = new int[ARRAY_LENGTH];
    private static Random generator = new Random();

    public static void initArray() {
        for (int i=0; i<ARRAY_LENGTH; i++) {
            array[i] = generator.nextInt(100);
        }
    }

    public static void printArray() {
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort() {
        int startIndex = 0;
        int endIndex = ARRAY_LENGTH - 1;
        doSort(startIndex, endIndex);
    }

    private static void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i + (j - i) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = map.keySet();
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        for (Map.Entry<String, Integer> pair : entry) {
            pair.getKey();
        }
        initArray();
        String s = "c";
        s.concat("b");
        printArray();
        quickSort();
        printArray();
    }
}