package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/8.
 */
public class TwoDiff {
    public static void main(String[] args) {
        int[] a = {0,3,7,9,11,14,16,17};
        twoDiff(a,7);
        for (int x: a) {
            System.out.print(x + " ");
        }
    }

    private static void twoDiff(int[] a, int diff) {
        int i=0,j=0;
        while (i <= a.length - 1 && j <= a.length - 1){
            if (a[i] < a[j]+diff){
                i++;
            } else if (a[i] > a[j]+diff){
                j++;
            } else {
                i++;
                j++;
            }
        }
    }
}
