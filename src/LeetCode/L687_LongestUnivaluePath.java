package LeetCode;

/**
 *
 * 解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
 * 1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
 * 2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
 * 需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
 */
public class L687_LongestUnivaluePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)return 0;
        helper(root,root.val);
        return max;
    }

    private int helper(TreeNode node, int val) {
        if (node == null)return 0;
        int left = helper(node.left,node.val);
        int right = helper(node.right,node.val);
        max = Math.max(max,left + right);// 路径长度为节点数减1所以此处不加1
        if (node.val == val)
            return Math.max(left,right) + 1;
        return 0;
    }
//        下面是自己作物的思路
//        if (node.val == val){
//            return Math.max(helper(node.left,node.val,count+1),helper(node.right,node.val,count+1));
//        } else {
//            return Math.max(helper(node.left,node.val,count),helper(node.right,node.val,count));
//        }
}
