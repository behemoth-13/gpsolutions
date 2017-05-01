package com.gpsolutions.taskFinal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Alex on 28.04.2017.
 */
public class taskFinal2 {
    public static void main(String[] args) {
        /*int iter = 1000000;
        List<Long> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < iter; i++) {
            list.add( 6546745445645623676L);
        }
        Date dateStrart1 = new Date();
        for (long l : list) {
            list1.add(getPlusMinusSum1(l));
        }
        System.out.println(new Date().getTime() - dateStrart1.getTime());*/

        getPlusMinusSum2(4756);
    }

    static int getPlusMinusSum1 (long in) {
        List<Integer> list = new ArrayList<>();
        int result = 0;

        while (in / 10 != 0) {
            list.add((int) in % 10);
            in = in / 10;
        }
        list.add((int) in % 10); // 1 ошибка
        if (list.size() == 1) {
            result = list.get(0);
        } else {
            for (int i = list.size() - 1; i >= 0; i--) { // 2 ошибка
                boolean plus = true;
                int sum = 0;
                for (int j = list.size() - 1; j >= 0; j--) { // 2 ошибка
                    if (j != i) {
                        if(plus) {
                            sum += list.get(j);
                            plus = false;
                        } else {
                            sum -= list.get(j);
                            plus = true;
                        }
                    }

                }
                if (sum > result) {
                    result = sum;
                }
            }
        }
        return result;
    }

    static int getPlusMinusSum2 (long in) {
        List<Integer> list = new ArrayList<>();
        int result = 0;

        while (in / 10 != 0) {
            list.add((int) in % 10);
            in = in / 10;
        }
        list.add((int) in % 10); // 1 ошибка
        if (list.size() == 1) {
            result = list.get(0);
        } else {
            int tempSum = 0;
            for (int i = 0; i < list.size(); i++) {
                int sum = 0;
                boolean plus = (list.size() - i) % 2 == 0;
                boolean plusEnds = plus;
                for (int j = i; j < list.size(); j++) {
                    if (j != i) {
                        if (plus) {
                            sum += list.get(j);
                            sum -= tempSum;
                            plus = false;
                        } else {
                            sum -= list.get(j);
                            sum += tempSum;
                            plus = true;
                        }
                    }
                }
                if (sum > result) {
                    result = sum;
                }
                if (plusEnds) {
                    tempSum -= list.get(i);
                } else {
                    tempSum += list.get(i);
                }
            }
        }
        return result;
    }

    @Test
    public void testMethods() {
        long l = 23175556784L;
        assertEquals(getPlusMinusSum1(l), getPlusMinusSum2(l));
    }
}
