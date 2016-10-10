package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/8.
 */
public class FirstMissNumber {
    public static void main(String[] args) {
        int a[] = {3,5,1,2,-3,7,14,8};
        int m = firstMissNumber(a);
        System.out.println(m);
    }

    private static int firstMissNumber(int[] a) {
        for (int i = 0; i < a.length; ) {//TODO
            if (a[i] == i + 1){
                i++;
            } else {
                if (a[i] >= 1 && a[i] <= a.length && a[a[i]] != a[i]){
                    swap(a,i,a[i] - 1);
                } else {
                    i++;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != i+1){
                return i+1;
            }
        }
        return a.length + 1;
    }


    private static void swap(int[] a, int ai, int i) {
        int tmp = a[ai];
        a[ai] = a[i];
        a[i] = tmp;
    }
}
