package com.lifeibigdata.bilibili;

import java.util.LinkedList;

/**
 * Created by lifei on 2018/6/18.
 */
public class Graph {
    public int vertexSize;//顶点数量
    public int[] vertexs; // 顶点数组
    public static int[][] matrix;
    public static final int MAX = Integer.MAX_VALUE;
    public boolean[] isVisited;

    public Graph(int vertexSize){
        this.vertexSize = vertexSize;
        vertexs = new int[vertexSize];
        for (int i = 0;i < vertexSize;i++){// o 1 2 3 4 5 6 7 8顶点数组
            vertexs[i] = i;
        }
        isVisited = new boolean[vertexSize];
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);
        matrix = new int[][]{
                {0,10,MAX,MAX,MAX,11,MAX,MAX,MAX},
                {10,0,18,MAX,MAX,MAX,16,MAX,12},
                {MAX,MAX,0,22,MAX,MAX,MAX,MAX,8},
                {MAX,MAX,22,0,20,MAX,MAX,16,21},
                {MAX,MAX,MAX,20,0,26,MAX,7,MAX},
                {11,MAX,MAX,MAX,26,0,17,MAX,MAX},
                {MAX,16,MAX,MAX,MAX,17,0,19,MAX},
                {MAX,MAX,MAX,16,7,MAX,19,0,MAX},
                {MAX,12,8,21,MAX,MAX,MAX,MAX,0}
        };
//        g.publicdfs();
//        g.publicbfs();
        g.prim();


    }

    //获取某个顶点的出度  取横向数组 >0 <max
    //获取某个顶点的入度  取纵向数组 >0 <max
    //获取两个顶点之前的权值
    public int getWeight(int v1,int v2){
        int weight = matrix[v1][v2];
        return  weight == 0 ? 0 : (weight == MAX ? -1 : weight);
    }

    /**
     * 获取某个顶点的第一个邻接点   就是获取横向第一个 >0 <max 的点
     */
    public int getFirstNeighbor(int index){ //index表示计算第几个节点    返回的是索引
        for (int j = 0;j<vertexSize;j++){
            if (matrix[index][j] >0 && matrix[index][j] < Integer.MAX_VALUE){
                return j;
            }
        }
        return -1;//表示没有找到
    }

    /**
     *根据前一个邻接点的小标来取得下一个邻接点    也是横向数组
     * v 表示要找的顶点
     * index 表示该顶点相对于哪个邻接点去获取下一个邻接点
     */
    public int getNextNeighbor(int v,int index) {//返回的是索引
        for (int j = index + 1; j < vertexSize; j++) {
            if (matrix[v][j] >0 && matrix[v][j] < Integer.MAX_VALUE){
                return j;
            }
        }
        return -1;
    }
    /**
     * 图的深度优先遍历
     */
    public void dfs(int i){
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){//需要遍历该顶点
                System.out.println("访问到了:"+w+"节点");
                //v0 v1 v2 v3 v4 v5 v6 v7都迭代调用后后,v7 v6 v5 v4 v3 v2会依次弹出执行后面的操作,只有v2会继续找到v8
                dfs(w);
            }
            w = getNextNeighbor(i,w);//节点第一个相对应w的邻接点
        }
    }
    /**
     * 对外公开的深度优先遍历
     */
    public void publicdfs(){
        isVisited = new boolean[vertexSize];
        for (int i = 0;i < vertexSize;i++) {
            if (!isVisited[i]){//  可以计算0节点深度遍历后仍然无法遍历到的节点   v8
                System.out.println("访问到了:"+i+"节点");
                dfs(i);
            }
        }
        isVisited = new boolean[vertexSize];
    }
    /**
     * 广度优先遍历  broadFirstSearch
     */
    public void publicbfs(){
        isVisited = new boolean[vertexSize];
        for (int i = 0;i < vertexSize;i++) {
            if (!isVisited[i]){//不一定是连通图 计算联通分量
                bfs(i);
            }
        }
    }

    /**
     * 实现广度优先遍历
     * @param i
     */
    private void bfs(int i) {
        int u,w;
        LinkedList<Integer> queue = new LinkedList<>();  //linkedlist实现了queue接口  双向指针
        System.out.println("访问到:"+i+"顶点");
        isVisited[i] = true;
        queue.add(i); //第一次把vo加到队列
        while (!queue.isEmpty()){
            u = queue.removeFirst();//vo    第二次先弹v1 v5
            w = getFirstNeighbor(u); //w表示v1
            while (w != -1){
                if (!isVisited[w]){
                    System.out.println("访问到:"+w+"顶点");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u,w);//v0相对于v1   结果w表示v5
            }
        }
    }
    /**
     *  结果是 0 1 5 2 6 8 4 3 7为什么显示6后是8,因为getNextNeighbor查后继邻接点的时候是按照0~8的顺序找的,而不是按照图形左右顺序的
     */
    /**
     * prim 普利姆算法
     */
    public void prim(){
        int[] lowcost = new int[vertexSize];//最小代价顶点权值的数组,为0表示已经获取最小权值   也会放顶点权值,一旦权值最小了,就会变成0
        int[] adjevx = new int[vertexSize];//放顶点权值 下标
        int min,minId,sum = 0; //最小的边  下标
        for (int i = 1;i < vertexSize;i++){//初始化
            lowcost[i] = matrix[0][i];//v0 行,去除第一列 [0 10 # # # 11 # # #]
        }
        for (int i = 1;i < vertexSize;i++){
//          第二次循环进入lowcost为[0 0 18 # # 11 16 # 12]
//          第三次循环进入lowcost为[0 0 18 # 26 0 16 # 12]
//          第四次循环进入lowcost为[0 0 8 21 26 0 16 # 0]
            min = MAX;
            minId = 0;
            for (int j = 1;j < vertexSize;j++){
                //第一次赋值 min是10 minId是1
                //第一次赋值 min是11
                //第一次赋值 min是12
                if (lowcost[j] < min && lowcost[j] > 0){//判断有效权值
                    min = lowcost[j];
                    minId = j;  //此时minId是按照列
                }
            }
            System.out.println("顶点:"+adjevx[minId]+"权值:"+min);
            sum+=min;
            lowcost[minId] = 0; //已经确定最小,所以改为0   [0 0 # # # 11 # # #]
//            第二次  [0 0 18 # # 0 16 # 12]
            for (int j = 1;j < vertexSize;j++){
                if (lowcost[j] != 0 && matrix[minId][j] < lowcost[j]){//此时minId是按照行
                    lowcost[j] = matrix[minId][j];
                    adjevx[j] = minId;//存放权值小标
                }
            }
        }
        System.out.println("最小生成树权值和:"+sum);
    }
}
