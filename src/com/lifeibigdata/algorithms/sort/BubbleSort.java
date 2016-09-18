package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/8/5.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {7,6,3,4,5};
//        ascSord(nums);
//        descSord(nums);
        optimizeSort(nums);

    }

    static void ascSord(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
            for (int x:nums) {
                System.out.print(x+"\t");
            }
            System.out.println();
        }
    }
    static void descSord(int[] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j+1]){
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
            for (int x:nums) {
                System.out.print(x+"\t");
            }
            System.out.println();
        }
    }

    public static void optimizeSort(int[] nums){   //7,6,3,4,5
        boolean isChanged;
        for (int i = 0; i < nums.length - 1; i++) {
            isChanged = false;
            //若发现较大元素,则往后移
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j]>nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1]=nums[j];
                    nums[j]=temp;
                    isChanged = true;
                }
            }
            //若没有移动,说明序列已经有序,跳出循环
            if (!isChanged) {
                break;
            }
            for (int x:nums) {
                System.out.print(x+"\t");
            }
            System.out.println();
        }
    }
}
