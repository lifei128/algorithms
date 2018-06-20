package com.lifeibigdata.bilibili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lifei on 2018/6/17.
 */
public class BinaryTree {
    public class TreeNode{
        String data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(String data){
            this.data = data;
        }
    }
    public void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversalRec(root.left);            //左子树
        preorderTraversalRec(root.right);           //右子树
    }

    /**
     * 通过前序遍历的数据序列反向生成二叉树
     *
     */
    public void createBinaryTreePre(ArrayList<String> data){
        createBinaryTree(data.size(),data);
    }

    private TreeNode root = null;
    private TreeNode createBinaryTree(int size, ArrayList<String> data) {
        if (data.size() == 0) return null;
        String d = data.get(0);
        TreeNode node;
        int index = size - data.size();   //原长度 - 剩余长度 = 当前节点的坐标
        if (d.equals("#")){
            node = null;
            data.remove(0);
            return node;
        }
        node = new TreeNode(d);
        if (index == 0){
            root = node; // 创建根节点
        }
        data.remove(0);
        node.left = createBinaryTree(size,data);
        node.right = createBinaryTree(size,data);
        return node;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        String[] dataArray = {"A","B","D","#","#","E","#","#","C","#","F","#","#"};
        bt.createBinaryTreePre(new ArrayList(Arrays.asList(dataArray)));
        bt.preorderTraversalRec(bt.root);
    }
}
