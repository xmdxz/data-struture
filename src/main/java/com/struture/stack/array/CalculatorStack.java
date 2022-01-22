package com.struture.stack.array;

/**
 * @Author xpdxz
 * @ClassName CalculatorStack
 * @Description TODO
 * @Date 2021/7/19 15:42
 * @Version 1.0
 */
public class CalculatorStack {

    private ArrayStack numStack;

    private ArrayStack operatorStack;

    /**
     * 初始化栈
     *
     * @param calculator 计算
     */
    public CalculatorStack(String calculator) {
        initializationStack(calculator);
    }

    /**
     * 将字符串解析并初始化栈
     *
     * @param calculator 字符串
     */
    private void initializationStack(String calculator) {
        char[] chars = calculator.toCharArray();
        this.numStack = new ArrayStack(chars.length);
        this.operatorStack = new ArrayStack(chars.length);
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < chars.length; index++) {
            if (this.isOperator(chars[index])) {
                numStack.push(Integer.parseInt(stringBuilder.toString()));
                stringBuilder = new StringBuilder();
                if (operatorStack.isEmpty()) {
                    operatorStack.push(chars[index]);
                } else {
                    if (this.priority(operatorStack.top()) >= this.priority(chars[index])) {
                        numStack.push(this.calcute(numStack.pop(), numStack.pop(), operatorStack.pop()));
                        operatorStack.push(chars[index]);
                    } else {
                        operatorStack.push(chars[index]);
                    }
                }
            } else {
                if (index == chars.length - 1) {
                    stringBuilder.append(chars[index]);
                    numStack.push(Integer.parseInt(stringBuilder.toString()));
                } else {
                    stringBuilder.append(chars[index]);
                }
            }
        }
    }

    /**
     * 判断是否是运算符
     *
     * @param data 数据
     * @return 真假
     */
    public boolean isOperator(int data) {
        return data == '+' || data == '-' || data == '*' || data == '/';
    }

    /**
     * 运算符优先级
     *
     * @param data 运算符
     * @return 优先级
     */
    public int priority(int data) {
        if (data == '*' || data == '/') {
            return 1;
        } else if (data == '+' || data == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 计算
     *
     * @param num1     栈顶元素
     * @param num2     栈顶第二元素
     * @param operator 运算符
     * @return 运算结果
     */
    public int calcute(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 获取运算结果
     *
     * @return 运算结果
     */
    public int result() {
        if (this.numStack.isEmpty()) {
            throw new RuntimeException("运算数为空，请重试！");
        }
        while (true) {
            if (this.operatorStack.isEmpty()) {
                return numStack.pop();
            }
            numStack.push(this.calcute(numStack.pop(), numStack.pop(), operatorStack.pop()));
        }
    }
}
