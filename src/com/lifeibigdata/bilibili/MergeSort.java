package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/19.
 */
public class MergeSort {

    public void mergeSort(int[] a,int left,int right){
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }

    }

    private void merge(int[] a, int left, int mid, int right) {
        int[] tempArray = new int[a.length];
        int rightStart = mid + 1;
        int temp = left;
        int third = left;
        //比较两个小数组相应下标位置的数组大小,小的先放进数组
        while (left <= mid && rightStart <= right){
            if (a[left] <= a[rightStart]){
                tempArray[third++] = a[left++];
            } else {
                tempArray[third++] = a[rightStart++];
            }
        }
        //如果左边还有数据需要把左边数组剩下的拷贝到新数组
        while (left <= mid){
            tempArray[third++] = a[left++];
        }
        //如果右边还有数据需要把右边数组剩下的拷贝到新数组
        while (rightStart <= right){
            tempArray[third++] = a[rightStart++];
        }
        while (temp<=right){
            a[temp] = tempArray[temp++];
        }

    }

    public static void main(String[] args) {
        int a[] = {9,3,2,10,44,83,28,5,1,0,36};
        MergeSort ms = new MergeSort();
        ms.mergeSort(a,0,a.length-1);
        for (int x:a) {
            System.out.println(x);
        }
    }
}
