package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/7/2.
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int tmp = 0;
        for(int i = 0; i< nums.length; i++){
            tmp = i;
            if(target == nums[i]) {
                return i;
            } else if(target < nums[i]){
                break;
            }
        }
        if(target > nums[tmp]){
            return tmp+1;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3},2));
    }
}
