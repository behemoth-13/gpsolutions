package com.gpsolutions.taskFinal;

import java.util.Arrays;

/**
 * Created by Alex on 12.04.2017.
 */
public class taskFinal {
    public static void main(String[] args) {
        int[] a = {1,1,3,4,7,11,13,15};
        int[] b = {1,2,3,5,8,8};
        int[] c = new int[a.length + b.length];
        int a1 = 0;
        int b1 = 0;
        for (int i = 0; i < c.length; i++) {
            if (a1 == a.length) {
                c[i] = b[b1];
                b1++;
            } else if (b1 == b.length) {
                c[i] = a[a1];
                a1++;
            } else if (a[a1] <= b[b1]) {
                c[i] = a[a1];
                a1++;
            } else {
                c[i] = b[b1];
                b1++;
            }
        }
        System.out.println(Arrays.toString(c));
    }
}
