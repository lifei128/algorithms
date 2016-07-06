package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/6/29.
 */
public class IsMirrorTree {

    public static void main(String[] args) {
        IsMirrorTree im = new IsMirrorTree();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        System.out.println(im.isSymmetric(root));

    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }

    static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (right == null) {
            return false;
        } else if (left == null) {
            return false;
        } else {
            if (left.val != right.val) return false;
            return isMirror(left.right, right.left) && isMirror(left.left, right.right);
        }
    }

}
