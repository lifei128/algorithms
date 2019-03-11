package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class L1_twoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] rst = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];//todo diff是差值，判断该差值是否在map中出现
            if (map.containsKey(diff)){
                rst[0] = map.get(diff);
                rst[1] = i;
                break;
            }
            map.put(nums[i],i);
        }
        return rst;
    }
}
