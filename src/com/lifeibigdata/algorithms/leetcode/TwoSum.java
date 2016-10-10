package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/27.
 *
 * 1
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0,3,7,9,11,14,16,17};
        TwoSum ts = new TwoSum();
//        int []res = ts.twoSum(nums,20);
//        for (int i :res) {
//            System.out.printf(i + " ");
//        }
        twoSum2(nums,20);
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

    static void twoSum2(int[] a,int sum){
        int i = 0;
        int j = a.length - 1;
        while (i < j){
            if (a[i] + a[j] < sum){
                i++;
            } else if (a[i] + a[j] > sum){
                j--;
            } else {
                System.out.println(a[i]+"---"+a[j]);
                i++;
                j--;
            }
        }
    }
}
