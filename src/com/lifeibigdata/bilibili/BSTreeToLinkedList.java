package com.lifeibigdata.bilibili;

import java.util.Stack;

/**
 * Created by lifei on 2018/6/26.
 */
public class BSTreeToLinkedList {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }
//1、将左子树构成双链表，并返回该链表的头节点(左子树最左边的节点)
//2、定位到左链表的最后一个节点(左子树最右边的节点)
//3、如果左子树链表不为空，则将当前root追加到左子树链表后
//4、将右子树构造成双向链表，并返回链表头结点(右子树最左边的节点)
//5、如果右子树链表不为空，将右子树链表追加到当前root后
//6，根据左子树链表是否为空返回的整体双向链表的头节点

    //Convert函数把一个二叉搜索树变成一个有序的双向链表，返回双向链表的头结点，参数root为二叉搜索树的根节点
    public TreeNode Convert(TreeNode root){
        if(root==null){//假如根节点为空，返回空
            return null;
        }
        if(root.left==null&&root.right==null){//假如只有一个根节点，则返回根节点
            return root;
        }
        //1、将左子树构造成双链表，并返回该链表头结点left
        TreeNode left=Convert(root.left);

        //2、定位到左子树链表的最后一个节点（左子树最右边的节点）
        TreeNode p=left;//创建一个临时节点P,用来遍历找到左链表的最后一个节点(左子树最右边的节点)，p初始化指向做左子树的根节点，
        while(p!=null&&p.right!=null){
            p=p.right;//最终p为左子树最右边的节点
        }
        //3、如果左子树链表不为空，将当前root追加到左子树链表后
        if(left!=null){//左子树链表不为空
            p.right=root;//左子树链表的最后一个节点p（左子树最右边节点）的右指针指向当前root节点
            root.left=p;//当前root节点的左指针指向左子树链表的最后一个节点p（左子树最右边节点）
        }
        //4、将右子树构造成双链表，并返回该链表的头结点right
        TreeNode right=Convert(root.right);

        //5、如果右子树链表不为空，将右子树链表追加到当前root后
        if(right!=null){//右子树链表不为空
            right.left=root;//右子树链表的头结点right的左指针指向当前root
            root.right=right;//当前root的右指针指向右子树链表的头结点right
        }
        return left!=null?left:root;//根据左子树链表是否为空返回整个双向链表的头指针。
    }


    /**
     *类似中序遍历的非递归实现
     */
    public TreeNode ConvertBSTToBiList(TreeNode root){
        if(root==null){
            return null;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode p=root;//p为临时节点用来遍历树的节点，初始值为根节点root
        TreeNode rootList=null;//用于记录双向链表的头结点
        TreeNode pre=null;//用于保存中序遍历序列的上一个节点，即p的上一个节点
        boolean isFirst=true;//判断是否为左子树链表的第一个节点
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();//此时的p为左子树最左边的节点，
            if(isFirst){//假如是左子树链表的第一个节点
                rootList=p;//将p赋值给root节点
                pre=rootList;
                isFirst=false;
            }else{
                pre.right=p;
                p.left=pre;
                pre=p;
            }
            p=p.right;
        }
        return rootList;
    }
}
