package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/25.
 */
public class Permutation {

    static int[] a;

    public Permutation(int[] a){
        this.a = a;
    }


    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4};
        Permutation p = new Permutation(a);
        p.permutation(a.length,0);
    }

    private void permutation(int length, int start) {
        if (start == length -1){
            print(length);
        } else {
            for (int i = start; i< length;i++){        //for循环只有第一次进来是i = start
                swap(i,start);
                permutation(length,start+1);
                swap(i,start);//注意这个地方是索引值,一定不要填写a[i]  a[start]
            }
        }

    }

    private void swap(int i, int start) {
        int tmp = a[start];
        a[start] = a[i];
        a[i] = tmp;
    }

    private void print(int length) {
        for (int i = 0; i < length;i++){
            System.out.printf(a[i]+" ");
        }
        System.out.println();
    }

}
