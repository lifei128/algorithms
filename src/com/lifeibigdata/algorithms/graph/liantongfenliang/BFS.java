package com.lifeibigdata.algorithms.graph.liantongfenliang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by leofei.li on 2016/5/21.
 */
public class BFS {
    static int verNum;
    static boolean []visited;
    static String []ver={"A","B","C","D","E"};
    static int  [][]edge;

    void addEdge(int i,int j){
        if(i == j)return;
        edge[i][j]=1;
        edge[j][i]=1;
    }

    void dfsTraverse(){
        visited = new boolean[verNum];
        for(int i = 0; i< verNum; i ++){
            if(visited[i] == false){
                dfs(i);
            }
        }
    }
    void dfs(int i){
        visited[i] = true;
        System.out.print(ver[i] + " ");
        for(int j = 0; j < verNum; j++){
            if(visited[j] == false && edge[i][j] == 1){
                dfs(j);
            }
        }
    }

    void bfsTraverse(){
        visited = new boolean[verNum];
        Queue<Integer> quene = new LinkedList<Integer>();
        for (int i = 0; i < verNum; i ++){
            if(visited[i] == false){
                visited[i] = true;
                System.out.print(ver[i]+" ");
                quene.add(i);
                while (!quene.isEmpty()){
                    int j = quene.poll();
                    for (int k = 0; k < verNum; k++){
                        if(edge[j][k] == 1 && visited[k] == false){
                            visited[k] = true;
                            System.out.print(ver[k]+" ");
                            quene.add(k);
                        }
                    }
                }
            }
        }
    }

    void con(){
        int count = 0;
        visited = new boolean[verNum];
        for(int i = 0; i < verNum; i ++){
            if(!visited[i]){
                count++;
                dfsTraverse();
            }
        }
        System.out.println("共有"+count+"个连通分量!");
    }

    public static void main(String[] args) {
        verNum = ver.length;
        edge = new int[verNum][verNum];
        for(int i=0;i<verNum;i++){
            for (int j=0;j<verNum;j++){
                edge[i][j]=0;
            }
        }
        BFS b = new BFS();
        b.addEdge(0, 3);
        b.addEdge(0, 4);
        b.addEdge(1, 2);
        b.addEdge(2, 4);
        b.addEdge(2, 3);

        System.out.println("图的深度遍历操作:");
        b.dfsTraverse();
        System.out.println();
        System.out.println("图的广度遍历操作：");
        b.bfsTraverse();
        System.out.println();
        System.out.println("连通分量:");
        b.con();
    }
}
