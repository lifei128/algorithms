package LeetCode.topic.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *
 * 计算从根到叶子节点生成的所有数字之和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * 示例 2:
 *
 * 输入: [4,9,0,5,1]
 *     4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 输出: 1026
 * 解释:
 * 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491.
 * 从根到叶子节点路径 4->0 代表数字 40.
 * 因此，数字总和 = 495 + 491 + 40 = 1026.
 */
public class L129_TreeSumNumbers {

    private int total;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        ArrayList<Integer> sum = new ArrayList<>();
        helper(root,sum);
        return total;
    }

    private void helper(TreeNode cur,ArrayList<Integer> sum) {
        if (cur == null) return;
        if (cur.left == null && cur.right == null){
            sum.add(0,cur.val);//todo
            int s = 0;
            for (int i = sum.size() -1 ;i>=0;i--){
                s += (int) (Math.pow(10,Double.parseDouble(i+""))*sum.get(i).intValue());
            }
            total += s;
            sum.remove(0);//todo
            return;
        }
        sum.add(0,cur.val);
        helper(cur.left,sum);
        helper(cur.right,sum);
        sum.remove(0);//todo
    }


//    private int total;
//    public int sumNumbers(TreeNode root) {
//        if (root == null) return 0;
//        ArrayList<Integer> sum = new ArrayList<>();
//        sum.add(root.val);
//        helper(root,sum);
//        return total;
//    }
//
//    private void helper(TreeNode cur,ArrayList<Integer> sum) {
//        if (cur.left == null && cur.right == null){
//            int s = 0;
//            for (int i = sum.size() -1 ;i>=0;i--){
//                s += (int) (Math.pow(10,Double.parseDouble(i+""))*sum.get(i).intValue());
//            }
//            total += s;
//        } else if (cur.left == null){
//            sum.add(0,cur.right.val);
//            helper(cur.right,sum);
//        } else if (cur.right == null){
//            sum.add(0,cur.left.val);
//            helper(cur.left,sum);
//        } else {
//            ArrayList<Integer> mycopy=new ArrayList<Integer>();
//            mycopy=(ArrayList<Integer>) sum.clone();
//            sum.add(0,cur.right.val);
//            helper(cur.right,sum);
//            mycopy.add(0,cur.left.val);
//            helper(cur.left,mycopy);
//        }
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
