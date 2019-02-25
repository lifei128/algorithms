package LeetCode.topic.tree;

public class L965_IsUnivalTree {

    public boolean isUnivalTree(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root,root.val);
    }
    public boolean helper(TreeNode node,int val){
        if(node == null)return true;
        if(node.val != val)return false;
        if(node.left != null && node.left.val != val) return false;
        if(node.right != null && node.right.val != val) return false;
        return helper(node.left,val) && helper(node.right,val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
