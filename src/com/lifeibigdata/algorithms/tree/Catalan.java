package com.lifeibigdata.algorithms.tree;

/**
 * Created by lifei on 16/9/21.
 *
 */
public class Catalan {
    public static void main(String[] args) {
        int n = 20;
        int[] catalan = new int[n + 1];
        getCatalan(catalan,n);
        printNumber(catalan,n);
    }

    private static void printNumber(int[] catalan, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(i+"  "+catalan[i]);
        }
    }

    private static void getCatalan(int[] pCalatan, int N) {
        pCalatan[0] = 1;
        pCalatan[1] = 1;
        int c;
        for (int i = 2; i <= N; i++) {
            pCalatan[i] = 1;
            c = 0;
            for (int j = 0; j < i; j++) {
                c += pCalatan[j] * pCalatan[i - j - 1];
            }
            pCalatan[i] = c;
        }
    }
}
