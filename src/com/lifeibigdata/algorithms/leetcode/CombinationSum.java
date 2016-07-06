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
        cs.combinationSum(can,6);
        for (List<Integer> list:ans) {
            for (int i:list) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

//    static List<List<Integer>> result;
//    List<Integer> solu;
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        result = new ArrayList<>();
//        solu = new ArrayList<>();
//        Arrays.sort(candidates);
//        getCombination(candidates, target, 0, 0);
//        return result;
//    }
//    public void getCombination(int[] candidates, int target, int sum, int level){
//        if(sum>target) return;
//        if(sum==target){
//            result.add(new ArrayList<>(solu));
//            return;
//        }
//        for(int i=level;i<candidates.length;i++){
//            sum+=candidates[i];
//            solu.add(candidates[i]);
//            getCombination(candidates, target, sum, i);
//            solu.remove(solu.size()-1);
//            sum-=candidates[i];
//        }
//    }


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
}
