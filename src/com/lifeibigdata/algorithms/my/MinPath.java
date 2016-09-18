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
        int x = minPath(chess,M,N);
        System.out.println(x);
    }

    static int minPath(int[][] chess, int M, int N) {//M > N
        int[] pathLength = new int[N];
        pathLength[0] = chess[0][0];
        //初始化
        for (int j = 1; j < N; j++) {//从1开始,初始化第一行的第2,3,4...列的数据
//            System.out.println(j +"="+ pathLength[j-1] +"+"+ chess[0][j]);
            pathLength[j] = pathLength[j-1] + chess[0][j];
        }
//        System.out.println(chess[0][1]);
//        for (int path:pathLength) {
//            System.out.println("---"+path);
//        }
        //依次计算每行
        for (int i = 1; i < M; i++) {//从1开始,遍历第2,3,4...行
            pathLength[0] += chess[i][0];//第2,3...行的第一列
            for (int j = 1; j < N; j++) {//使用推导公式
                if (pathLength[j - 1] > pathLength[j]){
                    pathLength[j] = pathLength[j - 1] + chess[i][j];
                } else {
                    pathLength[j] += chess[i][j];
                }
            }
        }
        return pathLength[N - 1];
    }
}
