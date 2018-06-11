package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/5/14.
 */
public class SplitTwo {
    public static void main(String[] args){
        int[] int_arr = {1,3,5,7,8,9,10};
        find(9,int_arr,0,int_arr.length -1);
    }

    private static void find(int target,int[] int_arr, int start, int end) {
        int mid = (start + end)/2;
        if (start > end){////说明两个下标往中间走 相互错过了,就表示没有找到这个target
            System.out.println("没有这个数");
            return;
        }
        if (int_arr[mid] == target){
            System.out.println("找到下标为" + mid);
            return;
        } else if (int_arr[mid] < target){
            find(target,int_arr,mid + 1,end);
        } else {
            find(target,int_arr,start,mid - 1);
        }
    }
}
