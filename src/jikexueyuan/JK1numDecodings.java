package jikexueyuan;

/**
 * Created by lifei on 2017/4/4.
 * 题目要求：
 一个包含字母的消息被加密之后变成了一个只包含数字的字符串，但是我们现在知道加密的规则：
 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 现在给定一个已经被加密的只包含数字的字符串，求出该字符串有多少种被解密的方法。例如“12”-> AB，或者“12”->L

思路
 解码是有规律的，所以我们可以尝试动态规划。假设数组dp[i]表示从头到字符串的第i位，一共有多少种解码方法的话，
 那么如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们是在第i-2位的解码方法上继续解码。
 如果字符串的第i-1位和第i位不能组成有效二位数字，而且第i位不是0的话，说明我们是在第i-1位的解码方法上继续解码。
 所以，如果两个条件都符合，则dp[i]=dp[i-1]+dp[i-2]，否则dp[i]=dp[i-1]。


 */
public class JK1numDecodings {
    public static int numDecodings(String s) {
        if(s.length() == 0) return s.length();
        int[] dp = new int[s.length() + 1];
        // 初始化第一种解码方式
        dp[0] = 1;
        // 如果第一位是0，则无法解码
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
//            System.out.println("--->"+s.substring(i-2, i));
            if(Integer.parseInt(s.substring(i-2, i)) <= 26 && Integer.parseInt(s.substring(i-2, i)) >= 10){
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
//            System.out.println("===>"+s.substring(i-1, i));
            if(Integer.parseInt(s.substring(i-1, i)) != 0){
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("23"));
    }
}
