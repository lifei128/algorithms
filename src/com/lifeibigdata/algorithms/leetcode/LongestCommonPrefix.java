package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/29.
 *
 * 14
 * 判断输入的多个字符串的公有前序
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println("");
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }

        if(strs.length==1)
            return strs[0];

        int minLen = strs.length+1;

        for(String str: strs){
            if(minLen > str.length()){
                minLen = str.length();
            }
        }

        for(int i=0; i<minLen; i++){
            for(int j=0; j<strs.length-1; j++){
                String s1 = strs[j];
                String s2 = strs[j+1];
                if(s1.charAt(i)!=s2.charAt(i)){
                    return s1.substring(0, i);
                }
            }
        }

        return strs[0].substring(0, minLen);
    }
}
