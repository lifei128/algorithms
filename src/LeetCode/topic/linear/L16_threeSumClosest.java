package LeetCode.topic.linear;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class L16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        int res = nums[0] + nums[1] + nums[nums.length - 1];//todo
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1,end = nums.length - 1;
            while (start < end){//todo
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target){
                    end--;
                } else start++;

                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
