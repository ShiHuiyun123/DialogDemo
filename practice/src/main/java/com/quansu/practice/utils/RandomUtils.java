package com.quansu.practice.utils;

import java.util.Random;

/**
 * Created by com.ysnows on 2017/7/15.
 */

public class RandomUtils {

    public static final char[] LETTER_NUMBER = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static final char[] LETTER = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static final char[] NUMBER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * Generate random numbers in < b > 26 English letters </b > by specified size
     *
     * @param t Generated length, t cannot be less than 1 or greater than 99, otherwise return "0"
     *
     * @return Random number you want
     *
     *
     * @author Belen
     */
    public static String getRandomOfLetter(int t) {
        return get(LETTER, t);
    }

    /**
     * Generating Random Numbers in <b>0-9</b>Numbers by Designated Size
     *
     * @param t Generated length, t cannot be less than 1 or greater than 99, otherwise return "0"
     *
     * @return Random number you want
     *

     * @author Belen
     */
    public static String getRandomOfNumber(int t) {
        return get(NUMBER, t);
    }

    /**
     * Random numbers are generated in <b>25 English and 10 numbers </b> according to the specified size.
     *
     * @param t Generated length, t cannot be less than 1 or greater than 99, otherwise return "0"
     *
     * @return Random number you want
     *
     * @created From May to 16, 2013, 02:40:05 p.m.
     * @author Belen
     */
    public static String getRandomOfLetterAndNumber(int t) {
        return get(LETTER_NUMBER, t);
    }

    /**
     * Generate data by a specified array.
     */
    private static String get(char[] c, int t) {
        if (t < 1 || t > 99) {
            return "0";
        }

        final int maxNum = 36;
        int i;
        int count = 0;

        StringBuffer sb = new StringBuffer("");
        Random r = new Random();
        while (count < t) {
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < c.length) {
                sb.append(c[i]);
                count++;
            }
        }
        return sb.toString();
    }
}
