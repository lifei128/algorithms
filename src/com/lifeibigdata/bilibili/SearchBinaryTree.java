package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/17.
 *
 */
public class SearchBinaryTree {
    public void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.data + " ");
        inorderTraversalRec(root.right);
    }

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        public TreeNode(int data){
            this.data = data;
        }
    }
    private TreeNode root;
    //添加节点
    public TreeNode put(int data){
        TreeNode node = null;
        TreeNode parent = null;
        if (root == null){
            node = new TreeNode(data);
            root = node;
            return node;
        }
        //不是迭代,是循环
        node = root;
        while (node != null){
            parent = node;
            if (data > node.data){
                node = node.right;
            } else if (data < node.data){
                node = node.left;
            } else {
                return node;
            }
        }
        //表示将此节点添加到响应的位置
        node = new TreeNode(data);
        if (data < parent.data){
            parent.left = node;
        } else {
            parent.right = node;
        }
        node.parent = parent;
        return node;
    }

    /**
     * 删除节点
     */
    public void deleteNode(int data) throws Exception {
        TreeNode node = searchNode(data);
        if (node == null){
            throw new Exception("balabala");
        } else {
            delete(node);
        }
    }

    private void delete(TreeNode node) throws Exception {
        if (node == null){
            throw new Exception("balabala");
        } else {
            TreeNode parent = node.parent;
            //被删除节点无左右孩子
            if (node.left == null && node.right == null){
                if (parent.left == node){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return;
            }
            //被删除节点有左无右
            if(node.left != null && node.right == null){
                if (parent.left == node){
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
                return;
            }
            //被删除节点有右无左
            if (node.left == null && node.right != null){
                if (parent.left == node){
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
                return;
            }
            //左右孩子都有
            TreeNode next = getNextNode(node);  //后继节点一定是叶子节点
            delete(next);
            node.data = next.data;
        }
    }

    /**
     * 超找后继节点
     */
    private TreeNode getNextNode(TreeNode node) {
        if (node == null){
            return null;
        } else {
            if (node.right != null){//当有右树的时候找右树的最小节点
                //找某结点的最小关键字节点
                return getMinTreeNode(node.right);
            } else {//当没有右树的时候
                TreeNode parent = node.parent;
                while (parent != null && node == parent.right){ //往左上方向移动,一直移动到最左
                    node = parent;
                    parent = parent.parent;//移动到最左后,该节点的父节点则为第一个向右的父节点,即后继节点
                }
                return parent;
            }
        }
    }

    private TreeNode getMinTreeNode(TreeNode node) {
        if (node == null){
            return node;
        } else {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    private TreeNode searchNode(int data) {
        TreeNode node = root;
        if (node == null){
            return null;
        } else {
            while (node != null && data != node.data){
                if (data < node.data){
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }
        return node;
    }

    public static void main(String[] args) throws Exception {
        SearchBinaryTree sbt = new SearchBinaryTree();
        int[] intArray = {50,30,20,44,88,33,87,16,7,77};
        for (int i:intArray){
            sbt.put(i);
        }//中序遍历按照从小到大排列
        sbt.deleteNode(44);
        sbt.inorderTraversalRec(sbt.root);
    }
}
