package com.struture.algorithm;

import java.util.Scanner;

/**
 * @Author xpdxz
 * @ClassName LeastCommonMultiple
 * @Description TODO
 * @Date 2021/11/28 13:50
 */
public class LeastCommonMultiple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入两个数：");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        if (num2 <= 0 || num1 <= 0) {
            System.out.println("非法输入");
        } else {
            int greatestCommonDivisor = getGreatestCommonDivisor(num1, num2);
            num1 = num1 / greatestCommonDivisor;
            num2 = num2 / greatestCommonDivisor;
            System.out.printf("最小公倍数为：%d\n", num1 * num2 * greatestCommonDivisor);
        }
    }

    /**
     * 获取最大公约数
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int getGreatestCommonDivisor(int num1, int num2) {
        int remainder = num1 % num2;
        return remainder == 0 ? num2 : getGreatestCommonDivisor(num2, remainder);
    }

}
