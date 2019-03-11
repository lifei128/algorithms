package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 */
public class L94_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        while (cur != null || !stack.isEmpty()){//变形
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
//            if (stack.isEmpty()){
//                break;
//            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) return new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        List<Integer> list = new ArrayList<>();
//        while (true){
//            while (cur != null){
//                stack.push(cur);
//                cur = cur.left;
//            }
//            if (stack.isEmpty()){
//                break;
//            }
//            cur = stack.pop();
//            list.add(cur.val);
//            cur = cur.right;
//        }
//        return list;
//    }
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }
}


