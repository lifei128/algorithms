package com.lifeibigdata.bilibili;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifei on 2018/6/27.
 *
 *
 */
public class ZeroSum {

    /**
     * dp[i] = arr[0] + arr[1] + ... + arr[i]
     * 如果 sum(arr[m]...arr[n]) = 0;
     * 那么 sum(arr[0]...arr[m-1]) = sum(arr[0]...arr[n])
     * 和为0的最长子序列: maxLen = n - m + 1, (dp[n] = dp[m-1])
     */
    private static int solve(int[] numbers) {
        int n = numbers.length;
        int[] dp = new int[n];
        dp[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + numbers[i];
        }
        Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, 0);
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (!dpMap.containsKey(dp[i])) {//一旦字符串和,在之前出现过,则i+1
                dpMap.put(dp[i], i + 1);
            } else {
                int len = i - dpMap.get(dp[i]) + 1;
                maxLen = maxLen < len ? len : maxLen;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {-1,1,1,-1,1,-1,1,-1};
        System.out.println(ZeroSum.solve(nums));
    }
}
