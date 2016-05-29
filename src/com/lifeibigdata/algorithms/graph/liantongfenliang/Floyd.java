package com.lifeibigdata.algorithms.graph.liantongfenliang;

/**
 * Created by leofei.li on 2016/5/21.
 */
import java.util.ArrayList;
/**
 * @author 刘雁冰
 * @date 2015-03-10 15:20
 */
public class Floyd {
 /*
  * 给出一个含有n个顶点的带权有向图，要求其每一对顶点之间的最短路径。
  * 这里采用佛洛依德(Floyd)最短路径算法：
  */

    private static int max=Integer.MAX_VALUE;
    private static int [][]dist=new int[6][6];          //存储最短路径
    private static int [][]path=new int[6][6];          //存储最短路径的长度
    private static ArrayList list=new ArrayList<Integer>();
    private static int [][]Arcs={
            {max,max,10,max,30,100},
            {max,max,5,max,max,max},
            {max,max,max,50,max,max},
            {max,max,max,max,20,10},
            {max,max,max,max,max,60},
            {max,max,max,max,max,max}
    };

    public void findCheapestPath(int begin,int end,int Arcs[][]){
        floyd(Arcs);
        list.clear();
        list.add(begin);
        findPath(begin,end);
        list.add(end);
    }

    public void findPath(int i,int j){
        int k=path[i][j];
        if(k==-1)
            return ;
        findPath(i,k);
        list.add(k);
        findPath(k,j);
    }
    public void floyd(int [][] Arcs){
        int n=Arcs.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                path[i][j]=-1;            //初始化当前的路径长度表
                dist[i][j]=Arcs[i][j];         //初始化当前的路径表
            }

        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=max&&dist[k][j]!=max&&dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                        path[i][j]=k;
                    }
                }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Floyd f=new Floyd();
        for(int i=0;i<Arcs.length;i++)
            for(int j=0;j<Arcs.length;j++){
                f.findCheapestPath(i, j, Arcs);
                ArrayList<Integer>L=f.list;
                System.out.print(i+"-->"+j+":");
                if(f.dist[i][j]==max){
                    System.out.println("之间没有最短路径");
                    System.out.println();
                }
                else{
                    System.out.println("的最短路径是：");
                    System.out.print(L.toString()+" ");
                    System.out.println("路径长度:"+f.dist[i][j]);
                    System.out.println();
                }
            }
    }
}