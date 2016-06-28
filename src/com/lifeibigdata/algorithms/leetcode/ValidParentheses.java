package com.lifeibigdata.algorithms.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by lifei on 16/5/29.
 *
 * 30
 *
 * ( (( () ([])
 *
 *
 * stack.peek()方法： 查看栈顶对象而不移除它
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("([])"));
    }

    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (map.containsKey(curr)){
                stack.push(curr);
            } else if (map.containsValue(curr)) {
                if (!stack.isEmpty() && map.get(stack.pop()).equals(curr)){
                    continue;
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
