package com.struture.util;

import java.util.Random;

/**
 * @Author xpdxz
 * @ClassName ArrayUtil
 * @Description TODO
 * @Date 2021/9/15 21:58
 * @Version 1.0
 */
public class ArrayUtil {
    private static final Random RANDOM = new Random();

    public static int[] initArray(int length) {
        return initArray(length, Integer.MAX_VALUE);
    }

    public static int[] initArray(int length, int maxValue) {
        int[] array = new int[length];
        for (int index = 0; index < length; index++) {
            array[index] = RANDOM.nextInt(maxValue);
        }
        return array;
    }
}
