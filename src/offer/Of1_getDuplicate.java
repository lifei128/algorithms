package offer;

/**
 * 找出数组中重复的数字
 * 题目
 * 　　todo 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
 * 思路：
 * 从哈希表的思路拓展，重排数组：把扫描的每个数字（如数字m）放到其对应下标（m下标）的位置上，若同一位置有重复，则说明该数字重复。
 * todo （在动手写代码前应该先想好测试用例）
 *
 * 时间On
 * 空间O1
 */
public class Of1_getDuplicate {

    /**
     * 找到数组中一个重复的数字，todo 之所以能这样做，是因为n个数，在0至n-1之间
     * todo 返回-1代表无重复数字或者输入无效
     */
    public int getDuplicate(int[] nums) {
        //todo 需要考虑到边界问题
        if (nums == null || nums.length <= 0) {
            System.out.println("数组输入无效！");
            return -1;
        }
        int size = nums.length;
        for (int a : nums) {//todo 避免在发现不合法的数字前就发现重复数据的情况，比如3,1,-10,1,1,4,3
            if (a < 0 || a >= size) {
                System.out.println("数字大小超出范围！");
                return -1;
            }
        }
//        for (int i = 0; i < size; i++) {
//            int temp;
//            //todo while
//            while (nums[i] != i) {//todo 如果a[i] == i说明恰在其位，不需要判断和比较,需要使用while将其放到正确的位置上
//                temp = nums[i];
//                if (nums[temp] == temp) {//todo 表示temp要到达的位置nums[temp]已经有值了。
//                    return temp;
//                }
//                // 交换arr[arr[i]]和arr[i]      todo     temp = arr[i],等于交换 arr[temp]和temp
//                nums[i] = nums[temp];
//                nums[temp] = temp;
//            }
//        }



        for (int i = 0; i < size; i++) {
            //todo 使用while，将所有遇到的数放到正确的位置，知道不能换为止
            //todo 比如4，3，2，0，1，5，6;先将4和1互换，然后是1和3互换，然后3和0互换，最后停下来
//            4，3，2，0，1，5，6
//            1，3，2，0，4，5，6
//            3，1，2，0，4，5，6
//            0，1，2，3，4，5，6
//            此时0已经是正确位置
            while (i != nums[i] && nums[nums[i]] != nums[i]) {
                int temp = nums[i];  //每交换一次都有正确的数放到正确位置上
                nums[i] = nums[temp];//todo 必须是nums[temp]
                nums[temp] = temp;//todo 必须是nums[temp]
            }
            if(nums[i] != i && nums[nums[i]] == nums[i])return nums[i];
        }


        System.out.println("数组中无重复数字！");
        return -1;
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
     * 数组无重复数字
     */
    public void test2() {
        System.out.print("test2：");
        int[] a = {0, 1, 2, 3};
        int dup = getDuplicate(a);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }

    /**
     * 数组数字越界
     */
    public void test3() {
        System.out.print("test3：");
        int[] a = {1, 2, 3, 4};
        int dup = getDuplicate(a);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }

    /**
     * 数组带重复数字
     */
    public void test4() {
        System.out.print("test4：");
        int[] a = {1, 2, 3, 2, 4};
        int dup = getDuplicate(a);
        if (dup >= 0)
            System.out.println("重复数字为：" + dup);
    }

    public static void main(String[] args) {
        Of1_getDuplicate f = new Of1_getDuplicate();
        f.test1();
        f.test2();
        f.test3();
        f.test4();
    }
}
