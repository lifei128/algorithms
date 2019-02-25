package LeetCode.topic.linear;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 *
 * 还有其他做法
 */
public class L5_longestPalindrome {

    /***
     * 1.两侧比较法
     以abba这样一个字符串为例来看，abba中，一共有偶数个字，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位
     以aba这样一个字符串为例来看，aba中，一共有奇数个字符，排除掉正中间的那个字符后，第1位=倒数第1位......第N位=倒数第N位
     所以，假设找到一个长度为len1的子串后，我们接下去测试它是否满足，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位，
     也就是说，去测试从头尾到中点，字符是否逐一对应相等。
     *
     *
     * TL
     */
    public String longestPalindrome(String s) {
        int max = 0;
        String maxp = "";
        if (s.length() <= 1) return s;
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j < s.length(); j++){
                boolean flag = isPalindrome(s.substring(i,j+1));  //todo substring是左闭右开的空间
                if (flag){
                    if (max < j - i){
                        maxp = s.substring(i,j+1);
                        max = j - i;
                    }
                }
            }
        }
        if (maxp.equals("")) return s.charAt(0)+"";//todo
        return maxp;
    }

    private boolean isPalindrome(String str) {  // baab 03 12 cbabc  04 13
        for (int i = 0; i<(str.length()/2);i++){
            if (str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
}
