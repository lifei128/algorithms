package offer;

/**
 * Created by lifei on 2017/3/28.
 * 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像
 *
 * 我们先前序遍历这棵树的每个结点，如果遍历的结点有子节点，就交换它的两个子节点，当交换完所有的非叶子结点的左右子节点之后，我们就得到了镜像
 *
 */
public class Of27_MirrorOfBinaryTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
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

        mirror(root1);
    }

    private static void mirror(TreeNode root1) {
        if (root1 == null) return;
        if (root1.left == null && root1.right == null){
            return;
        }
        TreeNode tmp = root1.left;
        root1.left = root1.right;
        root1.right = tmp;
        if (root1.left != null){
            mirror(root1.left);//使用递归
        }
        if (root1.right != null){
            mirror(root1.right);
        }
    }
}
