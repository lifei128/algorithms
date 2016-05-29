package com.lifeibigdata.algorithms.google;

/**
 * Created by lifei on 16/5/23.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GraphFactory {

    /**
     * 规定：边的数目要大于等于点的数目
     * @return
     * @throws Exception
     */
    public static Adjacent_List getRandomGraph() throws Exception{
        int vertex_number = 0;
        int edge_number = 0;
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("点的数目：");
            vertex_number = scanner.nextInt();
            System.out.println("\n边的数目：");
            edge_number = scanner.nextInt();
            if(vertex_number>edge_number){
                System.out.println("***************************\n边的数目要大于等于点的数目\n***************************");
                continue;
            }
            else break;
        }
        PrintWriter writer = new PrintWriter(new FileOutputStream("random.txt"), true);
        writer.println(vertex_number+" "+edge_number);
        for(int i=1;i<=vertex_number;i++){
            int end = new Random().nextInt(vertex_number)+1;
            writer.println(i+" "+end);
        }
        int other = edge_number - vertex_number;
        for(int i=0;other>0&&i<other;i++){
            int begin = new Random().nextInt(vertex_number)+1;
            int end = new Random().nextInt(vertex_number)+1;
            writer.println(begin+" "+end);
        }
        return getAdjacentListInstance("random.txt");
    }

    /**
     * 创建一个邻接表
     * @param file
     * @return
     * @throws Exception
     */
    public static Adjacent_List getAdjacentListInstance(String file) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = reader.readLine();
        String[]str = line.split(" ");
        int vertex_size = Integer.parseInt(str[0]);
        int edge_size = Integer.parseInt(str[1]);
        Adjacent_List adjList = new Adjacent_List(vertex_size,edge_size);
        for(int i=0;i<edge_size;i++){
            line = reader.readLine();
            str = line.split(" ");
            adjList.addEdge(str[0],str[1]);
        }
        return adjList;
    }
    /**
     * 创建一个邻接矩阵
     * @param file
     * @return
     * @throws Exception
     */
    public static Adjacent_Matrix getAdjacentMatrixInstance(String file) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = reader.readLine();
        String[]str = line.split(" ");
        int vertex_size = Integer.parseInt(str[0]);
        int edge_size = Integer.parseInt(str[1]);
        Adjacent_Matrix matrix = new Adjacent_Matrix(vertex_size);
        for(int i=0;i<edge_size;i++){
            line = reader.readLine();
            str = line.split(" ");
            matrix.addEdge(str[0],str[1]);
        }
        return matrix;
    }
    public static Weighted_Adjacent_List getWeightedAdjacentListInstance(String file)throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = reader.readLine();
        String[]str = line.split(" ");
        int vertex_size = Integer.parseInt(str[0]);
        int edge_size = Integer.parseInt(str[1]);
        Weighted_Adjacent_List adjacent_list = new Weighted_Adjacent_List(vertex_size);
        for(int i=0;i<edge_size;i++){
            line = reader.readLine();
            str = line.split(" ");
            adjacent_list.addEdge(str[0],str[1],Integer.parseInt(str[2]));
        }
        return adjacent_list;
    }
    public static void main(String[] args) throws Exception {
        //Adjacent_List adjList = GraphFactory.getAdjacentListInstance("input"+File.separator+"dfs_input.txt");
        Adjacent_List adjList = GraphFactory.getRandomGraph();
        adjList.printAllEdges();
    }
}
