package com.lifeibigdata.bilibili;

import java.util.Stack;

/**
 * Created by lifei on 2018/6/18.
 */
public class GraphTopologic {
    //边表顶点
    class EdgeNode{
        int adjVert;//下标
        EdgeNode next;
        int weight;
        EdgeNode(int adjVert){
            this.adjVert = adjVert;
        }
    }

    //邻接顶点
    class VertexNode{
        int in;
        String data;
        EdgeNode firstEdge;
        public VertexNode(int in,String data){
            this.in = in;
            this.data = data;
        }
    }
    private  VertexNode[] adjList;//邻接顶点的一维数组
    private int numVertexes = 14;

    /**
     * 拓扑排序
     */
    public void topoSort() throws Exception {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int k = 0;
        for (int i = 0; i < numVertexes; i++) {
            if (adjList[i].in == 0){
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            int pop = stack.pop();
            System.out.println("顶点:"+adjList[pop].data);
            count++;
            for (EdgeNode node = adjList[pop].firstEdge;
                    node != null;
                    node = node.next){
                k = node.adjVert;//下标
                if (--adjList[k].in == 0){
                    stack.push(k);//入度为0,入栈
                }
            }
        }
        if(count < numVertexes){
            throw new Exception("balabala");
        }
    }

    private void createGraph(){
        VertexNode node0 = new VertexNode(0,"v0");
        VertexNode node1 = new VertexNode(0,"v1");
        VertexNode node2 = new VertexNode(2,"v2");
        VertexNode node3 = new VertexNode(0,"v3");
        VertexNode node4 = new VertexNode(2,"v4");
        VertexNode node5 = new VertexNode(3,"v5");
        VertexNode node6 = new VertexNode(1,"v6");
        VertexNode node7 = new VertexNode(2,"v7");
        VertexNode node8 = new VertexNode(2,"v8");
        VertexNode node9 = new VertexNode(1,"v9");
        VertexNode node10 = new VertexNode(1,"v10");
        VertexNode node11 = new VertexNode(2,"v11");
        VertexNode node12 = new VertexNode(1,"v12");
        VertexNode node13 = new VertexNode(2,"v13");
        adjList = new VertexNode[]{
                node0,node1,node2,node3,node4,
                node5,node6,node7,node8,node9,
                node10,node11,node12,node13
        };
        node0.firstEdge = new EdgeNode(11);node0.firstEdge.next = new EdgeNode(5);node0.firstEdge.next.next = new EdgeNode(4);
        node1.firstEdge = new EdgeNode(8);node1.firstEdge.next = new EdgeNode(4);node1.firstEdge.next.next = new EdgeNode(2);
        node2.firstEdge = new EdgeNode(9);node2.firstEdge.next = new EdgeNode(6);node2.firstEdge.next.next = new EdgeNode(5);
        node3.firstEdge = new EdgeNode(13);node3.firstEdge.next = new EdgeNode(2);
        node4.firstEdge = new EdgeNode(7);
        node5.firstEdge = new EdgeNode(12);node5.firstEdge.next = new EdgeNode(8);
        node6.firstEdge = new EdgeNode(5);
        node8.firstEdge = new EdgeNode(7);
        node9.firstEdge = new EdgeNode(11);node9.firstEdge.next = new EdgeNode(10);
        node10.firstEdge = new EdgeNode(13);
        node12.firstEdge = new EdgeNode(9);
    }

    public static void main(String[] args) throws Exception {
        GraphTopologic gt = new GraphTopologic();
        gt.createGraph();
        gt.topoSort();;
    }
}
