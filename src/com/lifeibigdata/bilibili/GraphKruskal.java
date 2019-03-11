package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/18.
 *
 */
public class GraphKruskal {
    class Edege{
        int begin;
        int end;
        int weight;
        public Edege(int begin,int end,int weight){
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }
    private Edege[] edeges;
    private int edgeSize;
    public GraphKruskal(int edgeSize){
        this.edgeSize = edgeSize;
        edeges = new Edege[edgeSize];
    }

    public void createEdgeArray(){
        Edege edege0 = new Edege(4,7,7);
        Edege edege1 = new Edege(2,8,8);
        Edege edege2 = new Edege(0,1,10);
        Edege edege3 = new Edege(0,5,11);
        Edege edege4 = new Edege(1,8,12);
        Edege edege5 = new Edege(3,7,16);
        Edege edege6 = new Edege(1,6,16);
        Edege edege7 = new Edege(5,6,17);
        Edege edege8 = new Edege(1,2,18);
        Edege edege9 = new Edege(6,7,19);
        Edege edege10 = new Edege(3,4,20);
        Edege edege11 = new Edege(3,8,21);
        Edege edege12 = new Edege(2,3,22);
        Edege edege13 = new Edege(3,6,24);
        Edege edege14 = new Edege(4,5,26);
        edeges = new Edege[]{edege0,edege1,edege2,edege3,edege4,
                edege5,edege6,edege7,edege8,edege9,
                edege10,edege11,edege12,edege13,edege14};
    }

    public static void main(String[] args) {
        GraphKruskal gk = new GraphKruskal(15);
        gk.createEdgeArray();
        gk.miniSpanTreeKruskal();
    }

    public void miniSpanTreeKruskal(){
        int m,n,sum = 0;
        //用于检验是否有回环  a[4] = 7
//        神奇的数组,下标为起点,值为终点
        int[] parent = new int[edgeSize];
        for (int i = 0;i < edgeSize;i++){
            parent[i] = 0;
        }
        for (int i = 0; i < edgeSize; i++) {
            n = find(parent,edeges[i].begin);
            m = find(parent,edeges[i].end);
            if (n != m){
                parent[n] = m;
                System.out.println("起始节点:"+edeges[i].begin+",结束重点:"+edeges[i].end+",权值:"+edeges[i].weight);
                sum +=edeges[i].weight;
            }
        }
        System.out.println("sum:"+sum);
    }

    /*
    将神奇数组进行查询获取非回环的路
     */
    private int find(int[] parent, int f) {
        while (parent[f] > 0){
            f = parent[f];
        }
        return f;
    }


}
