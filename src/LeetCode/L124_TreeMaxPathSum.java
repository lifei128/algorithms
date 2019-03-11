package LeetCode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
public class L124_TreeMaxPathSum {

    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /**
         对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
         2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
         **/
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if(r == null) return 0;
        int left = Math.max(0, getMax(r.left)); // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(r.right));
        ret = Math.max(ret, r.val + left + right); // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + r.val;
    }
//    private int res = 0;
//    public int maxPathSum(TreeNode root) {
//        res = root.val;
//        helper(root);
//        return res;
//    }
//
//    private int helper(TreeNode cur) {
//        int sum;
//        if (cur.left != null && cur.right != null){
//            sum = cur.val;
//        } else if (cur.left == null){
//            int right = helper(cur.right);
//            sum = right >0 ? right + cur.val : cur.val;
//        } else if (cur.right == null){
//            int left = helper(cur.left);
//            sum = left > 0 ? left + cur.val : cur.val;
//        } else {
//            int left = helper(cur.left);
//            int right = helper(cur.right);
//            res = Math.max(res,left + right + cur.val);//走当前节点
//
//            int max = Math.max(left,right);//不走当前节点
//            sum = max > 0 ? max + cur.val : cur.val;
//        }
//        res = Math.max(res,sum);
//        return res;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
