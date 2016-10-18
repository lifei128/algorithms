package com.lifeibigdata.algorithms.my;

/**
 * Created by lifei on 16/10/16.
 */
public class MinDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("acd","aef"));
        System.out.println(minDistance2("acd","aef"));
    }
    static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0){
                    dp[i][j] = j;
                } else if (j == 0){
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1] + (word1.charAt(i -1) == word2.charAt(i -1) ? 0 : 1),
                            Math.min(dp[i][j - 1]+1,dp[i - 1][j] + 1)
                    );
                }
            }
        }
        return dp[m][n];
    }


    static int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= m; ++i) {
            int last = 0;
            for (int j = 0; j <= n; ++j) {
                if (i == 0){
                    dp[j] = j;
                } else if (j == 0){
                    last = dp[j];
                    dp[j] = i;
                } else {
                    //last dp[i - 1][j - 1]
                    int temp = dp[j];
                    dp[j] = Math.min(
                            last + (word1.charAt(i -1) == word2.charAt(i -1) ? 0 : 1),
                            Math.min(dp[j - 1]+1,dp[j] + 1)
                    );
                    last = temp;
                }
            }
        }
        return dp[n];
    }
}
