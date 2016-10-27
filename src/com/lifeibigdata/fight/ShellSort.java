package com.lifeibigdata.fight;

/**
 * Created by lifei on 16/10/24.
 */
public class ShellSort {

    static int[] shellSort(int[] a){
        int gap = a.length / 2;
        while (gap >= 1){
            // 把距离为 gap 的元素编为一个组，扫描所有组
//            for (int i = gap; i < a.length; i++) {
//                int j;
//                int temp = a[i];

                  //对距离为 gap 的元素组进行排序
//                 for (j = i - gap; j >= 0 && temp < a[j]; j = j - gap) {//TODO   j - gap
//                     a[j + gap] = a[j];//TODO i - gap + gap
//                 }
//                 a[j + gap] = temp;//TODO   j - gap + gap = j
//             }

            for (int i = gap; i < a.length; i++) {
                if (a[i] < a[i - gap]){
                    int tmp = a[i];
                    a[i] = a[i - gap];
                    a[i - gap] = tmp;
                }
            }

            gap = gap /2;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{9  ,  1   , 2  ,  5  ,  7  ,  4  ,  8  ,  6  ,  3   , 5};
        int[] r = shellSort(a);
        for (int x:r) {
            System.out.println(x);
        }
    }

}
