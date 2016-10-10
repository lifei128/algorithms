package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/8.
 */
public class LocalMaximum {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,3,2,1};
        int m = localMaximum(A);
        System.out.println(m);
    }

    private static int localMaximum(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int mid;
        while (left < right){
            mid = (left + right) / 2;
            if (a[mid] > a[mid + 1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return a[left];
    }


}
