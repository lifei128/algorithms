package com.lifeibigdata.bilibili;

import java.util.Arrays;

/**
 * Created by lifei on 2018/6/20.
 */
public class Greedy {
    private static int MAX_WEIGHT = 150;
    private static int[] weights = new int[]{35,30,60,50,40,10,25};
    private static int[] values = new int[]{10,40,30,50,35,40,30};

    private void packageGready(int capacity,int[] weights,int[] values){
        int n = weights.length;
        double[] r = new double[n];//性价比数组
        int[] index = new int[n];//按性价比排序物品的下标
        for (int i = 0; i < n; i++) {
            r[i] = (double) values[i]/ weights[i];
            index[i] = i;//默认排序
        }

        double temp = 0;//对性价比排序
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (r[i] < r[j]){//降序
                    temp = r[i];
                    r[i] = r[j];
                    r[j] = temp;
                    int x = index[i];
                    index[i] = index[j];
                    index[j] = x;
                }
            }
        }

        //排序好的重量和价值分别存到数组
        int[] w1 = new int[n];
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            w1[i] = weights[index[i]];
            v1[i] = values[index[i]];
        }

        int[] x = new int[n];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (w1[i] < capacity){//还可以装的下
                x[i] = 1;//表示该物体被装了
                capacity = capacity - w1[i];
                maxValue += v1[i];
                System.out.println("物品"+w1[i]+"被放进包包");
            }
        }
        System.out.println("总共放下的物品数量:"+ Arrays.toString(x));
        System.out.println("最大价值:"+maxValue);
    }

    public static void main(String[] args) {
        Greedy g = new Greedy();
        g.packageGready(MAX_WEIGHT,weights,values);
    }
}
