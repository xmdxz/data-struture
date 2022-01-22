package com.struture.stack;

import com.struture.stack.array.ArrayStack;
import com.struture.stack.array.CalculatorStack;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @Author xpdxz
 * @ClassName StackTest
 * @Description TODO
 * @Date 2021/7/19 14:24
 * @Version 1.0
 */
class StackTest {

    @Test
    void arrayStack() {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int index = 0; index < arrayStack.maxStack(); index++) {
            arrayStack.push(index);
        }
        arrayStack.list();
    }

    @Test
    void detection() {
        Scanner scanner = new Scanner(System.in);
        String detection = scanner.nextLine();
        System.out.println("用户输入：" + detection);
        ArrayStack arrayStack = new ArrayStack(detection.length());
        for (int index = 0; index < detection.length(); index++) {
            arrayStack.push(detection.charAt(index));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = arrayStack.size();
        for (int index = 0; index < size; index++) {
            stringBuilder.append((char) arrayStack.pop());
        }
        String instead = new String(stringBuilder);
        System.out.println(instead);
        if (instead.equals(detection)) {
            System.out.println("是回文");
        } else {
            System.out.println("不是回文");
        }
    }

    @Test
    void caculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入计算：");
        String calculation = scanner.nextLine();
        CalculatorStack calculatorStack = new CalculatorStack(calculation);
        System.out.println(calculatorStack.result());
    }


}
