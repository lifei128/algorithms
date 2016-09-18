package com.lifeibigdata.algorithms.my;

import java.util.List;
import java.util.Vector;

/**
 * Created by lifei on 16/9/17.
 */
public class MaxProfit {
    static int MaxProfit(int[] prices){
        int max = 0;
        int mn = prices[0];
        for (int i = 1; i < prices.length; i++) {//从第二天开始,所以i = 1
            mn = Math.min(mn,prices[i - 1]);
            max = Math.max(max,prices[i] - mn);
        }
        return max;
    }

    static int MaxProfitK(int[] prices,int K){
        //http://www.cnblogs.com/wei-li/archive/2012/06/08/2541576.html
        //vector<vector <int> > ivec(m ,vector<int>(n,0)); //c语言中定义m*n的二维vector，所有元素初始化为0
        int[][] dp = new int[K+1][prices.length];
        for (int k = 1; k <=K ; k++) {
            for (int i = 1; i < prices.length; i++) {//TODO 此处i从下标1开始
                dp[k][i] = dp[k][i-1];
                for (int j = 0; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i],dp[k - 1][j] + prices[i] - prices[j]);
                }
            }
        }
        return dp[K][prices.length - 1];
    }

    static int MaxProfitK2(int[] prices,int K){
        int[][] dp = new int[K+1][prices.length];
        int mx;
        for (int k = 1; k <=K ; k++) {
            mx = dp[k - 1][0] - prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[k][i] = Math.max(dp[k][i - 1],mx + prices[i]);
                mx = Math.max(mx,dp[k - 1][i] - prices[i]);
            }
        }
        return dp[K][prices.length - 1];
    }
    public static void main(String[] args) {
        int prices[] = new int[]{7,1,5,3,6,4};
//        System.out.println(MaxProfit(prices));
//        System.out.println(MaxProfitK(prices,3));
        System.out.println(MaxProfitK2(prices,3));
    }
}
