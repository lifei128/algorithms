package com.lifeibigdata.algorithms.leetcode;


/**
 * Created by lifei on 16/5/27.
 *
 * 239
 */
public class maxSlidingWindow {

    public static void main(String[] args) {
        maxSlidingWindow msw = new maxSlidingWindow();
        int []nums = {1,3,1,2,0,5};
        int []rst = msw.maxSlidingWindow(nums,3);
        for (int i: rst) {
            System.out.printf(i+"   ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return nums;
        int len = nums.length - k + 1;
        int []res = new int[len];
        for (int i = 0; i < nums.length - k + 1; i++){
            //求极值
            int max = nums[i];
            for (int j = i; j < k + i - 1; j++) {
                if (max <= nums[j+1]){
                    max = nums[j+1];
                }
            }
            res[i] = max;

        }
        return res;
    }
}
