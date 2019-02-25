package LeetCode.topic.tree;

public class L700_SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode left = searchBST(root.left,val);
        TreeNode right = searchBST(root.right,val);
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        return null;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
