package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/25.
 */
public class LongestCommonSubsequence {


    public static void main(String[] args) {
        char[] x = {' ','A','B','C','B','D','A','B'};
        char[] y = {' ','B','D','C','A','B','A'};
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        lcs.printLCS(lcs.lcsLength(x, y), x, x.length-1, y.length-1);
    }

    void printLCS(int[][] b,char[] x,int i,int j){
        if(i == 0 || j == 0)
            return;
        if(b[i][j] == 1){
            printLCS(b,x,i - 1,j - 1);
            System.out.print(x[i] + "\t");
        }else if(b[i][j] == 2)
            printLCS(b,x,i - 1,j);
        else
            printLCS(b,x,i,j - 1);
    }


    int[][] lcsLength(char[] x,char[] y){
        int m = x.length;
        int n = y.length;
        int i,j;
        int[][] c = new int[m][n];
        int[][] b = new int[m][n];
        for(i = 1;i < m;i++)
            c[i][0] = 0;
        for(j = 0;j < n;j++)
            c[0][j] = 0;


        for(i = 1;i < m;i++)
            for(j = 1;j < n;j++){
                if(x[i] == y[j]){
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                }
                else if(c[i - 1][j] >= c[i][j - 1]){
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                }else{
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        return b;
    }
}


/**
 * 滚动数组只求大小
 * 求全部的lcs
 *
 * 最长递增子序列
 * lis
 *
 */
