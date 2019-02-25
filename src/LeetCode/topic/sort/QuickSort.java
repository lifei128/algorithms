package LeetCode.topic.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]
                { 1, 12, 2, 13, 3, 14, 4, 15, 5, 16, 17, 17, 177, 18, 8, 8, 19 };
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr,low,high);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;//很重要
        int pos = partition(arr,low,high);
        quickSort(arr,low,pos - 1);
        quickSort(arr,pos + 1,high);
    }

    private static int partition(int[] arr, int low, int high) {
        int finalMiddleValue = arr[low];//将头元素作为基数
        while (low < high){
            while (arr[high] >= finalMiddleValue){
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= finalMiddleValue){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = finalMiddleValue;
        return low;
    }
}
