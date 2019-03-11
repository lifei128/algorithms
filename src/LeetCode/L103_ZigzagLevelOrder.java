package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class L103_ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        LinkedList<TreeNode> quene = new LinkedList<>();
        quene.add(root);
        int depth = 0;
        while (!quene.isEmpty()){
            int count = quene.size();
            List<Integer> innerList = new ArrayList<>();
            while (count > 0){
                TreeNode cur = quene.poll();
                if (depth % 2 == 1){//todo 判断奇偶层，从0开始计数
                    innerList.add(0,cur.val);//todo 如果是奇数层，就倒排
                } else {
                    innerList.add(cur.val);
                }
                if (cur.left != null){
                    quene.add(cur.left);
                }
                if (cur.right != null){
                    quene.add(cur.right);//.add 和 .push方法不同
                }
                count--;
            }
            depth++;
            res.add(innerList);
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
