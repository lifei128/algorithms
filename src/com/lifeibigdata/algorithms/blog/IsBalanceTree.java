package com.lifeibigdata.algorithms.blog;

import com.lifeibigdata.algorithms.leetcode.TreeNode;

/**
 * Created by lifei on 16/7/6.
 */
public class IsBalanceTree {
    public static void main(String[] args) {
        IsBalanceTree bt = new IsBalanceTree();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
//        TreeNode n4 = new TreeNode(1);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
//        n3.left = n4;
//        System.out.println(bt.getHeight(root));
        System.out.println(bt.isBalance(root));
    }

    int getHeight(TreeNode root){
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left > right?(left+1):(right +1);
    }

    boolean isBalance(TreeNode root){
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left - right > 1 || left - right < -1){
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}
