package LeetCode.topic.tree;

import java.util.Stack;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 *
 * 请在不改变其结构的情况下，恢复这棵树。
 *
 * 示例 1:
 *
 * 输入: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * 输出: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 *
 * 输入: [3,1,4,null,null,2]
 *
 *   3
 *  / \
 * 1   4
 *    /
 *   2
 *
 * 输出: [2,1,4,null,null,3]
 *
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * 进阶:
 *
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 *
 * 个人思路：
 * 中序遍历，是递增的，找到不一致的，然后进行交换
 */
public class L99_RecoverTree {


    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        helper(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val >= root.val){
            if (first == null) first = prev;
            second = root;//
        }
        prev =root;//如果正常继续轮转
        helper(root.right);
    }


//    public void recoverTree(TreeNode root) {
//        if (root == null) return;
//        TreeNode first = null;
//        TreeNode second = null;
//        TreeNode prev = null;
//
//        TreeNode cur = root;
//        Stack<TreeNode> stack = new Stack<>();
//        while (!stack.isEmpty() || cur != null){
//            if (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                cur = stack.pop();
//                if (prev != null && prev.val >= cur.val){
//                    if (first == null) first = prev;
//                        second = cur;//
//                }
//                prev = cur;
//                cur = cur.right;
//            }
//        }
//        int tmp = first.val;
//        first.val = second.val;
//        second.val = tmp;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
