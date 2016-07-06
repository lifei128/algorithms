package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/28.
 *
 * 枚举一般都不好使
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
//        System.out.println(new RegularExpressionMatching().isMatch("aa", "a"));
//        System.out.println(new RegularExpressionMatching().isMatch("aa", "aa"));
//        System.out.println(new RegularExpressionMatching().isMatch("aaa", "aa"));
//        System.out.println(new RegularExpressionMatching().isMatch("ba", "a*"));
//        System.out.println(new RegularExpressionMatching().isMatch("aa", ".*"));
//        System.out.println(new RegularExpressionMatching().isMatch("ab", ".*"));
//        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));

//        System.out.println(new RegularExpressionMatching().isMatch("", ""));
        System.out.println(new RegularExpressionMatching().isMatch("abcdeff", ".*"));
//        System.out.println(new RegularExpressionMatching().isMatch("a", "ab*"));
//        System.out.println(new RegularExpressionMatching().isMatch("bb", ".bab"));
//        System.out.println(new RegularExpressionMatching().isMatch("aa", "a*aa"));//true

    }

    /**
     * 递归实现
     *
     *
     */
    public boolean isMatch(String s, String p) {
        if (s == null)
            return p == null;
        if (p == null)
            return s == null;

        int lenS = s.length();
        int lenP = p.length();

        if (lenP == 0)  //正则式为空,字符串必须为空符合条件
            return lenS == 0;

        if (lenP == 1) { //正则长度为1,此时正则是不能为*的其他字符
            if (p.equals(s) || p.equals(".") && s.length() == 1) {
                return true;
            } else
                return false;
        }
        if (p.charAt(1) != '*') { //正则式的第二个字符不为*
            if (s.length() > 0
                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {//如果第一个字符匹配,则各自去除一个字符后继续匹配
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        } else {                  //正则式的第二个字符为*
            while (s.length() > 0
                    && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {//如果第一个字符匹配
                if (isMatch(s, p.substring(2))) //判断s与*号之后的数据是否匹配,如果匹配直接返回成功
                    return true;
                s = s.substring(1);//否则依次减小s的长度,直到s长度为空
            }
            return isMatch(s, p.substring(2));  //s长度为空后,判断s和p的*之后的部分是否匹配
        }
    }



}
