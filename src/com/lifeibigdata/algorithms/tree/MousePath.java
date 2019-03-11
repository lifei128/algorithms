package com.lifeibigdata.algorithms.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 16/9/21.
 *
 */
public class MousePath {

    static List<List<Pair>> all = new ArrayList<>();
    public static void main(String[] args) {
        int[][] chess = {
                {1,1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1,1},
                {1,0,0,0,1,0,0,1},
                {1,1,1,0,1,0,0,1},
                {0,1,0,0,1,1,1,1},
                {0,1,0,0,0,0,0,1},
                {0,1,0,9,1,1,1,1},
                {0,1,1,1,0,0,1,0}
        };
        mouthPath(chess);
        for (List<Pair> path:all) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (Pair pair:path) {
                System.out.println(pair.from+"-"+pair.to);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    private static void mouthPath(int[][] chess) {
        List<Pair> path = new ArrayList<>();
        boolean[][] visit = new boolean[chess.length][chess[0].length];
        //开始搜索路径
        path.add(new Pair(0,0));
        visit[0][0] = true;
        boolean b = search(chess,0,0,path,visit);
        System.out.println(b);
    }

    private static boolean search(int[][] chess, int i, int j, List<Pair> path, boolean[][] visit) {
        if (chess[i][j] == 9){
//            print(path);
            return true;
        }
        int iNext[] = {0,0,-1,1};
        int jNext[] = {-1,1,0,0};
        int iCur,jCur;
        int m = chess.length;
        int n = chess[0].length;
        for (int k = 0; k < 4; k++) {
            iCur = i + iNext[k];
            jCur = j + jNext[k];
            if (iCur < 0 || iCur >= m || jCur <0 || jCur >= n)
                continue;
            if (!visit[iCur][jCur] && chess[iCur][jCur] != 0){
                path.add(new Pair(iCur,jCur));
                visit[iCur][jCur] = true;
                if (search(chess,iCur,jCur,path,visit)){
                    //如果求所有路径
                    List<Pair> d = new ArrayList<>();//TODO 要用到对象拷贝,因为path在后面的代码中会变化,这里需要记录path的中间状态,所以需要使用到对象拷贝
                    for (Pair temPair:path) {
                        d.add(new Pair(temPair.from,temPair.to));
                    }
                    all.add(d);
//                    System.out.println("======================");
//                    for (Pair pair:path) {
//                        System.out.println(pair.from+"-"+pair.to);
//                    }
//                    System.out.println("======================");
//                    return true;//仅仅判断是否可以吃到
                }
                path.remove(path.size() -1);
                visit[iCur][jCur] = false;
            }
        }
        return false;
    }

//    private static void print(List<Pair> path) {
//    }


    static class Pair{
        int from;
        int to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }


}
