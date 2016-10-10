package com.lifeibigdata.algorithms.my;

/**
 * Created by lifei on 16/9/23.
 */
public class GoChess {
    public static void main(String[] args) {
        int M = 19;
        int N = 19;
        int[][] chess = new int[M][N];

        int count = 0;
        //第一种解法
//        for (int i = 1; i < M; i++) {
//            for (int j = 1; j < N; j++) {
//                if (i != j){
//                    chess[i][j] = Math.max(chess[i - 1][j],chess[i][j - 1]);
//                } else {
//                    chess[i][j] = chess[i -1][j] + 1;
//                }
//                count += chess[i][j];
//            }
//        }
        //第二种解法
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                count += Math.min(i,j);
            }
        }
        System.out.println(count);
    }
    //第三种解法
//    1^2 + 2^2 +3^2 +...+18^ = 2109
}
