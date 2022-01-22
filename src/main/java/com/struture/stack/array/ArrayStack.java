package com.struture.stack.array;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author xpdxz
 * @ClassName ArrayStack
 * @Description TODO
 * @Date 2021/7/18 20:33
 * @Version 1.0
 */
public class ArrayStack {

    /**
     * 栈的大小
     */
    private final int maxStack;
    /**
     * 栈
     */
    private final int[] stack;
    /**
     * 栈顶指针，初始为-1
     */
    private int top;

    /**
     * 初始化栈
     *
     * @param maxStack 栈的大小
     */
    public ArrayStack(int maxStack) {
        this.maxStack = maxStack;
        this.stack = new int[maxStack];
        this.top = -1;
    }

    /**
     * 压栈
     *
     * @param data 数据
     */
    public void push(int data) {
        if (this.isFull()) {
            throw new RuntimeException("栈满，入栈失败！");
        }
        this.top++;
        this.stack[this.top] = data;
    }

    /**
     * 弹栈
     *
     * @return 栈顶元素
     */
    public int pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈空，弹栈失败！");
        }
        int value = this.stack[this.top];
        this.top--;
        return value;
    }

    /**
     * 获取栈的大小
     *
     * @return 栈的大小
     */
    public int maxStack() {
        return this.maxStack;
    }

    public int size() {
        return this.top + 1;
    }

    /**
     * 判断是否空栈
     *
     * @return 空栈
     */
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 判断是否满
     *
     * @return 满
     */
    public boolean isFull() {
        return this.top == this.maxStack - 1;
    }

    /**
     * 返回栈顶元素
     *
     * @return 栈顶元素
     */
    public int top() {
        return this.stack[this.top];
    }

    public void list() {
        if (this.isEmpty()) {
            throw new RuntimeException("栈空，无数据！");
        }
        for (int index = 0; index < this.size(); index++) {
            System.out.print(this.stack[index] + "\t");
        }
        System.out.println();
    }
}
