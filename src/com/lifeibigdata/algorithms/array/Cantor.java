package com.lifeibigdata.algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 16/10/10.
 */
public class Cantor {

    public static void main(String[] args) {
        int[] p = {3,4,1,2,1,0};
        int[] a = new int[p.length];
        cantorExpanse3(p,a);
        for (int x:a) {
            System.out.printf(x+" ");
        }
        System.out.println();

    }

    private static void cantorExpanse(int[] a, int[] b) {//?
        for (int i = 0; i < a.length; i++) {
            b[i] = 0;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]){
                    b[i]++;
                }
            }
        }
    }

    private static void cantorExpanse2(int[] a, int[] b) {//?
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            v.add(i+1);
        }
        for (int i = 0; i < a.length; i++) {
            b[i] = v.get(a[i]);
            System.out.println(v.size() +"---"+v.get(0)+a[i]);
            v.remove(v.get(0)+ a[i]);
        }
    }

    private static void cantorExpanse3(int[] a, int[] b) {//可以解决问题
        int i,j;
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a.length; j++) {
                if (b[j] != 0)
                    continue;
                if (a[j] == 0)
                    break;
                a[j]--;
            }
            b[j] = i + 1;
        }
    }


}
