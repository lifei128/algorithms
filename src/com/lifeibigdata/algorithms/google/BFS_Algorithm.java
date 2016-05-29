package com.lifeibigdata.algorithms.google;

/**
 * Created by lifei on 16/5/23.
 */
import java.util.LinkedList;
import java.util.List;

public class BFS_Algorithm {
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    private int color[];
    private int size;
    private int d[];
    private int parent[];
    private LinkedList<Integer> q;
    private Adjacent_List G;
    public BFS_Algorithm (Adjacent_List G){
        this.G = G;
        this.size = G.getSize();
        d = new int[size];
        color = new int[size];
        parent = new int[size];
        q = new LinkedList<Integer>();
        for(int i=0;i<size;i++){
            d[i] = Integer.MAX_VALUE;
            color[i] = WHITE;
            parent[i] = -1;
        }
    }
    public void BFS(int i){
        BFS(G.getVertexValue(i));
    }
    public void BFS(String s){
        for(int i=0;i<size;i++){
            d[i] = Integer.MAX_VALUE;
            color[i] = WHITE;
            parent[i] = -1;
        }
        q = new LinkedList<Integer>();
        int begin = G.getVertexIndex(s);
        color[begin] = GRAY;
        d[begin] = 0;
        q.addLast(begin);
        while(!q.isEmpty()){
            int u = q.pop();
            List<String> list = G.getListByVertexIndex(u);
            for(String str:list){
                int v = G.getVertexIndex(str);
                if(color[v]==WHITE){
                    color[v] = GRAY;
                    d[v] = d[u]+1;
                    parent[v] = u;
                    q.addLast(v);	//加入队列
                }
            }
            color[u] = BLACK;
        }
    }

    /**
     * 给定起点、终点，输出路径
     * @param s
     * @param t
     */
    public void print_path(String s,String t){
        int s_index = G.getVertexIndex(s);
        int t_index = G.getVertexIndex(t);
        if(s_index == t_index) System.out.print(s+" ");
        else if(parent[t_index]==-1) System.out.println("no path from "+s + " to "+ t);
        else {
            print_path(s, G.getVertexValue(parent[t_index]));
            System.out.print(t+" ");
        }
    }
    /**
     * 输出全部的节点对应的路径
     */
    public void print_AllDistances(){
        for(int i=0;i<d.length;i++){
            System.out.println(G.getVertexValue(i)+":"+d[i]);
        }
    }
    /**
     * 获得全部的路径
     * @return
     */
    public int[] getDistances(){
        return d;
    }
    /**
     * 给定起点、终点，返回两点之间的路径
     * @param s
     * @param t
     * @return
     */
    public int getDistance(String t){
        return d[G.getVertexIndex(t)];
    }
    public int getDistance(int t){
        return d[t];
    }
    public static void main(String[] args) throws Exception {
        Adjacent_List adjlist = GraphFactory.getAdjacentListInstance("/Users/lifei/myproject/algorithms/input/bfs_input.txt");
        BFS_Algorithm bfs_alg = new BFS_Algorithm(adjlist);
        bfs_alg.BFS("s");
        bfs_alg.print_AllDistances();
        bfs_alg.print_path("s", "y");
//        System.out.println(bfs_alg.getDistance( "y"));
    }
}