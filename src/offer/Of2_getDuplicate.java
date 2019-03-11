package offer;

/**
 *
 * todo 长度为n+1,上一题目是长度为n，范围在0~n-1
 * 题目
 * 　　todo 在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至少有一个数字是重复的。
 *
 * 请找出数组中任意一个重复的数字，todo 但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或者3。
 * 思路
 * 　　数组长度为n+1，而数字只从1到n，说明必定有重复数字。可以由二分查找法拓展：
 * 把1~n的数字从中间数字m分成两部分，若前一半1~m的数字数目超过m个，说明重复数字在前一半区间，
 * 否则，在后半区间m+1~n。每次在区间中都一分为二，知道找到重复数字。
 * todo m
 * <p>
 * 更简单的思路：把该数组看作一个链表，下标代表当前结点，值代表next指针，
 * 具体参考Find the Duplicate Number，时间复杂度仅为O(n) L287,数组中只有一个重复的数字，但它可能不止重复出现一次
 *
 *
 * 时间On
 * 空间O1
 */
public class Of2_getDuplicate {

    /**
     * 找到数组中一个重复的数字
     * 返回-1代表无重复数字或者输入无效
     */
    public int getDuplicate(int[] arr) {
        if (arr == null || arr.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        for (int a : arr) {
            if (a < 1 || a > arr.length - 1) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }
        int low = 1;
        int high = arr.length - 1; //todo high即为题目的n
        int mid, count;
//        while (low <= high) {//todo 迭代计算   <=
//            mid = ((high - low) >> 2) + low;//todo mid是中间数 = (high + low)/2
//            count = countRange(arr, low, mid);
//            if (low == high) {
//                if (count > 1)
//                    return low;
//                else
//                    break; //todo 如果数组中必有重复，应该不会出现这种情况
//            }
//            if (count > mid - low + 1) {//todo 超过前一半
//                high = mid;
//            } else {
//                low = mid + 1;
//            }
//        }


        while (low < high) {//todo 迭代计算 此时只取<,等于的情况放在外面
            mid = ((high - low) >> 2) + low;//todo mid是中间数 = (high + low)/2
            count = countRange(arr, low, mid);
            if (count > mid - low + 1) {//todo 超过前一半
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;//todo 认为必定有重复
    }

    /**
     * 返回在[low,high]范围中数字的个数
     */
    public int countRange(int[] arr, int low, int high) {
        if (arr == null)
            return 0;

        int count = 0;
        for (int a : arr) {
            if (a >= low && a <= high)
                count++;
        }
        return count;
    }

    /**
     * todo 解法二  L287
     * https://www.cnblogs.com/yongh/p/9981582.html
     *
     * @param nums
     * @return
     */

    public int findDuplicate(int[] nums) {
        if (nums == null)
            return -1; //invalid
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);
        int entry = 0;
        while (entry != slow) {
            entry = nums[entry];
            slow = nums[slow];
        }
        return entry;
    }


    // ==================================测试代码==================================

    /**
     * 数组为null
     */
    public void test1() {
        System.out.print("test1：");
        int[] a = null;
        int dup = getDuplicate(a);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }

    /**
     * 数组数字越界
     */
    public void test2() {
        System.out.print("test2：");
        int[] a = {1, 2, 3, 4};
        int dup = getDuplicate(a);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }

    /**
     * 数组带重复数字
     */
    public void test3() {
        System.out.print("test3：");
        int[] a = {1, 2, 3, 2, 4};
        int dup = getDuplicate(a);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }

    public static void main(String[] args) {
        Of2_getDuplicate f2 = new Of2_getDuplicate();
        f2.test1();
        f2.test2();
        f2.test3();
    }

}
