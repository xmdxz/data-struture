package com.struture.algorithm;

import com.struture.util.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author xpdxz
 * @ClassName SortTest
 * @Description TODO
 * @Date 2021/10/6 16:25
 * @Version 1.0
 */

class SortTest {

    @Test
    void radixSort() {
        int[] arrays = ArrayUtil.initArray(10, 9999);
        System.out.println(Arrays.toString(arrays));
        System.out.println("=====================================");
        int maxLength = arrays[0];
        for (int array : arrays) {
            if (maxLength < array) {
                maxLength = array;
            }
        }
        maxLength = String.valueOf(maxLength).length();
        int[][] bucket = new int[10][arrays.length];
        int[] statistics = new int[10];
        int multiple = 10;
        for (int index = 0; index < maxLength; index++) {
            for (int array : arrays) {
                int instead = (array / multiple) % 10;
                bucket[instead][statistics[instead]] = array;
                statistics[instead]++;
            }
            int instead = 0;
            for (int i = 0; i < 10; i++) {
                if (statistics[i] != 0) {
                    for (int j = 0; j < statistics[i]; j++) {
                        arrays[instead] = bucket[i][j];
                        bucket[i][j] = 0;
                        instead++;
                    }
                    statistics[i] = 0;
                }
            }
            multiple *= 10;
            System.out.println(Arrays.toString(arrays));
        }
        System.out.println("==================================");
        System.out.println(Arrays.toString(arrays));
    }

    @Test
    void bubbleSort() {
        int[] arrays = ArrayUtil.initArray(10, 100);
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    arrays[j] = arrays[j] ^ arrays[j + 1];
                    arrays[j + 1] = arrays[j] ^ arrays[j + 1];
                    arrays[j] = arrays[j] ^ arrays[j + 1];
                }
            }
        }
        System.out.println(Arrays.toString(arrays));
    }

    @Test
    void quickSort() {
        int[] arrays = ArrayUtil.initArray(10, 9999);
        quickSortImpl(arrays, 0, arrays.length - 1);
        System.out.println(Arrays.toString(arrays));
    }

    private void quickSortImpl(int[] instead, int start, int end) {
        if (end < start) {
            return;
        }
        int sentinel = instead[start];
        int l = start;
        int r = end;
        while (l != r) {
            while (instead[r] >= sentinel && r > l) {
                r--;
            }
            while (instead[l] <= sentinel && l < r) {
                l++;
            }
            if (r > l) {
                int temp = instead[l];
                instead[l] = instead[r];
                instead[r] = temp;
            }
        }
        instead[start] = instead[l];
        instead[l] = sentinel;
        quickSortImpl(instead, start, l - 1);
        quickSortImpl(instead, l + 1, end);
    }

    @Test
    void insertionSort() {
        int[] arrays = ArrayUtil.initArray(999, 9999);
        long time = System.currentTimeMillis();
        System.out.println(time);
        System.out.println(Arrays.toString(arrays));
        for (int i = 0; i < arrays.length; i++) {
            int instead = arrays[i];
            int j = i - 1;
            while (j >= 0) {
                if (instead > arrays[j]) {
                    break;
                }
                j--;
            }
            j++;
            if (j != i) {
                System.arraycopy(arrays, j, arrays, j + 1, i - j);
                arrays[j] = instead;
            }
//            for (int j = i; j >= 1; j--) {
//                if (arrays[j] < arrays[j - 1]) {
//                    int temp = arrays[j];
//                    arrays[j] = arrays[j - 1];
//                    arrays[j - 1] = temp;
//                }
//            }
            System.out.println(Arrays.toString(arrays));
        }

        System.out.println(Arrays.toString(arrays));
        System.out.println(System.currentTimeMillis() - time);
    }

    @Test
    void selectSort() {
        int[] arrays = ArrayUtil.initArray(10, 9999);
        for (int i = 0; i < arrays.length; i++) {
            int min = i;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[min] > arrays[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arrays[i];
                arrays[i] = arrays[min];
                arrays[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arrays));
    }
}
