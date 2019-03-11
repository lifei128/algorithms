package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class L257_BinaryTreePaths {

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        helper(root,list);
        return res;
    }

    private void helper(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            list.add(root.val);
            String s = "";
            for (Integer node:list) {
                if (s.equals("")){
                    s += node+"";
                } else {
                    s = s + "->"+ node;
                }
            }
            res.add(s);
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        helper(root.right,list);
        helper(root.left,list);
        list.remove(list.size() - 1);
    }


//    List<String> res = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        if (root == null)return new ArrayList<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(root.val);
//        helper(root,list);
//        return res;
//    }
//
//    private void helper(TreeNode root, ArrayList<Integer> list) {
//        if (root.left == null && root.right == null){
//            String s = "";
//            for (Integer node:list) {
//                if (s.equals("")){
//                    s += node+"";
//                } else {
//                    s = s + "->"+ node;
//                }
//            }
//            res.add(s);
//        } else if (root.left == null){
//            list.add(root.right.val);
//            helper(root.right,list);
//        } else if (root.right == null){
//            list.add(root.left.val);
//            helper(root.left,list);
//        } else {
//            ArrayList<Integer> mycopy=new ArrayList<Integer>();
//            mycopy=(ArrayList<Integer>) list.clone();
//            list.add(root.right.val);
//            helper(root.right,list);
//            mycopy.add(root.left.val);
//            helper(root.left,mycopy);
//        }
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
