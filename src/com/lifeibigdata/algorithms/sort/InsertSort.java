package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/8/9.
 *
 *
 *
 * 特点是简单，不需要额外的存储空间，在元素少的时候工作得好
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = { 3, -1, 0, -8, 2, 1 };
        printArray(array);
        insertSort(array);
        printArray(array);
    }
    public static void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {  //j表示已经插入元素的索引值
                if (array[j] > currentValue) {
                    array[j + 1] = array[j];
                    position -= 1;
                } else {
                    break;
                }
            }
            array[position] = currentValue;
        }
    }
    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

}
