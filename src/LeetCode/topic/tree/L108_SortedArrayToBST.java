package LeetCode.topic.tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *  左右等分建立左右子树，中间节点作为子树根节点，递归该过程
 */
public class L108_SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)return null;
        return helper(nums,0,nums.length - 1);

    }

    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high) return null;
        if (low == high) return new TreeNode(nums[low]);//low是序号，nums[low]才是其值
        int mid = (low + high)>>1;
        TreeNode cur = new TreeNode(nums[mid]);//mid是序号，nums[low]才是其值
        cur.left = helper(nums,low,mid-1);
        cur.right = helper(nums,mid+1,high);
        return cur;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
