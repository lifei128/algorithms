package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/12/22.
 *
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] array = {9,4,5,2,1,3,7,8,6};
        quickSort2(array,0,array.length - 1);
        for (int x:array) {
            System.out.println(x);
        }
    }

    static void quickSort(int[] array,int left,int right){//left,right都是闭区间
        if (left < right){
            int k = partition(array,left,right);
            quickSort(array,left,k - 1);
            quickSort(array,k + 1,right);
        }

    }

    //将一个数组以某一个基准点划分为两个子数组
    static int partition(int[] array, int left, int right) {
        int key = array[right];//以最后一个元素为基准点
        int i = left - 1;
        int temp;
        //开始以基准点为标准分割序列
        for (int j = left;j < right;j++){
            if (array[j] < key){
                i++;
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        //将基准点放置到合适的位置上
        temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }

    //第二种分割的方法
    static int partition2(int[] array,int low,int high){
        int key = array[low];
        while (low < high){
            //从后面找到一个合适的值和前面的交换
            while (low < high && array[high] >= key){//todo =不可以省略 ?
                high--;
            }
            swap(array,low,high);
            //从前面找到一个合适的值和前面的交换
            while (low < high && array[low] <= key){//todo =不可以省略 ?
                low++;
            }
            swap(array,low,high);
        }
        return low;
    }

    static void swap(int[] array, int low, int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }

    static void quickSort2(int[] array,int left,int right){
        int i,j,key;
        if (left < right){
            i = left;
            j = right;
            key = array[i];
            do {
                while (array[i] > key && i < j){
                    j--;//从右向左找第一个小于基准值的位置j
                }
                if (i < j){//找到了位置j
                    array[i] = array[j];
                    i++;
                }//从第J个元素置于左端并重置i
                while (array[i] < key && i < j){
                    i++;//从左向右找第一个大于基准值的位置
                }
                if (i < j){
                    array[j] = array[i];
                    j--;
                }//将第I个元素置于右端并重置j
            } while (i != j);
            array[i] = key;//分割完成
            quickSort2(array,left,i - 1);
            quickSort2(array,i + 1,right);
        }
    }

}
