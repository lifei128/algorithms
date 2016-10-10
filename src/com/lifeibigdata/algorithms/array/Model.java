package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/8.
 */
public class Model {
    public static void main(String[] args) {
        int a[] = {8,8,1,1,1,8,1,1,6,1,8};
        int m = model(a);
        System.out.println(m);
    }

    private static int model(int[] a) {
        int count = 0;
        int m = a[0];
        for (int i = 0; i < a.length; i++) {
            if (count == 0){
                m = a[i];
                count = 1;
            } else if (m != a[i]){
                count--;
            } else {
                count++;
            }
        }
        return m;
    }
}
