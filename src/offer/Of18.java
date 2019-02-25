package offer;

/**
 * Created by lifei on 2017/3/27.
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 *
 */
public class Of18 {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    static boolean hasSubTree(TreeNode root1,TreeNode root2){
        if (root2 == null) return true;
        if (root1 == null) return false;
        boolean result = false;
        if (root1.data == root2.data){
            result = doesTree1HaveTree2(root1,root2);
        }
        if (!result)
            result = hasSubTree(root1.left,root2);//递归
        if (!result)
            result = hasSubTree(root1.right,root2);
        return result;
    }

    private static boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.data != root2.data) return false;
        return doesTree1HaveTree2(root1.left,root2.left) && doesTree1HaveTree2(root1.right,root2.right);//递归
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);

        root1.left = t1;
        root1.right = t2;
        t1.left = t3;
        t1.right = t4;
        t4.left = t5;
        t4.right = t6;

        TreeNode root2 = new TreeNode(8);
        TreeNode t7 = new TreeNode(9);
        TreeNode t8 = new TreeNode(2);
        root2.left = t7;
        root2.right = t8;
        System.out.println(hasSubTree(t1,t2));;
    }
}
