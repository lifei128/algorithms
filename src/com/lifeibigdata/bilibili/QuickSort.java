package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/19.
 *
 */
public class QuickSort {
    public void quick(int[] a){
        if (a.length > 0){
            quickSort(a,0,a.length - 1);
        }
    }

    /**
     * 快速排序
     */
    private void quickSort(int[] a, int low, int heigh) {
        if (low < heigh){
            int middle = getMiddle(a,low,heigh);
            quickSort(a,0,middle - 1);
            quickSort(a,middle + 1,heigh);
        }
    }

    /**
     * 获取中间下标
     * @param a
     * @param low
     * @param heigh
     * @return
     */
    private int getMiddle(int[] a, int low, int heigh) {
        int temp = a[low];//基准元素
        while (low < heigh){
            while (low < heigh && a[heigh] >= temp){
                heigh--;
            }
            //交换high和基准元素  或者交换low和heigh
            a[low] = a[heigh];
            while (low < heigh && a[low] <= temp){
                low++;
            }
            //交换low和基准元素    或者交换low和heigh
            a[heigh] = a[low];
        }
        a[low] = temp;//插入到排序后正确的位置
        return low;
    }

    public static void main(String[] args) {
        int a[] = {9,3,2,10,44,83,28,5,1,0,36};
        QuickSort qs = new QuickSort();
        qs.quick(a);
        for (int x:a) {
            System.out.println(x);
        }
    }
}
