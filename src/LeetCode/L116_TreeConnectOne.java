package LeetCode;

import java.util.LinkedList;

/**
 * 给定一个二叉树
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 说明:
 *
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 * 示例:
 *
 * 给定完美二叉树，
 *
 *      1
 *    /  \
 *   2    3
 *  / \  / \
 * 4  5  6  7
 * 调用你的函数后，该完美二叉树变为：
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \  / \
 * 4->5->6->7 -> NULL
 */
public class L116_TreeConnectOne {
 public class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
 }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            TreeLinkNode last = null;
            while (count > 0){
                TreeLinkNode cur = queue.pop();
                if (cur.left != null){
                    queue.add(cur.left);
                    if (last == null){
                        last = cur.left;
                    } else {
                        last.next = cur.left;
                        last = last.next;//传递
                    }
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    if (last == null){
                        last = cur.right;
                    } else {
                        last.next = cur.right;
                        last = last.next;//传递
                    }
                }
                count--;
            }
        }
    }
}
