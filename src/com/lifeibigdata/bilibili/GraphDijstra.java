package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/18.
 *
 */
public class GraphDijstra {

    private final static int MAXVEX = 9;
    private final static int MAX = 1000;//不要去最大值,避免内存溢出

    private static int shortTablePath[] = new int[MAXVEX];//记录的是v0到某顶点的最短路径和
    public void shortestPath(Graph graph){
        int min;
        int k = 0;//记录下标
        boolean isgetPath[] = new boolean[MAXVEX];
        for (int v = 0; v < graph.vertexSize; v++) {
            shortTablePath[v] = graph.matrix[0][v];//获取vo这一样的权值数组
        }
        isgetPath[0] = true;
        for (int v = 1; v < graph.vertexSize; v++) {
            min = MAX;
            for (int w = 0; w < graph.vertexSize; w++) {//找到最小值
                if (!isgetPath[w] && shortTablePath[w] < min){
                    k = w;
                    min = shortTablePath[w];
                }
            }
            isgetPath[k] = true;
            for (int j = 0; j < graph.vertexSize; j++) {
                if (!isgetPath[j] && (min + graph.matrix[k][j] < shortTablePath[j])){
                    shortTablePath[j] = min + graph.matrix[k][j];
                }
            }
        }
        for (int i = 0; i < shortTablePath.length; i++) {
            System.out.println("vo到v"+i+"最短路径之和为:"+shortTablePath[i]);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(MAXVEX);
        g.matrix = new int[][]{
                {0,1,5,MAX,MAX,MAX,MAX,MAX,MAX},
                {1,0,3,7,5,MAX,MAX,MAX,MAX},
                {5,3,0,MAX,1,7,MAX,MAX,MAX},
                {MAX,7,MAX,0,2,MAX,3,MAX,MAX},
                {MAX,5,1,2,0,3,6,9,MAX},
                {MAX,MAX,7,MAX,3,0,MAX,5,MAX},
                {MAX,MAX,MAX,3,6,MAX,0,2,7},
                {MAX,MAX,MAX,MAX,9,5,2,0,4},
                {MAX,MAX,MAX,MAX,MAX,MAX,7,4,0}
        };
        GraphDijstra gd = new GraphDijstra();
        gd.shortestPath(g);
    }
}
