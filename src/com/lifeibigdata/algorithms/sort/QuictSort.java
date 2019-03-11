package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/9/19.
 *
 */
public class QuictSort {
    public static void main(String[] args) {
        int a[] = {3,56,2,7,45,8};
        quickSort(a);
        for (int i:a) {
            System.out.printf(i+",");
        }
    }

    private static void quickSort(int[] a) {
        _quickSort(a,0,a.length - 1);
    }

    private static void _quickSort(int[] a, int from, int to) {
//        if (to - from <= 10){
//            BubbleSort//冒泡排序
//            return;
//        }
        int dp;
        if (from < to){
            dp = partition(a,from,to);
            _quickSort(a,from,dp -1);
            _quickSort(a,dp+1,to);
        }
    }

    private static int partition(int[] a, int from, int to) {
        int pivot = a[from];
        while (from < to){
            while (from < to && a[to] >= pivot )
                to--;
            if (from < to)
                a[from++] = a[to];
            while (from < to && a[from] <= pivot)
                from++;
            if (from < to)
                a[to--] = a[from];
        }
        a[from] = pivot;
        return from;
    }
}
