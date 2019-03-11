package LeetCode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class L14_longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)return "";
        int minLen = strs[0].length();
        String minstr = strs[0];
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
                minstr = s;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = minstr.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();

    }
}
