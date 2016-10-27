package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/8/5.
 */
public class BubbleSort {
    public static void main(String[] args) {//TODO 可以向前移动,也可以向后移动
        int[] nums = {7,6,3,4,5};
//        ascSord(nums);
//        descSord(nums);
//        optimizeSort(nums);
        optimizeSort2(nums);

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
        // 要遍历的次数
        for (int i = 0; i < nums.length - 1; i++) {
            isChanged = false;
            //从前向后依次的比较相邻两个数的大小，遍历一次后，把数组中第i大的数放在第i个位置上
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j]>nums[j+1]) {//比较相邻的元素，如果前面的数大于后面的数，则交换
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


    public static void optimizeSort2(int[] nums){   //todo 此方法不是两两比较,而是都和某个元素比较
        boolean isChanged;
        for (int i = 0; i < nums.length - 1; i++) {
            isChanged = false;
            //若发现较大元素,则往后移
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i]>nums[j]) {//前面的数,大于后面的数
                    int temp = nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
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
