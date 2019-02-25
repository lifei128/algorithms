package LeetCode.topic.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class L102_LevelorderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();//

        if (root == null) return new ArrayList<>();
        LinkedList<TreeNode> quene = new LinkedList<>();
        quene.add(root);

        while (!quene.isEmpty()){
            int count = quene.size();//
            List<Integer> innerList = new ArrayList<>();//

            while (count > 0){//
                TreeNode cur = quene.pop();
                innerList.add(cur.val);//
                System.out.println(cur.val);
                if (cur.left != null){
                    quene.add(cur.left);
                }
                if (cur.right != null){
                    quene.add(cur.right);
                }
                count--;
            }
            res.add(innerList);
        }
        return res;
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        LinkedList<TreeNode> quene = new LinkedList<>();
//        quene.add(root);
//
//        while (!quene.isEmpty()){
//            TreeNode cur = quene.pop();
//            System.out.println(cur.val);
//            if (cur.left != null){
//                quene.add(cur.left);
//            }
//            if (cur.right != null){
//                quene.add(cur.right);
//            }
//        }
//        return null;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
