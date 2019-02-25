package com.lifeibigdata.algorithms.graph.liantongfenliang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by leofei.li on 2016/5/21.
 */
public class BFS {

    void addEdge(int i,int j){              //添加节点关系
        if(i == j)return;
        edge[i][j]=1;
        edge[j][i]=1;
    }

    void dfsTraverse(){
        visited = new boolean[verNum];      //图中的节点是否访问过
        for(int i = 0; i< verNum; i ++){    //遍历行
            if(visited[i] == false){        //如果该行没有被遍历过
                dfs(i);
            }
        }
    }
    void dfs(int i){
        visited[i] = true;                  //标记遍历该行
        System.out.print(ver[i] + " ");
        for(int j = 0; j < verNum; j++){    //遍历列
            if(visited[j] == false && edge[i][j] == 1){
                dfs(j);                     //列转行
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
        for(int i = 0; i < verNum; i ++){   //遍历
            if(!visited[i]){
                count++;
                dfsTraverse();
            }
        }
        System.out.println("共有"+count+"个连通分量!");
    }

    static int verNum;//节点数
    static boolean []visited;//定义辅助数组
    static String []ver={"A","B","C","D","E"};  //定义节点
    static int  [][]edge;//邻接矩阵

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
