package com.lifeibigdata.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by lifei on 16/9/18.
 */
public class Gantt {
    static class tagSItem implements Comparable<tagSItem>{
        int t;
        int nIndex;
        boolean bFirst;

        @Override
        public int compareTo(tagSItem o) {
            return this.t > o.t ? 1 : -1;//TODO 正负值
        }
    }

    public static void main(String[] args) {
        int a[] = {8,6,2,4};
        int b[] = {3,1,3,12};
        int c[] = new int[a.length];
        ganttChart(a,b,c);
        print(c);
    }

    private static void print(int[] c) {
        for (int x:c) {
            System.out.println(x);
        }
    }

    private static void ganttChart(int[] a, int[] b, int[] c) {
        int s2 = a.length * 2;
        //整理数据
        tagSItem[] pItem = new tagSItem[s2];
        tagSItem ts;
        for (int i = 0; i < a.length; i++) {
            ts = new tagSItem();
            ts.t = a[i];
            ts.nIndex = i;
            ts.bFirst = true;
            pItem[i] = ts;

            ts = new tagSItem();
            ts.t = b[i];
            ts.nIndex = i;
            ts.bFirst = true;
            pItem[a.length + i] = ts;
        }
        Collections.sort(Arrays.asList(pItem));
//        for (tagSItem t:pItem) {
//            System.out.println("---"+t.t);
//        }
        boolean[] bArrage = new boolean[a.length];//d[i],第i号已经安排
        int from = 0;
        int to = a.length -1;
        for (int i = 0; i < s2; i++) {
            if (bArrage[pItem[i].nIndex])//pItem.nIndex已经确定
                continue;
            bArrage[pItem[i].nIndex] = true;
            if (pItem[i].bFirst){
                c[from] = pItem[i].nIndex;
                from++;
            } else {
                c[to] = pItem[i].nIndex;
                to--;
            }
            if (to - from < 0)//提前退出
                break;
        }
    }
}
