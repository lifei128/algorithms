package com.lifeibigdata.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lifei on 16/5/29.
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        InorderTraversal it = new InorderTraversal();
        List<Integer> list = it.inorderTraversal(root);
        for (int i:list) {
            System.out.println(i);
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        do{
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()){
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        } while (!stack.isEmpty() || node != null);
        return result;
    }
}
