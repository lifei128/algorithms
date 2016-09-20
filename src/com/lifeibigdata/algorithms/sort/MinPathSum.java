package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/9/19.
 */
public class MinPathSum {
    static int N = 202;
    //dp[step][i][j]表示再第step步两次分别在第i行和第j行的最大得分
    static int[][][] dp = new int[N*2][N][N];
    public static void main(String[] args) {
        int x =  minPathSum(new int[N][N],N);
        System.out.println(x);
    }

    static boolean isValid(int step,int x1,int x2,int n){
        int y1 = step - x1;
        int y2 = step - x2;
        return x1 >= 0 && x1 < n && x2>= 0 && x2 <n
                && y1>= 0 && y1 <n && y2>= 0 && y2 <n;
    }

    static int getValue(int step,int x1,int x2,int n){
        return isValid(step,x1,x2,n) ? dp[step][x1][x2] : -Integer.MAX_VALUE;
    }
    private static int minPathSum(int[][] a, int n) {
        int P = n*2 - 2;//最终的步数
        //不能到达的位置,设置为负无穷大
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                dp[0][i][j] = -Integer.MAX_VALUE;//第0步
            }
        }
        dp[0][0][0] = a[0][0];
        for (int step = 0; step <= P; ++step) {
            for (int i = 0; i < n; ++i) {
                for (int j = i; j < n; ++j) {
                    dp[step][i][j] = -Integer.MAX_VALUE;
                    if (!isValid(step,i,j,n))//非法位置
                        continue;
                    //对于合法的位置
                    if (i != j){
                        dp[step][i][j] = Math.max(dp[step][i][j],getValue(step - 1,i - 1,j -1 ,n));
                        dp[step][i][j] = Math.max(dp[step][i][j],getValue(step - 1,i - 1,j ,n));
                        dp[step][i][j] = Math.max(dp[step][i][j],getValue(step - 1,i ,j -1 ,n));
                        dp[step][i][j] = Math.max(dp[step][i][j],getValue(step - 1,i ,j ,n));
                        dp[step][i][j] += a[i][step - i] + a[j][step - j];
                    } else {
                        dp[step][i][j] = Math.max(dp[step][i][j],getValue(step - 1,i - 1,j -1 ,n));
                        dp[step][i][j] = Math.max(dp[step][i][j],getValue(step - 1,i - 1,j ,n));
                        dp[step][i][j] = Math.max(dp[step][i][j],getValue(step - 1,i ,j ,n));
                        dp[step][i][j] += a[i][step - i];
                    }
                }
            }
        }
        return dp[P][n - 1][n - 1];
    }
}
