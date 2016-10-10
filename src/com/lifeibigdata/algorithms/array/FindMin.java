package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/9.
 */
public class FindMin {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }

    static int findMin(int[] num){
        int low = 0;
        int high = num.length - 1;
        int mid = 0;
        while (low < high){
            mid = (high + low) /2 ;
            if (num[mid] < num[high]){
                high = mid;
            } else if (num[mid] > num[high]){
                low = mid + 1;
            }
        }
        return num[mid];
    }
}
