package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/10/7.
 */
public class Permutation3 {
    static int a[] = {1,2,2,3};
    public static void main(String[] args) {
        print();
        while(getNextPermutation()){
            print();
        }
    }

    private static void print() {
        for (int x:a) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    private static boolean getNextPermutation() {
        //后找
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]){
            i--;
        }
        if (i < 0){
            return false;
        }

        //小大
        int j = a.length - 1;
        while (a[j] <= a[i]){
            j--;
        }

        //交换
        swap(j,i);

        //翻转
        reverse(i + 1,a.length - 1);
        return true;
    }

    private static void reverse(int from, int to) {
        while (from < to){
            int t = a[from];
            a[from] = a[to];
            a[to] = t;
            from++;
            to--;
        }
    }

    private static void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


}
