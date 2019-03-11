package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class L105_BuildTreeByPreMiddle {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if (preorder.length != 0 && inorder.length != 0){
            //todo 先转化为list处理
            List<Integer> preorderList =  new ArrayList<>();
            for (int i = 0; i < preorder.length; i++) {
                preorderList.add(preorder[i]);
            }
            List<Integer> inorderList = new ArrayList<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderList.add(inorder[i]);
            }

            return helper(preorderList,inorderList);
        }
        return root;
    }

    private TreeNode helper(List<Integer> preorderList, List<Integer> inorderList) {
        TreeNode root = null;
        List<Integer> leftPreorderList = new ArrayList<>();
        List<Integer> rightPreorderList = new ArrayList<>();

        List<Integer> leftInorderList = new ArrayList<>();
        List<Integer> rightInorderList = new ArrayList<>();

        if (preorderList.size() != 0 && inorderList.size() != 0){
            root = new TreeNode(preorderList.get(0));
            int inOrderpos = inorderList.indexOf(root.val);//根节点
            leftInorderList = inorderList.subList(0,inOrderpos);
            rightInorderList = inorderList.subList(inOrderpos+1,inorderList.size());

            int leftInorderSize = leftInorderList.size();
            leftPreorderList = preorderList.subList(1,leftInorderSize+1);
            rightPreorderList = preorderList.subList(leftInorderSize+1,preorderList.size());

            //todo 重点
            root.left = helper(leftPreorderList,leftInorderList);
            root.right = helper(rightPreorderList,rightInorderList);
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
