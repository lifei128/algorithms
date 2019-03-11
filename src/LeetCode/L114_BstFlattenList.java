package LeetCode;

/**
 * 给定一个二叉树，**原地**将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * 用了递归的思路，把左子树作为右子树，并把 原右子树(temp) 拼接在 现右子树 的最右端
 *
 *
 *
 *     1
 *    /  \
 *   2   5
 *    \   \
 *    (3)  6
 *     \
 *     4
 *
 *
 *
 *      1
 *       \
 *      (2,3,4)
 *        \
 *        5
 *         \
 *          6
 */
public class L114_BstFlattenList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null){//注意，一定要判断左子树是否为空
            TreeNode right = root.right;//记录右节点


            root.right = root.left;
            root.left = null;//将左节点置空

            TreeNode cur = root.right;//到左节点的最后一个节点
            while (cur.right != null){//把左子树作为右子树
                cur = cur.right;
            }


            cur.right = right;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
