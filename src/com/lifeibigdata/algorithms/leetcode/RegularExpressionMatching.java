package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/28.
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "aa"));
        System.out.println(new RegularExpressionMatching().isMatch("aaa", "aa"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*"));
        System.out.println(new RegularExpressionMatching().isMatch("aa", ".*"));
        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));

        System.out.println(new RegularExpressionMatching().isMatch("", ""));
        System.out.println(new RegularExpressionMatching().isMatch("abcdeff", ".*"));
        System.out.println(new RegularExpressionMatching().isMatch("a", "ab*"));
        System.out.println(new RegularExpressionMatching().isMatch("bb", ".bab"));

    }

    public boolean isMatch(String s, String p) {
        return false;
    }


    /**
     * 递归实现
     *
     *
     */
//    public boolean isMatch(String s, String p) {
//        if (s == null)
//            return p == null;
//        if (p == null)
//            return s == null;
//
//        int lenS = s.length();
//        int lenP = p.length();
//
//        if (lenP == 0)
//            return lenS == 0;
//
//        if (lenP == 1) {
//            if (p.equals(s) || p.equals(".") && s.length() == 1) {
//                return true;
//            } else
//                return false;
//        }
//        if (p.charAt(1) != '*') {
//            if (s.length() > 0
//                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
//                return isMatch(s.substring(1), p.substring(1));
//            }
//            return false;
//        } else {
//            while (s.length() > 0
//                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
//                if (isMatch(s, p.substring(2)))
//                    return true;
//                s = s.substring(1);
//            }
//            return isMatch(s, p.substring(2));
//        }
//
//    }


//    public boolean isMatch(String s, String p) {
//        char[] schars = s.toCharArray();
//        char[] pchars = p.toCharArray();
//
//        for (int i=0; i< schars.length; i++){
//
//        }
//
//
//
//        return false;
//    }
}
