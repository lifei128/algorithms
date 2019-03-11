package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * 使用中序遍历
 * https://blog.csdn.net/qq_38959715/article/details/82682383
 *
 */
public class L501_BSTFindMode {
    TreeNode pre = null;//todo must全局
    Integer curTimes = 1,maxTimes = 0;//todo must全局
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};

        List<Integer> list = new ArrayList<>();
        inOrder(root,list);

        int[] result = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left,list);
        if (pre != null){
            curTimes = (root.val == pre.val) ? curTimes + 1 : 1;
        }

        if (curTimes == maxTimes){
            list.add(root.val);
        } else if (curTimes > maxTimes){
            list.clear();
            list.add(root.val);
            maxTimes = curTimes;
        }
        pre = root;
        inOrder(root.right,list);
    }
    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        TreeNode t1  = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        r.right = t1;
        t1.left = t2;
        L501_BSTFindMode t = new L501_BSTFindMode();
        int[] mode = t.findMode(r);
        for (int x:mode) {
            System.out.println(x);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
