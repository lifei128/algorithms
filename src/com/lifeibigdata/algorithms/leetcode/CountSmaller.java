package com.lifeibigdata.algorithms.leetcode;

import java.util.*;

/**
 * Created by lifei on 16/10/18.
 */
public class CountSmaller {
    public static void main(String[] args) {
        List<Integer> list = countSmaller2(new int[]{3,6,5,4});
        for (int x:list) {
            System.out.println(x);
        }
    }
    static List<Integer> countSmaller(int[] nums) {
        int[] pos = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pos[i] = i;
        }
        int[] answer = new int[nums.length];
        List<Integer> rst = new ArrayList<>();
        merge(nums,0,nums.length - 1,pos,answer);
        for (int x:answer) {
            rst.add(x);
        }
        return rst;
    }

    static void merge(int[] nums, int from, int to, int[] pos, int[] answer) {
        if (from >= to)
            return;
        int mid = (from + to) >> 1;
        merge(nums,from,mid,pos,answer);
        merge(nums,mid + 1,to,pos,answer);
        int[] temp = new int[to - from + 1];
        for (int i = 0,x = from,y = mid + 1; i < temp.length; ++i) {
            if (x > mid){
                temp[i] = pos[y++];
            } else if (y > to){
                temp[i] = pos[x++];
            } else if (nums[pos[x]] > nums[pos[y]]){
                answer[pos[x]] += to - y + 1;//TODO
                temp[i] = pos[x++];
            } else {
                temp[i] = pos[y++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            pos[i + from] = temp[i];
        }
    }

    static List<Integer> countSmaller2(int[] nums) {
        int n = nums.length;
        List<Integer> rst = new ArrayList<>();
        int[] answer = new int[n];
        if (n < 2){
            return rst;
        }
        Arrays.sort(nums);
        Map<Integer,Integer> map = new HashMap<>();
        int m = 0;
        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],m++);
            }
        }
        int bucketSize = (int) Math.sqrt(m);
        int[] bucket = new int[(n + bucketSize - 1)/bucketSize];
        int[] have = new int[m];
        for (int i = n - 1; i >= 0 ; --i) {
            int x = map.get(nums[i]);
            int id = x / bucketSize;
            for (int j = id - 1; j >= 0 ; --j) {
                answer[i] += bucket[j];
            }
            for (int j = id * bucketSize; j < x; ++j) {
                answer[i] += have[j];
            }
        }

        for (int x:answer) {
            rst.add(x);
        }
        return rst;
    }
}
