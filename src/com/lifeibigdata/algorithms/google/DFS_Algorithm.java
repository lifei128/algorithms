package com.lifeibigdata.algorithms.google;

/**
 * Created by lifei on 16/5/23.
 */
public class DFS_Algorithm{
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    private int color[];
    private int size;
    private int d[];
    private int f[];
    private int time;
    private int parent[];
    private Adjacent_List G;
    public DFS_Algorithm(Adjacent_List G){
        this.G = G;
        size = G.getSize();
        color = new int[size];
        d = new int[size];
        f = new int[size];
        parent = new int[size];
        time = 0;
        for(int i=0;i<size;i++){
            color[i] = WHITE;
            parent[i] = -1;
        }
    }

    public int[] getD() {
        return d;
    }

    public int[] getF() {
        return f;
    }
    //主函数
    public void DFS(){
        for(int i=0;i<G.getSize();i++){
            if(color[i]==WHITE){
                DFS_VISIT(i);
            }
        }
    }
    public void DFS_VISIT(int i) {
        color[i] = GRAY;
        time++;
        d[i] = time;
        for(int j=0;j<G.getListByVertexIndex(i).size();j++){
            String value = G.getListByVertexIndex(i).get(j);
            int index = G.getVertexIndex(value);
            if(color[index]==WHITE){
                parent[index] = i;
                DFS_VISIT(index);
            }
        }
        time++;
        f[i] = time;
        color[i] = BLACK;
    }
    /**
     * 输出DFS的每个节点的d值和f值
     */
    public void print_d_f(){
        for(int i=0;i<size;i++){
            System.out.println(G.getVertexValue(i)+"("+d[i]+"/"+f[i]+")");
        }
    }

    public static void main(String[] args) throws Exception {
        Adjacent_List adjacent_list = GraphFactory.getAdjacentListInstance("/Users/lifei/myproject/algorithms/input/dfs_input.txt");
        DFS_Algorithm dfs_alg = new DFS_Algorithm(adjacent_list);
        dfs_alg.DFS();
        dfs_alg.print_d_f();	//输出d和f数组
    }
}


