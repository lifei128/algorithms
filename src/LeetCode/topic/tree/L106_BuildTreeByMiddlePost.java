package LeetCode.topic.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 *    后序遍历最后一个是根
 */
public class L106_BuildTreeByMiddlePost {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        if (inorder.length != 0 && postorder.length != 0){
            List<Integer> inorderList =  new ArrayList<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderList.add(inorder[i]);
            }
            List<Integer> postorderList = new ArrayList<>();
            for (int i = 0; i < postorder.length; i++) {
                postorderList.add(postorder[i]);
            }
            return helper(inorderList,postorderList);
        }
        return root;
    }

    private TreeNode helper(List<Integer> inorderList, List<Integer> postorderList) {
        TreeNode root = null;

        List<Integer> leftInorderList = new ArrayList<>();
        List<Integer> rightInorderList = new ArrayList<>();
        List<Integer> leftPostorderList = new ArrayList<>();
        List<Integer> rightPostorderList = new ArrayList<>();

        if (inorderList.size() != 0 && postorderList.size() != 0){
            root = new TreeNode(postorderList.get(postorderList.size() - 1));
            int rootInorderPos = inorderList.indexOf(root.val);
            leftInorderList = inorderList.subList(0,rootInorderPos);
            rightInorderList = inorderList.subList(rootInorderPos+1,inorderList.size());

            int leftInorderSize =leftInorderList.size();
            leftPostorderList = postorderList.subList(0,leftInorderSize);
            rightPostorderList = postorderList.subList(leftInorderSize,postorderList.size() - 1);

            root.left = helper(leftInorderList,leftPostorderList);
            root.right = helper(rightInorderList,rightPostorderList);
        }
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
