package LeetCode.topic.tree;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class L226_InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)return null;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null)return; // todo 必须在首位
        helper(root.left);
        helper(root.right);

        //下面的代码，可在最前，也可以在最后
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
