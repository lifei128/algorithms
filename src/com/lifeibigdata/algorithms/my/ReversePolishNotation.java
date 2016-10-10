package com.lifeibigdata.algorithms.my;

import java.util.Stack;

/**
 * Created by lifei on 16/9/23.
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        char[] str = {'2','1','+','3','*'};
        int value = reversePolishNotation(str);
        System.out.println(value);
    }

    private static int reversePolishNotation(char[] str) {
        Stack<Integer> s = new Stack<>();
        int a,b;
        char token = ' ';
        for (int i = 0; i < str.length; i++) {
            token = str[i];
            if (!isOperator(token)){//判断是否是符号
                s.push(Integer.parseInt(String.valueOf(token))); //TODO
            } else {//TODO
                b = s.pop();
                a = s.pop();
                if (token == '+'){
                    s.push(a + b);
                } else if (token == '-'){
                    s.push(a - b);
                } else if(token == '*'){
                    s.push(a * b);
                } else {
                    s.push(a / b);
                }
            }
        }
        return s.pop();
    }

    private static boolean isOperator(char token) {
        return (token == '+' || token == '-' || token == '*' || token == '/');
    }
}
