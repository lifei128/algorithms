package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/10/8.
 */
public class MinPeriod {

    public static void main(String[] args) {
        System.out.println(minPeriod("abababab".toCharArray()));
    }
    static int minPeriod(char[] p){
        int nLen = p.length;
        if (nLen == 0)
            return -1;
        int[] next = new int[nLen];//仿照KMP求"伪next"
        next[0] = -1;//哨兵:串首位置
        int k = -1;
        int j = 0;
        while (j < nLen - 1){
            if (k == -1 || p[j + 1] == p[k]){
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        next[0] = 0;//恢复成逻辑上的0
        int nLast = next[nLen - 1];
        if (nLast == 0)
            return -1;
        if (nLen % (nLen - nLast) == 0)
            return nLen - nLast;
        return -1;
    }
}
