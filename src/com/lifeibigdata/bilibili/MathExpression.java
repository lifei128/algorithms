package com.lifeibigdata.bilibili;

import java.util.Stack;

/**
 * Created by lifei on 2018/7/19.
 */
public class MathExpression {

    public static void main(String[] args) {
        String s = "(1+2)*3";
        char[] char_arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int sum = 0;
        while (i < char_arr.length){
            if (char_arr[i] == '*'){
            } else if (char_arr[i] == '+'){
                int x = char_arr[i - 1] - '0';
                int y = char_arr[i + 1] = '0';
                sum = x + y;
            } else if (char_arr[i] == '-'){
                int x = char_arr[i - 1] - '0';
                int y = char_arr[i + 1] = '0';
                sum = x + y;
            } else if (char_arr[i] == '/'){

            } else {  //  () 数字
                stack.push(char_arr[i]);
            }
        }
    }
}
