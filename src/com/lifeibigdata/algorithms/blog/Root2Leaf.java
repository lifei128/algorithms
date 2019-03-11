package com.lifeibigdata.algorithms.blog;

import com.lifeibigdata.algorithms.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 16/8/3.
 *
 */
public class Root2Leaf {

    static List<String> paths=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode p1=new TreeNode(1);
        TreeNode p2=new TreeNode(2);
        TreeNode p3=new TreeNode(3);
        TreeNode p4=new TreeNode(4);
        p1.left=p2;
        p1.right=p3;
        p2.left=p4;

        binaryTreePaths(p1);
    }
    public static List<String> binaryTreePaths(TreeNode root) {

        if(root==null)
            return paths;
        String curPath="";
        serachTree(root, curPath);
        return paths;
    }
    public static void serachTree(TreeNode root,String currentPath) {

        currentPath+=root.val;
        if(root.left==null&&root.right==null)
        {
            paths.add(currentPath);
            System.out.println(currentPath);
            return;
        }
        currentPath+="->";
        if(root.left!=null)
            serachTree(root.left, currentPath);
        if(root.right!=null)
            serachTree(root.right, currentPath);
    }

}
