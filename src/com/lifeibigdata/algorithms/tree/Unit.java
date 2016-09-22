package com.lifeibigdata.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 16/9/21.
 */
public class Unit {
    public static void main(String[] args) {
        int n = 5;
        List<String> list = allParentheses(n);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i+1+": "+list.get(i));
        }
    }

    private static List<String> allParentheses(int n) {
        List<String> rst = new ArrayList<>();
        if (n == 0){
            rst.add("");
            return rst;
        }
        if (n == 1){
            rst.add("()");
            return rst;
        }
        List<String> prefix = new ArrayList<>();
        List<String> suffix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prefix = allParentheses(i);
            suffix = allParentheses(n - i -1);
            unit(rst,prefix,suffix);
        }
        return rst;
    }

    private static void unit(List<String> rst, List<String> prefix, List<String> suffix) {
        for (int i = 0; i < prefix.size(); i++) {
            for (int j = 0; j < suffix.size(); j++) {
                String r = "";
                r += "(";
                r += prefix.get(i);
                r += ")";
                r += suffix.get(j);
                rst.add(r);
            }
        }
    }
}
