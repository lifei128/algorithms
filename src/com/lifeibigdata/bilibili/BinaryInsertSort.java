package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/19.
 */
public class BinaryInsertSort {
    public static void main(String[] args) {
        int a[] = {9,3,2,10,44,83,28,5,1,0,36};
        BinaryInsertSort bit = new BinaryInsertSort();
        bit.binaryInsertSort(a);

    }

    public void binaryInsertSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];//待插入到前面有序序列的值
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right){
                //排28的时候,如果left=right.仍会进入循环,mid = left,left = mid + 1,
                //排5的时候,如果left=right.仍会进入循环,mid = left,right = mid - 1,
                //所以不会有影响
                mid = (left + right)/2;
                if (temp < a[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1;j>=left;j--){
                //比left右边的值往后移一位,等待temp插入
                a[j+1] = a[j];
            }
            if (left != i){
                a[left] = temp;  //将
            }
        }
        for (int x:a) {
            System.out.println(x);
        }
    }
}
