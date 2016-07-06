package com.lifeibigdata.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 16/7/5.
 */
public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        List<List<Integer>> list = p.permute(new int[]{1,2,3});
        for (List<Integer> subList:list) {
            for (Integer i:subList) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }

//    public static List<List<Integer>> permute(int[] num) {
//        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        List<Integer> list = new ArrayList<Integer>();
//        rec(num, ret, list);
//        return ret;
//    }

//    public static void rec(int[] S, List<List<Integer>> ret, List<Integer> list){
//        // 当数组长度为0时，添加入ret
//        if(S.length == 0){
//            ret.add(new ArrayList<Integer>(list));        // 必须基于现场新建一个ArrayList然后添加入ret！
//            return;
//        }
//        // 遍历数组中的每一个数作为第一个元素
//        for(int i=0; i<S.length; i++){
//            // 构建一个新子数组来递归
//            int[] sub = new int[S.length-1];
//            System.arraycopy(S, 0, sub, 0, i);
//            System.arraycopy(S, i+1, sub, i, S.length-i-1);
//
//            list.add(S[i]);
//            rec(sub, ret, list);
//            list.remove(list.size()-1);     // 恢复现场
//        }
//    }

    /**
     * 解题思路：字符交换加dfs。
       将第0个字符和从第0开始的每个字符进行交换，对于交换后的结果，再从第1个字符开始交换。一直到最后一个字符。
     *
     */
    void dfs(int i, int[] num,List<List<Integer>> result) {
        if(i==num.length) {
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j=0;j<num.length;j++) {
                tmp.add(num[j]);
//                System.out.print(num[j]+",");
            }
//            System.out.println();
            result.add(tmp);
            return;
        }

        for(int j=i;j<num.length;j++) {//在这个地方j会自增 0  1<3(2<-3 3<-3) 2<3(3<-3); 1 2<3(3<-3) 3<-3;2 3<-3
//            System.out.println("-------"+i+":"+num[i]+","+j+":"+num[j]);
            int tmp = num[i];
            num[i]  = num[j];
            num[j]  = tmp;
            dfs(i+1,num,result);
//            System.out.println("*******"+i+":"+num[i]+","+j+":"+num[j]);
            tmp = num[i];
            num[i]  = num[j];
            num[j]  = tmp;
        }
    }

    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(num==null||num.length==0) {    //判断数组为空
            List<Integer> tmp = new ArrayList<Integer>();
            result.add(tmp);
            return result;
        }
        dfs(0,num,result);
        return result;
    }

    /**
     * 自己有问题的做法
     */
//    List<List<Integer>> alllist = new ArrayList<List<Integer>>();

//    public List<List<Integer>> permute(int[] nums) {
//        for (int i = 0;i < nums.length; i++){
//            swap(i,nums);
//        }
//        return alllist;
//    }
//    void swap(int start,int[] nums){
//        for (int i = start + 1; i < nums.length; i++ ){
//            int tmp = nums[i];
//            nums[i] = nums[start];
//            nums[start] = tmp;
//            List<Integer> t = new ArrayList<>();
//            for (int n:nums) {
//                t.add(n);
//            }
//            alllist.add(t);
//            tmp = nums[i];
//            nums[i] = nums[start];
//            nums[start] = tmp;
//        }
//    }
}
