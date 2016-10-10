package com.lifeibigdata.algorithms.blog;

/**
 * Created by lifei on 16/10/7.
 */
public class LeftRotateString2 {

    public static void main(String[] args) {
        char[] data = "abcdef".toCharArray();
        leftRotateString(data,data.length,8);
        System.out.println(new String(data));
    }
    static void leftRotateString(char[] s,int n,int m){
        m %= n;
        reverseString(s,0,m - 1);
        reverseString(s,m,n - 1);
        reverseString(s,0,n - 1);
    }

    private static void reverseString(char[] s, int from, int to) {
        while (from < to){
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;
        }
    }
}
