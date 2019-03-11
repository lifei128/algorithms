package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/21.
 * 八皇后
 */
public class Queen {
    public static int num = 0;//累计方案
    public static final int MAXQUEEN = 8;
    public static int[] cols = new int[MAXQUEEN];//定义cols数组,表示8列棋子摆放的位置

    /**
     * n 天第n列的皇后
     * @param n
     */
    public void getCount(int n){
        boolean[] rows = new boolean[MAXQUEEN];//记录每列每个方格是否可以放皇后
        for (int m = 0; m < n; m++) {
            rows[cols[m]] = true;
            int d = n - m;//斜对角
            //正斜对角 右上
            if (cols[m] -d >= 0){
                rows[cols[m] -d] = true;
            }
            //反斜对角 右下
            if (cols[m] + d <= (MAXQUEEN -1)){
                rows[cols[m] + d] = true;
            }
        }
        //到此知道了哪些位置不能放皇后
        for (int i = 0; i < MAXQUEEN; i++) {
            if (rows[i]){
                //不能放
                continue;
            }
            cols[n] = i;
            //下面可能仍有合法位置
            if (n < MAXQUEEN - 1){
                getCount(n + 1);
            } else {
                //找到一套完整的一套方案
                num++;
                printQueen();
            }
            //下面可能仍然有合法位置

        }
    }

    private void printQueen() {
        System.out.println("第"+num+"中方案");
        for (int i = 0; i <MAXQUEEN ; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if (i == cols[j]){
                    System.out.print("0 ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queen q = new Queen();
        q.getCount(0);
    }
}
