package bluebridgecup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//打印二叉树从根节点到叶子节点的所有路径
public class A13_BSTTreePath {

    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)return new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        helper(root,list);
        return res;
    }

    private void helper(TreeNode node,LinkedList<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null){
            String s = "";
            for (Integer n:list) {
                if (s.equals("")){
                    s += n+"";
                } else {
                    s = s + "->"+ n;
                }
            }
            res.add(s);
            list.removeLast();//TODO 最后一个节点是叶子节点,继续下一条路线,所以要剔除最后一个
            return;//TODO 该次结束，返回到上一层
        }
        helper(node.left,list);
        helper(node.right,list);
        list.removeLast();//TODO  返回时一定要清除    最后一个节点是最后一个叉的根节点,一定是要排除的,因为这个节点的左右方向都走完了
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
