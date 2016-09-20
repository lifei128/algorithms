package com.lifeibigdata.algorithms.sort;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lifei on 16/9/20.
 */
public class WordBreak2 {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        String str = "catsanddog";
        boolean b = wordBreak2(dict,str);
        System.out.println(b);


        int[] f = new int[str.length() + 1];//f[i]:str[0...i-1]是否在词典中
        f[0] = 1;
        int y = wordBreak3(dict,str,f);
        System.out.println(y);
    }

    //DP
    private static boolean wordBreak(Set<String> dict, String str) {
        boolean[] f = new boolean[str.length() + 1];//f[i]:str[0...i-1]是否在词典中
        f[0] = true;
        for (int i = 1; i <=str.length() ; i++) {//str[0...i-1:长度为i]
            for (int j = i - 1; j >= 0 ; j--) {
                //iterator find(value)返回value所在位置，找不到value将返回end() c++
                if (f[j] && dict.contains(str.substring(j,i ))){//str[j...i-1]   java中没有找到substr,用substring代替
                    f[i] = true;
                    break;
                }
            }
        }
        return f[str.length()];
    }

    //递归
    private static boolean wordBreak2(Set<String> dict, String str) {
        if (str.length() == 0)
            return true;
        for (int i = str.length() - 1; i >=0 ; i--) {
            if (wordBreak2(dict,str.substring(0,i))
                    && dict.contains(str.substring(i,str.length())))
                return true;
        }
        return false;
    }

    //
    private static int wordBreak3(Set<String> dict, String str,int[] f) {

        for (int i = str.length() - 1;i >= 0;i--) {
            if (f[i] == 0)
                f[i] = wordBreak3(dict,str.substring(0,i),f);
            if (f[i] == 1 && dict.contains(str.substring(i,str.length())))
                return 1;

        }
        return -1;
    }
}
