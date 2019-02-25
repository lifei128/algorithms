package com.lifeibigdata.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lifei on 16/5/27.
 *
 * 如果包含重复，此算法有问题
 *  时间复杂度为O(N)的算法
 使用i和j两个指针进行搜索，i代表候选的最长子串的开头，j代表候选的最长子串的结尾。
 先假设i不动，那么在理想的情况下，我们希望可以一直右移j，直到j到达原字符串的结尾，此时j-i就构成了一个候选的最长子串。每次都维护一个max_length，就可以选出最长子串了。
 实际情况是，不一定可以一直右移j，如果字符j已经重复出现过（假设i在位置k），就需要停止右移了。记录当前的候选子串并和max_length做比较。接下来为下一次搜寻做准备。
 在下一次搜寻中，i应该更新到k+1。这句话的意思是，用这个例子来理解，abcdef是个不重复的子串，abcdefc中（为了方便记录为abc1defc2）,c1和c2重复了。
 那么下一次搜寻，应该跨过出现重复的地方进行，否则找出来的候选串依然有重复字符，且长度还不如上次的搜索。所以下一次搜索，直接从c1的下一个字符d开始进行，
 也就是说，下一次搜寻中，i应该更新到k+1
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        System.out.println(lols.lengthOfLongestSubstring("abcdefcgh"));

    }

//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        int[] index = new int[128]; // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; ++j) {
//            i = Math.max(index[s.charAt(j)], i);//index['a']会将char转为ascII码,a是97
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;   //将j所在的值,的对应位置存到index数组中
//        }
//        return ans;
//    }


    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){       //如果j没有出现重复字符,将j添加到set中,这个过程中,i保持不变
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);        //比较获取最大的ans
            }
            else {                                 //出现重复字符,这个字符在i-j之间,所以从i开始逐个删除,直到不包含重复字符
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


//    public int lengthOfLongestSubstring(String s) {    //使用map存储字母和索引
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>(); // current index of character
//        // try to extend the range [i, j]
//        for (int j = 0, i = 0; j < n; ++j) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(ans, j - i + 1);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;
//    }


//    public int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        int ans = 0;
//        for (int i = 0; i < n; ++i)
//            for (int j = i + 1; j <= n; ++j)
//                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
//        return ans;
//    }
//
//    public boolean allUnique(String s, int start, int end) {
//        Set<Character> set = new HashSet<>();
//        for (int i = start; i < end; ++i) {
//            Character ch = s.charAt(i);
//            if (set.contains(ch)) return false;
//            set.add(ch);
//        }
//        return true;
//    }
}
