package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class L199_TreeRightSideView {

    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int cont = queue.size();
            TreeNode node = queue.peek();//todo 队列是先进先出的，因为下面优先遍历的是右子树
            res.add(node.val);
            while(cont > 0){
                node = queue.poll();
                if(node.right != null) queue.add(node.right);//todo here
                if(node.left != null) queue.add(node.left);
                cont--;
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
