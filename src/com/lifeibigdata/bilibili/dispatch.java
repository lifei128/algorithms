package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/20.
 *
 */
public class dispatch {

    //8支球队7天比完
    public void scheduleTable(int[][] table,int n){
        if (n == 1){
            table[0][0] = 1;
        }else {
            //填充左上区域矩阵
            int m = n/2;
            scheduleTable(table,m);//todo 重点
            //填充右上区域矩阵
            for (int i = 0; i < m; i++) {
                for (int j = m; j < n; j++) {
                    table[i][j] = table[i][j - m] + m;
                }
            }
            //填充左下区域矩阵
            for (int i = m; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    table[i][j] = table[i - m][j]+m;
                }
            }
            //填充右下区域矩阵
            for (int i = m; i < n; i++) {
                for (int j = m; j <n ; j++) {
                    table[i][j] = table[i -m][j-m];
                }
            }
        }
    }

    public static void main(String[] args) {
        dispatch d = new dispatch();
        int[][] table = new int[8][8];
        int n = 8;
        d.scheduleTable(table,8);
        int c = 0;
        for (int i = 0;i<n;i++){
            for (int j = 0; j < n; j++) {
                System.out.print(table[i][j]+" ");
                c++;
                if (c%n == 0){
                    System.out.println();
                }
            }
        }
    }
}
