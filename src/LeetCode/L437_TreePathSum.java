package LeetCode;

import java.util.Stack;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class L437_TreePathSum {
    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        if(root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            count += helper(node, sum);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return count;
    }

    public int helper(TreeNode root, int sum) {
        int count = 0;
        if(root == null)
            return 0;
        if(sum == root.val){
            count++;
        }
        count += helper(root.left, sum-root.val);
        count += helper(root.right, sum-root.val);
        return count;
    }


//    public int pathSum(TreeNode root, int sum) {
//        if(root == null) return 0;
//        int res = helper(root,sum);
//        res += pathSum(root.left,sum);
//        res += pathSum(root.right,sum);
//        return res;
//    }
//    public int helper(TreeNode node,int num){
//        if(node == null){
//            return 0;
//        }
//        int res = 0;
//        if(node.val == num){
//            res++;
//        }
//        res += helper(node.left,num - node.val);
//        res += helper(node.right,num - node.val);
//        return res;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
