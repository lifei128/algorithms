package LeetCode.topic.tree;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * Example 1:
 *
 * 输入: [3,2,1,6,0,5]
 * 输入: 返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * 注意:
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 */
public class L654_ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums,0,nums.length -1);
    }
    public TreeNode  buildTree(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        int maxIndex = maxIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums,start,maxIndex - 1);
        root.right = buildTree(nums,maxIndex + 1,end);
        return root;
    }
    public int maxIndex(int[] arr,int start,int end){
        int maxIndex = start;
        for(int i = start ;i <= end; i++){
            if (arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
