package com.lifeibigdata.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lifei on 16/5/29.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return res;
        }
        Arrays.sort(nums);//对数组进行排序
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 3; i++) {//// 第一个加数的占位符
            if (i == 0 || nums[i] != nums[i -1]){// 第一个加数不能重复,即同一个位置不能重复取一个值
                for (int j = i + 1; j < nums.length - 2; j++) {// 第二个加数的占位符
                    if (j == i + 1 || nums[j] != nums[j -1]){//第二个加数不重复,即同一个位置不能重复取一个值;但是第一个数和第二个数是可以相同的
                        int begin = j+1,end = nums.length - 1;
                        int newTarget = target - nums[i] -nums[j];//求剩余两个数的和
                        while (begin < end){
                            if (nums[begin] + nums[end] == newTarget){
                                res.add(Arrays.asList(nums[i],nums[j],nums[begin],nums[end]));
                                while (begin < end && nums[begin] == nums[begin+1])begin++;//去除重复值
                                while (begin < end && nums[end] == nums[end-1])end--;//去除重复值
                                begin++;
                                end--;
                            } else if (nums[begin] + nums[end] > newTarget){
                                end--;
                            } else {
                                begin++;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fs = new FourSum();
        List<List<Integer>> lists = fs.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> list:lists){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
}
