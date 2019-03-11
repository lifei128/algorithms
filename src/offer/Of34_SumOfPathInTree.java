package offer;

import java.util.Stack;

/**
 * Created by lifei on 2017/3/29.
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶结点所经过的所有的结点形成一条路径。
 *
 * 当用前序遍历的方式访问到某一节点时，我们把该结点添加到路径上，并累加该结点的值。
 * 如果该结点为叶结点并且路径中结点值的和刚好为输入的整数，则当前的路径符合要求，我们把它打印出来。
 * 如果当前的结点不是叶结点，则继续访问它的子节点。当前结点访问结束后，递归函数将自动回到它的父节点。
 * 因此我们在函数退出之前要在路径上删除当前结点并减去当前结点的值，以确保返回父节点时路径刚好是从根节点到父节点的路径。
 *
 * 我们不难看出保存路径的数据结构实际上是一个栈，因此路径要与递归调用状态一致，而递归调用的本质上是一个压栈和出栈的过程。
 */
public class Of34_SumOfPathInTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n12 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);

        root.left = n5;
        root.right = n12;
        n5.left = n4;
        n5.right = n7;

        findPath(root,22);
    }

    private static void findPath(TreeNode root, int k) {
        if (root == null) return;
        Stack<Integer> stack = new Stack<>();
        findPath(root,k,stack);
    }

    private static void findPath(TreeNode root, int k, Stack<Integer> path) {
        if (root == null) return;
        if (root.left == null && root.right == null){//叶子节点
            if (root.data == k){//todo  k为每次减后剩余的值,如果和叶子节点的值一样,则满足条件
                System.out.println("路径开始:");
                for (int i : path)
                    System.out.printf(i+",");
                System.out.println(root.data);
            }
        } else {//非叶子节点
            path.push(root.data);
            findPath(root.left,k - root.data,path);
            findPath(root.right,k - root.data,path);
            path.pop();
        }
    }
}
