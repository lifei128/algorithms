package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/9.
 */
public class MaxSequence {


    static int from ;
    static int to ;
    public static void main(String[] args) {
        int a[] = {1,2,3,34,56,57,58,59,60,61,99,121};
        int m = maxSequence3(a);
        System.out.println(m+"---"+from+"---"+to);
    }

    private static int maxSequence(int[] a) {
        int[] p = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            p[i] = 1;
        }

        int m = 1;
        for (int i = 1; i < a.length; i++) {//TODO
            if (a[i] - a[i - 1] == 1){
                p[i] += p[i - 1];
                m = Math.max(p[i],m);
            }

        }
        for (int x:p) {
            System.out.printf(x+"---");
        }
        System.out.println();
        return m;
    }


    //滚动数组
    private static int maxSequence2(int[] a) {
        if (a == null || a.length <= 0){
            return 0;
        }
        int m = 1;
        int p = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == 1){
                p++;
                m = Math.max(m,p);
            } else {
                p = 1;
            }
        }
        return m;
    }


    private static int maxSequence3(int[] a) {
        if (a == null || a.length <= 0){
            return 0;
        }
        int m = 1;
        int p = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] - a[i - 1] == 1){
                p++;
                if (m < p){
                    m = p;
                    to = i;
                }
            } else {
                p = 1;
            }
        }
        from = to - m + 1;
        return m;
    }
}
