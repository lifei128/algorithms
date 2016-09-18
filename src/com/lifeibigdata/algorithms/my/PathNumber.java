package com.lifeibigdata.algorithms.my;

/**
 * Created by lifei on 16/9/17.
 */
public class PathNumber {
    public static void main(String[] args) {
        int M = 4;
        int N = 5;
        Boolean[][] chess = new Boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = (Math.random() * 5 != 0);
            }
        }
        chess[3][3] = false;
        int x = pathNumber(chess);
        System.out.println(x);
    }

    private static int pathNumber(Boolean[][] chess) {
        int M = chess.length;       //行
        int N = chess[0].length;    //列
        int[] pathNumber = new int[N];
        pathNumber[0] = chess[0][0] ? 1 : 0;
        for (int j = 1; j < N; j++) {
            //当前未阻断,并且前一个值可达
            if (chess[0][j] && (pathNumber[j - 1] == 1)){
                pathNumber[j] = 1;
            }
        }
        for (int i = 1; i < M; i++) {
            if (!chess[i][0]){
                pathNumber[0] = 0;
            }
            for (int j = 1; j < N; j++) {
                if (!chess[i][j]){//当前被阻断
                    pathNumber[j] = 0;
                } else {//Cur = left + top
                    pathNumber[j] += pathNumber[j - 1];
                }
            }
        }
        return pathNumber[N -1];
    }
}
















