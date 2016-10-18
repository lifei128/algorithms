package com.lifeibigdata.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by lifei on 16/10/17.
 */
public class WordBreak {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("an");
        set.add("dog");
        System.out.println(wordBreak("catsandog",set));
    }
    static boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] have = new boolean[s.length()];
//        return help(s,0,wordDict,have);
//        return help2(s,wordDict,have);
        return help3(s,wordDict,have);
    }

    static boolean help(String s, int now, Set<String> d, boolean[] have) {
        if (now >= s.length())
            return true;
        if (have[now])
            return false;
        have[now] = true;
        for (int i = now; i < s.length(); ++i) {
            System.out.println("---"+s.substring(now,i+1));
            if (d.contains(s.substring(now,i+1))//TODO
                    && help(s,i + 1,d,have)){
                return true;
            }
        }
        return false;
    }

    static boolean help2(String s, Set<String> d, boolean[] have) {
        if (s.length() == 0)
            return true;
        have[0] = true;
        Queue<Integer> q = new ArrayDeque<>();
        for (q.add(0);!q.isEmpty();q.poll()) {
            int now = q.peek();
            for (int i = now; i < s.length(); ++i) {
                if (d.contains(s.substring(now,i + 1))){
                    if (i + 1 >= s.length())
                        return true;
                    if (!have[i + 1]){
                        have[i + 1] = true;
                        q.offer(i + 1);
                    }
                }
            }
        }
        return false;
    }


    static boolean help3(String s, Set<String> d, boolean[] dp) {
        if (s.length() == 0)
            return true;
        dp[0] = true;
        for (int now = 0;now < s.length();++now) {
            if (!dp[now]){
                continue;
            }
            for (int i = now; i < s.length(); ++i) {
                if (d.contains(s.substring(now,i + 1))){
                    if (i + 1 >= s.length())
                        return true;
                    dp[i + 1] = true;
                }
            }
        }
        return false;
    }
}
