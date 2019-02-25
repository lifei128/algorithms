package LeetCode.topic.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class L113_PathSumTree {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        helper(root,sum,new ArrayList<Integer>());
        return res;
    }

    private void helper(TreeNode root, int sum, ArrayList<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum - root.val == 0){
            list.add(root.val);//todo 一定要添加
            res.add(new ArrayList<>(list));//todo 重点，此处一定要copy一个list
            list.remove(list.size() - 1);//todo
            return;
        }
        list.add(root.val);
        helper(root.left,sum - root.val,list);
        helper(root.right,sum - root.val,list);
        list.remove(list.size() - 1);//todo
    }

//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        if (root == null) return new ArrayList<>();
//        helper(root,sum,0,new ArrayList<Integer>());
//        return res;
//    }
//
//    private boolean helper(TreeNode root, int sum, int tempSum, ArrayList<Integer> list) {
//        if (root.left == null && root.right == null){
//            if (tempSum + root.val == sum){
//                list.add(root.val);
//                res.add(list);
//                return true;
//            }
//            return false;
//        } else {
//            tempSum += root.val;
//            list.add(root.val);
//            if (root.left == null){
//                return helper(root.right,sum,tempSum,list);
//            } else if (root.right == null){
//                return helper(root.left,sum,tempSum,list);
//            } else {
//                ArrayList<Integer> mycopy=new ArrayList<Integer>();
//                mycopy=(ArrayList<Integer>) list.clone();
//                helper(root.left,sum,tempSum,list);
//                helper(root.right,sum,tempSum,mycopy);
//            }
//        }
//        return false;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
