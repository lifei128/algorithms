package LeetCode.topic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class L107_levelOrderBottomTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> quene = new LinkedList<>();
        quene.add(root);
        while (!quene.isEmpty()){
            int count = quene.size();
            List<Integer> innerList = new ArrayList<>();
            while (count > 0){
                TreeNode cur = quene.pop();
                innerList.add(cur.val);
                if (cur.left != null){
                    quene.add(cur.left);
                }
                if (cur.right != null){
                    quene.add(cur.right);
                }
                count--;
            }
            res.add(0,innerList);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
