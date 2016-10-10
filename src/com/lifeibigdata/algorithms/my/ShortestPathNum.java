package com.lifeibigdata.algorithms.my;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by lifei on 16/9/23.
 */
public class ShortestPathNum {


    static int N = 16;
    static int[][] G = new int[N][N];


    public static void main(String[] args) {
        G[0][1] = G[0][4] = 1;
        G[1][5] = G[1][0] = G[1][2] = 1;
        G[2][1] = G[2][6] = G[2][3] = 1;
        G[3][2] = G[3][7] = 1;
        G[4][0] = G[4][5] = 1;
        G[5][1] = G[5][4] = G[5][6] = G[5][9] = 1;
        G[6][2] = G[6][5] = G[6][7] = G[6][10]= 1;
        G[7][3] = G[7][6] = 1;
        G[8][9] = G[8][12] = 1;
        G[9][8] = G[9][13] = G[9][10] = 1;
        G[10][9] = G[10][14] = G[10][11] = 1;
        G[11][10] = G[11][15] = 1;
        G[12][8] = G[12][13] = 1;
        G[13][9] = G[13][12] = G[13][14] = 1;
        G[14][10] = G[14][13] = G[14][15] = 1;
        G[15][11] = G[15][14] = 1;

        System.out.println(calc());
    }

    static int calc(){
        int[] step = new int[N];//每个节点第几步可以到达
        int[] stepNumber = new int[N];//到每个节点有几种走法

        stepNumber[0] = 1;
        Queue<Integer> q = new ArrayBlockingQueue<Integer>(N);//当前搜索的结点
        q.add(0);
        int from,s;
        while (!q.isEmpty()){
            from = q.poll();
            s = step[from] + 1;
            for (int i = 0; i < N; i++) {//0是起点,不是遍历
                if (G[from][i] == 1){//连通
                    //i尚未可达或发现更快的路(权值不同才可能)
                    if (step[i] == 0 || step[i] > s){
                        step[i] = s;
                        stepNumber[i] = stepNumber[from];
                        q.add(i);
                    } else if (step[i] ==s){//发现长度相同的路径
                        stepNumber[i] += stepNumber[from];
                    }
                }
            }
        }
        return stepNumber[N - 1];
    }
}
