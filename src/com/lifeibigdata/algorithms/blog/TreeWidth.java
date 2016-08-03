package com.lifeibigdata.algorithms.blog;

import com.lifeibigdata.algorithms.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by lifei on 16/7/6.
 */
public class TreeWidth {

    /**
     * 使用队列，层次遍历二叉树。在上一层遍历完成后，下一层的所有节点已经放到队列中，此时队列中的元素个数就是下一层的宽度。
     * 以此类推，依次遍历下一层即可求出二叉树的最大宽度
     * @param root
     * @return
     */
    static int getTreeWidth(TreeNode  root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int maxWidth = 0;
        queue.add(root);
        while (true){              //
            int len = queue.size();
            if (len == 0) break;
            while (len > 0){      //保证上一层被遍历完毕,所以使用了len变量
                TreeNode t = queue.poll();
                len--;
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            maxWidth = Math.max(maxWidth,queue.size());
        }
        return maxWidth;
    }

}
