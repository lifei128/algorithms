package com.lifeibigdata.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lifei on 16/7/4.
 */
public class CombinationSum {

    public static void main(String[] args) {

        int[] can = new int[]{5,3,2,1};
        CombinationSum cs = new CombinationSum();
//        cs.combinationSum(can,6);
//        for (List<Integer> list:ans) {
//            for (int i:list) {
//                System.out.print(i+",");
//            }
//            System.out.println();
//        }

        cs.combinationSum2(can,6);
        for (List<Integer> list:sums) {
            for (int i:list) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> ans = new ArrayList<List<Integer>>();//声明全局变量
    int[] cans = {};

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.cans = candidates;
        Arrays.sort(cans);
        backTracking(new ArrayList(), 0, target);
        return ans;
    }

    public void backTracking(List<Integer> cur, int from, int target) {//初次cur为空
        if (target == 0) {
            List<Integer> list = new ArrayList<Integer>(cur);
            ans.add(list);
        } else {
            for (int i = from; i < cans.length && cans[i] <= target; i++) {//界限条件
                cur.add(cans[i]);
                backTracking(cur, i, target - cans[i]);   //递归调用
                cur.remove(new Integer(cans[i]));
            }
        }
    }

    /**
     *
     *
     *
     *
     1,1,1,1,1,1,
     1,1,1,1,2,
     1,1,1,3,
     1,1,2,2,
     1,2,3,
     1,5,

     2,2,2,

     3,3,
     */


    //时间复杂度O(n!) 空间复杂度O(n)
    public static List<List<Integer>> sums = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2(candidates, 0, new ArrayList<Integer>(), target);
        return sums;
    }

    public void combinationSum2(int[] candidates, int begin, List<Integer> sum, int target) {
        if (target == 0) {
            sums.add(sum);
            return;
        }
        int pre = -1;
        for (int i = begin; i < candidates.length && candidates[i] <= target; i++) {
            //因为已经排序过,所以如果当前数和前一个数相同， 则此次循环直接跳过
            if(pre == candidates[i]) {//TODO
                continue;
            }
            List<Integer> list = new ArrayList<Integer>(sum);
            pre = candidates[i];
            list.add(candidates[i]);
            combinationSum2(candidates, i + 1, list, target - candidates[i]);
        }
    }
}
