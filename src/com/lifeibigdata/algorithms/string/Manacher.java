package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/10/8.
 */
public class Manacher {
    public static void main(String[] args) {
        String s = "$#1#2#2#1#2#3#2#1#";
        int[] p = new int[s.length()];
        manacher2(s.toCharArray(),p);
        for (int x:p) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    static void manacher(char[] s,int[] p){
        p[0] = 1;
        int id = 0;
        int mx = 1;
        for (int i = 1; i < s.length; i++) {
            if (mx > i){
                p[i] = Math.min(p[2 * id - i],mx - i);
            } else {
                p[i] = 1;
            }
//            for (;s[i + p[i]] == s[i - p[i]];p[i]++);
            while (i - p[i] >= 0 && i + p[i] < s.length && s[i + p[i]] == s[i - p[i]]){
                p[i] += 1;
            }
            if (mx < i+p[i]){
                mx = i + p[i];
                id = i;
            }
        }
    }

    static void manacher2(char[] s,int[] p){
        p[0] = 1;
        int id = 0;
        int mx = 1;
        for (int i = 1; i < s.length; i++) {
            if (mx > i){
                if (p[2 * id - i] != mx - i){
                    p[i] = Math.min(p[2 * id - i],mx - i);
                } else {
                    p[i] = p[2 * id - i];
//                    for (;s[i + p[i]] == s[i - p[i]];p[i]++);
                    while (i - p[i] >= 0 && i + p[i] < s.length && s[i + p[i]] == s[i - p[i]]){
                        p[i] += 1;
                    }
                }
            } else {
                p[i] = 1;
//                for (;s[i + p[i]] == s[i - p[i]];p[i]++);
                while (i - p[i] >= 0 && i + p[i] < s.length && s[i + p[i]] == s[i - p[i]]){
                    p[i] += 1;
                }
            }
            if (mx < i + p[i]){
                mx = i + p[i];
                id = i;
            }
        }
    }
}
