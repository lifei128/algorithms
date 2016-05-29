package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/27.
 *
 * 1
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        TwoSum ts = new TwoSum();
        int []res = ts.twoSum(nums,6);
        for (int i :res) {
            System.out.printf(i + " ");
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            boolean flag = true;
            for (int j = 0;j < nums.length; j++){
                if (i == j) continue;
                if (nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        return res;
    }
}
