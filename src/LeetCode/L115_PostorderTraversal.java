package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
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
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class L115_PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> outputStack = new Stack<>();
        TreeNode cur = root;
        stack.push(root);
        while (!stack.isEmpty()){
            cur = stack.pop();
            outputStack.push(cur);
            if (cur.left != null){
                stack.push(cur.left);
            }
            if (cur.right != null){
                stack.push(cur.right);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!outputStack.isEmpty()){
            res.add(outputStack.pop().val);
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
