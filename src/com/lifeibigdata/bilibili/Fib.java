package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/5/15.
 */
public class Fib {
    public static void main(String[] args) {
        int num = 13;
        int[] fib = new int[num];
        fib[0] = 1;
        fib[1] = 1;

        for (int i =2;i<num;i++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int i = 0;i < num;i++) {
            System.out.println("第"+i+"个月为"+fib[i]);
        }
    }
}
