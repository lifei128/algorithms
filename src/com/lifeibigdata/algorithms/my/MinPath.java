package com.lifeibigdata.algorithms.my;

/**
 * Created by lifei on 16/9/17.
 */
public class MinPath {
    public static void main(String[] args) {
        int M = 10;
        int N = 8;
        int[][] chess = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = (int) (Math.random()*100);
            }
        }
        int x = minPath(chess);
        int y = minPathSum(chess);
        int z = minPathSum2(chess);
        System.out.println(x+"---"+y+"---"+z);
    }

    //贪心法不行
    static int minPath(int[][] chess) {//M > N
        int M = chess.length;
        int N = chess[0].length;
        int[] pathLength = new int[N];
        //初始化
        pathLength[0] = chess[0][0];
        for (int j = 1; j < N; j++) {//从1开始,初始化第一行的第2,3,4...列的数据
            pathLength[j] = pathLength[j-1] + chess[0][j];
        }
        //依次计算每行
        for (int i = 1; i < M; i++) {//从1开始,遍历第2,3,4...行
            pathLength[0] += chess[i][0];//第2,3...行的第一列
            for (int j = 1; j < N; j++) {//使用推导公式
                if (pathLength[j - 1] < pathLength[j]){
                    pathLength[j] = pathLength[j - 1] + chess[i][j];
                } else {
                    pathLength[j] += chess[i][j];
                }
            }
        }
        return pathLength[N - 1];
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0){
                    if (j == 0){
                        dp[i][j] = grid[i][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + grid[i][j];
                    }
                } else if(j == 0){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0){
                    if (j == 0){
                        dp[j] = grid[i][j];
                    } else {
                        dp[j] = dp[j - 1] + grid[i][j];
                    }
                } else if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1],dp[j]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
