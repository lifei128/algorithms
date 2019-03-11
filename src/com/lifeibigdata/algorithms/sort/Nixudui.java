package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/8/9.
 *
 */
public class Nixudui {
    static int[] tmp ;
    static int count = 0;
    public static void main(String[] args) {
        int a[] = {3,56,2,7,45,8};
        tmp = new int[a.length];
        mergeSort(a,0,a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i]+",");
        }
        System.out.println();
        System.out.println("count:"+count);
    }

    static void mergeSort(int[] a, int low, int high) {
        if (low >= high){
            return;
        }
        int mid = (low + high)/2;
        mergeSort(a,low,mid);
        mergeSort(a,mid+1,high);
        merge(a,low,mid,high);
    }

    static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid +1;
        int size = 0;
        for (;(i <= mid) && (j <= high); size++) {
            if (a[i] < a[j]){
                tmp[size] = a[i++];
            } else {
                count += (mid - i +1);
                printPair(a,j,i,mid);
                tmp[size] = a[j++];
            }
        }
        while (i <= mid){
            tmp[size++] = a[i++];
        }
        while (j<= high){
            tmp[size++] = a[j++];
        }
        for (int k = 0; k < size; k++) {
            a[low+k] = tmp[k];
        }
    }

    static void printPair(int[] a, int j, int i, int mid) {
        for (int k = i; k <= mid ; k++) {
            System.out.println(a[k]+","+a[j]);
        }
    }
}
