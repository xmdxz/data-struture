package com.struture.tree.application;

import com.struture.util.ArrayUtil;

import java.util.Arrays;

/**
 * @Author xpdxz
 * @ClassName HeapSort
 * @Description 堆排序
 * @Date 2022/1/15 11:24
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] array = ArrayUtil.initArray(10, 100);
        System.out.println("排序前:" + Arrays.toString(array));
        heapSort(array);
        System.out.println("排序后:" + Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        int sortNum = array.length;
        while (sortNum > 1) {
            int nonLeafIndex = (sortNum / 2) - 1;
            for (int i = nonLeafIndex; i >= 0; i--) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int max = right < sortNum ? Math.max(array[left], array[right]) : array[left];
                if (array[i] < max) {
                    if (right < sortNum && array[right] == max) {
                        array[i] = array[i] ^ array[right];
                        array[right] = array[i] ^ array[right];
                        array[i] = array[i] ^ array[right];
                    } else {
                        array[i] = array[i] ^ array[left];
                        array[left] = array[i] ^ array[left];
                        array[i] = array[i] ^ array[left];
                    }
                }
                System.out.println(Arrays.toString(array));
            }
            array[0] = array[0] ^ array[sortNum - 1];
            array[sortNum - 1] = array[0] ^ array[sortNum - 1];
            array[0] = array[0] ^ array[sortNum - 1];
            System.out.println(Arrays.toString(array) + "=====");
            sortNum--;
        }
    }

}
