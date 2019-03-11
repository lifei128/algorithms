package com.lifeibigdata.algorithms.string;

public class LongestPalindrome2 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("12212321"));
    }


    /**
     * 暴力求解
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if(s.length() <= 1)
            return s;
        for(int i = s.length();i > 0; i--) {//子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j , i + j);//子串位置
                int count = 0;//计数，用来判断是否对称
                for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
                        count++;
                }
                if (count == sub.length() / 2)
                    return sub;
            }
        }
        return "";//表示字符串中无回文子串
    }

    /**
     * 中心扩散
     */
    private static int maxLen = 0;

    private static String sub = "";

    public static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;

        for(int i = 0;i < s.length()-1;i++){

            findLongestPalindrome(s,i,i);//单核回文

            findLongestPalindrome(s,i,i+1);//双核回文
        }
        return sub;
    }
    public static  void findLongestPalindrome(String s,int low,int high){
        while (low >= 0 && high <= s.length()-1){
            if(s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > maxLen){
                    maxLen = high - low + 1;
                    sub = s.substring(low , high+1);
                }
                low --;//向两边扩散找当前字符为中心的最大回文子串
                high ++;
            }
            else
                break;
        }
    }
}
