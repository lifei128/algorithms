package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/9.
 */
public class Holland {



    public static void main(String[] args) {
        int a[] = {1,1,0,0,2,2,0,0,2,2,1,1};
        holland4(a);
        for (int x:a) {
            System.out.printf(x+" ");
        }
        System.out.println();
    }

    private static void holland(int[] a) {
        int begin = 0;
        int current = 0;
        int end = a.length - 1;
        while (current <= end){
            if (a[current] == 2){
                swap(a,end,current);
                end--;
            } else if (a[current] == 1){
                current++;
            } else {//if(a[current] == 0)
                if (begin == current){
                    begin++;
                    current++;
                } else {//TODO 比如这种情况1100
                    swap(a,current,begin);
                    begin++;
                }
            }
        }
    }

    private static void holland2(int[] a) {
        int begin = 0;
        int current = 0;
        int end = a.length - 1;
        while (current <= end){
            if (a[current] == 2){
                swap(a,end,current);
                end--;
            } else if (a[current] == 1){
                current++;
            } else {//if(a[current] == 0)
                if (begin == current){
                    begin++;
                    current++;
                } else {
                    swap(a,current,begin);
                    begin++;
                    current++;//TODO
                }
            }
        }
    }


    private static void holland3(int[] a) {
        int begin = 0;
        int current = 0;
        int end = a.length - 1;
        while (current <= end){
            if (a[current] == 2){
                swap(a,end,current);
                end--;
            } else if (a[current] == 1){
                current++;
            } else {//if(a[current] == 0)
                if (begin != current){//或者用更直接的判断if(a[current] != a[begin]),因为不等的次数远远大约相等的次数,可以直接删除该判断
                    swap(a,current,begin);
                }
                begin++;
                current++;//TODO
            }
        }
    }

    private static void holland4(int[] a) {
        int begin = 0;
        int end = a.length - 1;
        int current = end;
        while (current >= begin){
            if (a[current] == 2){
                swap(a,end,current);
                end--;
                current--;
            } else if(a[current] == 1){
                current--;
            } else {
                swap(a,current,begin);
                begin++;
            }
        }
    }

    private static void swap(int[] a, int end, int current) {
        int tmp = a[end];
        a[end] = a[current];
        a[current] = tmp;
    }
}
