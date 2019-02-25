package LeetCode.topic.recursion;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 *
 * 注意:
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 *
 *
 * https://www.cnblogs.com/jasminemzy/p/7938463.html
 *
 * 算法：DFS。简单一点的类似问题是subset问题，问你一个数组里能不能找到一些数加起来是target。那这个问题其实就相当于target = sum / k，
 * 然后你找到一个合格的subset再找一下一个，直到你正好凑满k个合格的subset。所以这道题里其实就是难一点点双层出口，别的思路差不多。
 *
 * 递归函数头：private boolean canPartition(int[] nums, boolean[] isUsed, int k, int target, int idx, int crtSum) 。
 * 函数意义是在给定的剩余可用的nums下，你最终能不能再凑出k个加起来是target的subset？
 * 第一个出口是：当你当前凑到一个合格subset后，你要出去递归下一个只需要再凑k-1个的问题。
 * 第二个出口是：当你k减到0也就是凑满的时候，你就是真的可以拍胸脯说这个问题是有解的啦，返回。
 *
 * 细节：
 * 1.函数头里的idx是让你不回头加数，因为这个问题不是排列问题，你选的数字135凑到9和选的数字153凑到9是一样的，不要重复搜索了。
 * 2.递归的时候还有一层出口的时候要把结果返回去，子函数结尾遍历后都不行要把false返回去。
 *
 *
 */
public class L698_CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;
        boolean[] isUsed = new boolean[nums.length];
        return canPartition(nums, isUsed, k, target, 0, 0);
    }

    private boolean canPartition(int[] nums, boolean[] isUsed, int k, int target, int idx, int crtSum) {

        if (k == 0) {
            return true;
        }

        if (crtSum == target) {
            return canPartition(nums, isUsed, k - 1, target, 0, 0);
        }

        for (int i = idx; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            if (canPartition(nums, isUsed, k, target, i + 1, crtSum + nums[i])) {
                return true;
            }
            isUsed[i] = false;
        }
        return false;
    }
}
