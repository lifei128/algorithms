package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/6/28.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(1534236469));
    }

    public int reverse(int x) {
        if (x == 0) return 0;

        String tmp = "";
        if (x > 0) {
            tmp = String.valueOf(x);
        } else if(x < 0){
            tmp = String.valueOf(x).substring(1);
        }
        char[] chars = tmp.toCharArray();
        for (int i = 0;i < chars.length/2; i++){
            char t = chars[i];
            chars[i] = chars[chars.length - i -1];
            chars[chars.length - i - 1] = t;
        }
        if (Long.parseLong(String.valueOf(chars)) > Integer.MAX_VALUE) return 0;
        if (x > 0){
            return (int)Long.parseLong(String.valueOf(chars));
        } else {
            return 0 - (int)Long.parseLong(String.valueOf(chars));
        }
    }

}
