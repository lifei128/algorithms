package com.lifeibigdata;

import java.util.LinkedList;

/**
 * 打印二叉树从根节点到叶子节点的所有路径
 * Created by lifei on 2018/5/7.
 *
 */
public class Treepath {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;

        public TreeNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        getPath(root);
    }

    public static void getPath(TreeNode root){
        if (root == null)return;
        LinkedList<TreeNode> list = new LinkedList<>();
        getPathCore(root,list);
    }

    private static void getPathCore(TreeNode root, LinkedList<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        if (root.left == null && root.right == null){
            for (TreeNode temp : list){
                System.out.printf(temp.data + " ");
            }
            System.out.println();
            list.removeLast();//TODO 最后一个节点是叶子节点,继续下一条路线,所以要剔除最后一个
            return;
        }
        getPathCore(root.left,list);
        getPathCore(root.right,list);
        list.removeLast();//todo  返回时一定要清除    最后一个节点是最后一个叉的根节点,一定是要排除的,因为这个节点的左右方向都走完了
    }

}
