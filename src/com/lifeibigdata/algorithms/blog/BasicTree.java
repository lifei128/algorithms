package com.lifeibigdata.algorithms.blog;

import com.lifeibigdata.algorithms.leetcode.TreeNode;

/**
 * Created by lifei on 16/8/2.
 */
public class BasicTree {

    TreeNode root = null;
    public static void main(String[] args) {

        int[] xarrs = {15,5,3,12,16,20,23,13,18,10,6,7};
        BasicTree bt = new BasicTree();
        for (int x:xarrs) {
            bt.insertNode(x);
        }
//        bt.delete(13);
//        bt.delete(16);
        bt.delete(5);
        bt.preOrder(bt.root);
        System.out.println();
//        System.out.println(bt.isExist(11));
    }

    void preOrder(TreeNode root){
        if (root != null){
            System.out.print(root.val+"     ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    boolean isExist(int x){
        while (root != null){
            if (root.val == x)
                return true;
            if (root.val < x){
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return false;
    }


    void insertNode(int x){
       root = _insertNode1(root,x);
//       _insertNode2(x);
    }


//    http://blog.sina.com.cn/s/blog_6e51df7f01013oct.html

    TreeNode _insertNode1(TreeNode proot, int x) {
        if (proot == null){
            proot = new TreeNode(x);   //此时会改变proot和参数proot指向的不再是同一个内存地址
        } else {
            if (proot.val < x){
                proot.right = _insertNode1(proot.right,x);
            } else {
                proot.left = _insertNode1(proot.left,x);
            }
        }
        return proot;
    }

    private void _insertNode2(int x) {
        if (root == null){
            root = new TreeNode(x);
        } else {
            TreeNode pNode = root;
            TreeNode pCur = root;
            while (pNode != null){
                pCur = pNode;
                if (x < pNode.val){
                    pNode = pNode.left;
                } else if(x > pNode.val){
                    pNode = pNode.right;
                } else {
                    return;
                }
            }
            if (x < pCur.val){
                pCur.left = new TreeNode(x);
            } else {
                pCur.right = new TreeNode(x);
            }
        }
    }
    boolean delete(int x){
        if (root == null) return false;
        TreeNode pnode = root;
        TreeNode pParent = null;
        while (pnode != null){
            if (x > pnode.val){
                pParent = pnode;
                pnode = pnode.right;
            } else if(x < pnode.val){
                pParent = pnode;
                pnode = pnode.left;
            } else {   //找到带删除节点
                break;
            }
        }
        if (pnode == null)return false; //没有找到
        if (pnode.left == null && pnode.right == null){
            deleteChiledless(pParent,pnode);
        } else if(pnode.left == null || pnode.right == null){
            deleteSingleSon(pParent,pnode);
        } else {
            TreeNode pCur = pnode;   //暂存待删除节点
            pParent = pnode;
            pnode = pnode.left;
            while (pnode.right != null){
                pParent = pnode;
                pnode = pnode.right;
            }
            pCur.val = pnode.val;   //删除数据
            if (pnode.left == null){  //左孩子也为空
                deleteChiledless(pParent,pnode);
            } else {
                deleteSingleSon(pParent,pnode);
            }
        }
        return true;
    }
    void deleteChiledless(TreeNode parent,TreeNode pnode){
        if (pnode == root){
            root = null;
        } else if(parent.left == pnode){
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    void deleteSingleSon(TreeNode parent,TreeNode pnode){
        TreeNode pGrandSon = pnode.left != null ? pnode.left : pnode.right;
        if (pnode == root){
            root = pGrandSon;
        } else if(parent.left == pnode){
            parent.left = pGrandSon;
        } else {
            parent.right = pGrandSon;
        }
    }


}
