package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/27.
 *
 * 最长回文子串
 *
 * 著名的Manacher算法O(N)时间O(N)空间
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("babcbabcbaccba"));
        //qgjjgq
    }

    /**
     * 一个O(N)的算法(Manacher)
     *
     *
     */
    // Transform S into T.
    // For example, S = "abba", T = "^#a#b#b#a#$".
    // ^ and $ signs are sentinels appended to each end to avoid bounds checking
    String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";

        String ret = "^";
        for (int i = 0; i < n; i++)
        {
            ret += "#" + s.substring(i, i + 1);
        }

        ret += "#$";
        return ret;
    }
    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int length = T.length();
        int[] p = new int[length];
        int C = 0, R = 0;

        for (int i = 1; i < length - 1; i++)
        {
            int i_mirror = C - (i - C);
            int diff = R - i;
            if (diff >= 0)//当前i在C和R之间，可以利用回文的对称属性
            {
                if (p[i_mirror] < diff)//i的对称点的回文长度在C的大回文范围内部
                { p[i] = p[i_mirror]; }
                else
                {
                    p[i] = diff;
                    //i处的回文可能超出C的大回文范围了
                    while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1))
                    { p[i]++; }
                    C = i;
                    R = i + p[i];
                }
            }
            else
            {
                p[i] = 0;
                while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1))
                { p[i]++; }
                C = i;
                R = i + p[i];
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < length - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        return s.substring((centerIndex - 1 - maxLen) / 2, (centerIndex - 1 - maxLen) / 2 + maxLen);
    }

    /***
     * 3.中心扩展法

     因为回文字符串是以中心轴对称的，所以如果我们从下标 i 出发，用2个指针向 i 的两边扩展判断是否相等，那么只需要对0到
     n-1的下标都做此操作，就可以求出最长的回文子串。但需要注意的是，回文字符串有奇偶对称之分，即"abcba"与"abba"2种类型，
     因此需要在代码编写时都做判断。
     设函数int Palindromic ( string &s, int i ,int j) 是求由下标 i 和 j 向两边扩展的回文串的长度，那么对0至n-1的下标，调用2次此函数：
     int lenOdd =  Palindromic( str, i, i ) 和 int lenEven = Palindromic (str , i , j )，即可求得以i 下标为奇回文和偶回文的子串长度。
     接下来以lenOdd和lenEven中的最大值与当前最大值max比较即可。
     这个方法有一个好处是时间复杂度为O(n2)，且不需要使用额外的空间。
     */

//    public String longestPalindrome(String s) {
//        if (s.isEmpty()) {
//            return null;
//        }
//        if (s.length() == 1) {
//            return s;
//        }
//        String longest = s.substring(0, 1);
//        for (int i = 0; i < s.length(); i++) {
//            // get longest palindrome with center of i
//            String tmp = helper(s, i, i);
//            if (tmp.length() > longest.length()) {
//                longest = tmp;
//            }
//
//            // get longest palindrome with center of i, i+1
//            tmp = helper(s, i, i + 1);
//            if (tmp.length() > longest.length()) {
//                longest = tmp;
//            }
//        }
//        return longest;
//    }
//
//    // Given a center, either one letter or two letter,
//    // Find longest palindrome
//    public static String helper(String s, int begin, int end) {
//        while (begin >= 0 && end <= s.length() - 1
//                && s.charAt(begin) == s.charAt(end)) {
//            begin--;
//            end++;
//        }
//        String subS = s.substring(begin + 1, end);
//        return subS;
//    }


    /***
     *  2.动态规划法
     假设dp[ i ][ j ]的值为true，表示字符串s中下标从 i 到 j 的字符组成的子串是回文串。那么可以推出：
     dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]。
     这是一般的情况，由于需要依靠i+1, j -1，所以有可能 i + 1 = j -1, i +1 = (j - 1) -1，因此需要求出基准情况才能套用以上的公式：
     a. i + 1 = j -1，即回文长度为1时，dp[ i ][ i ] = true;
     b. i +1 = (j - 1) -1，即回文长度为2时，dp[ i ][ i + 1] = （s[ i ] == s[ i + 1]）。
     有了以上分析就可以写出代码了。需要注意的是动态规划需要额外的O(n2)的空间。
     */
//    public String longestPalindrome(String s) {
//        if (s == null)
//            return null;
//        if(s.length() <=1)
//            return s;
//        int maxLen = 0;
//        String longestStr = null;
//        int length = s.length();
//        int[][] table = new int[length][length];
//        //every single letter is palindrome
//        for (int i = 0; i < length; i++) {
//            table[i][i] = 1;
//        }
//        printTable(table);
//        //e.g. bcba
//        //two consecutive(连续) same letters are palindrome
//        for (int i = 0; i <= length - 2; i++) {                 //注意 i<= length - 2,是因为循环里面有用到s.charAt(i+1),避免数组越界
//            //System.out.println("i="+i+"  "+s.charAt(i));
//            //System.out.println("i="+i+"  "+s.charAt(i+1));
//            if (s.charAt(i) == s.charAt(i + 1)){
//                table[i][i + 1] = 1;
//                longestStr = s.substring(i, i + 2);
//            }
//        }
//        System.out.println("longestStr:"+longestStr);
//        printTable(table);
//        //condition for calculate whole table
//        for (int l = 3; l <= length; l++) {                         //l表示区间的长度从3开始
//            for (int i = 0; i <= length-l; i++) {
//                int j = i + l - 1;
//                if (s.charAt(i) == s.charAt(j)) {
//                    table[i][j] = table[i + 1][j - 1];
//                    if (table[i][j] == 1 && l > maxLen)             //比较maxLen
//                        longestStr = s.substring(i, j + 1);
//
//                } else {
//                    table[i][j] = 0;
//                }
////                printTable(table);
//            }
//        }
//
//        return longestStr;
//    }
//
//
//    public static void printTable(int[][] x){
//        for(int [] y : x){
//            for(int z: y){
//                System.out.print(z + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("------");
//    }
    /***
     * 1.两侧比较法
     以abba这样一个字符串为例来看，abba中，一共有偶数个字，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位
     以aba这样一个字符串为例来看，aba中，一共有奇数个字符，排除掉正中间的那个字符后，第1位=倒数第1位......第N位=倒数第N位
     所以，假设找到一个长度为len1的子串后，我们接下去测试它是否满足，第1位=倒数第1位，第2位=倒数第2位......第N位=倒数第N位，也就是说，去测试从头尾到中点，字符是否逐一对应相等。
     *
     *
     */
//    public String longestPalindrome(String s) {
//        int max = 0;
//        String maxp = "";
//        if (s.length() <= 1) return s;
//        for (int i = 0; i < s.length(); i++){
//            for (int j = i + 1; j < s.length(); j++){
//                boolean flag = isPalindrome(s.substring(i,j+1));  //substring是左闭右开的空间
//                if (flag){
//                    if (max < j - i){
//                        maxp = s.substring(i,j+1);
//                        max = j - i;
//                    }
//                }
//            }
//        }
//        return maxp;
//    }
//
//    private boolean isPalindrome(String str) {  // baab 03 12 cbabc  04 13
//        for (int i = 0; i<(str.length()/2);i++){
//            if (str.charAt(i) != str.charAt(str.length() - i - 1)){
//                return false;
//            }
//        }
//        return true;
//    }
}
