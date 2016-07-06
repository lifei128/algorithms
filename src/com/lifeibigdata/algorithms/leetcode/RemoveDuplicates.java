package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/7/1.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int nlength = 0;
        int tmp = 0;
        for(int i = 0; i< nums.length; i++){
            if(i >= 1){
                if(tmp < nums[i]){
                    nlength++;
                    tmp = nums[i];
                }
            } else {
                tmp = nums[i];
                nlength++;
            }
        }
        return nlength;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(new int[]{1,1,1}));
    }
}
