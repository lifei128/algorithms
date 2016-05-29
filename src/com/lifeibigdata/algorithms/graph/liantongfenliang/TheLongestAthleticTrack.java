package com.lifeibigdata.algorithms.graph.liantongfenliang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lifei on 16/5/23.
 */
public class TheLongestAthleticTrack {

    static int INF = 999999;
    static int M = 2002;
    static int n ;
    static int maxx ;
    static int[][] map = new int[M][M];
    static int[] sum = new int[M];
    static boolean[] flag = new boolean[M];

    static int bfs(int begin){
        Queue<Integer> f = new LinkedList<>();
        int i = 0;
        int k = 0;
        int key = 0;
        maxx = 0;
        f.add(begin);
        while (!f.isEmpty()) {
            k = f.poll();
            for (i = 1; i <= n; i++) {
                if (map[k][i] != INF && !flag[i]){
                    flag[i] = true;
                    f.add(i);
                    sum[i] = sum[k] + map[k][i];
                    if (sum[i] > maxx){
                        maxx = sum[i];
                        key = i;
                    }
                }
            }
            f.poll();
        }
        return key;
    }

    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int k = 0;
        int dis = 0;
        int key = 0;
        int cas = 0;
//        scanf("%d",&cas);
        cas = 100;
        while(cas > 0){
//            scanf("%d",&n);
            for(i=1;i<n;i++)
                for(j=i+1;j<=n;j++)
                    map[i][j]=map[j][i]=INF;
            for(i=1;i<n;i++){
//                scanf("%d%d%d",&j,&k,&dis);
                map[j][k]=map[k][j]=dis;
            }
            sum[1]=0;
            key=bfs(1);
            sum[key]=0;
            key=bfs(key);
//            printf("%d\n",maxx);
        }
        cas--;
    }



}
