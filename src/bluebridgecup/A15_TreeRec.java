package bluebridgecup;

import java.util.ArrayList;

public class A15_TreeRec {
    /**
     * 中序遍历递归解法
     * （1）如果二叉树为空，空操作。
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public void inOrderRec(TreeNode root){
        if (root == null)return;
        inOrderRec(root.left);
        System.out.println(root.val);
        inOrderRec(root.right);
    }

    /**
     *  分层遍历二叉树（递归）
     *  很少有人会用递归去做level traversal
     *  基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。
     *  大的ArrayList的size和level有关系
     *
     */
    public static void levelTraversalRec(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, ret);
        System.out.println(ret);
    }

    private static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret){
        if(root == null){
            return;
        }

        // 添加一个新的ArrayList表示新的一层
        if(level >= ret.size()){
            ret.add(new ArrayList<Integer>());
        }

        ret.get(level).add(root.val);   // 把节点添加到表示那一层的ArrayList里
        dfs(root.left, level+1, ret);       // 递归处理下一层的左子树和右子树
        dfs(root.right, level+1, ret);
    }

    /**
     * 求二叉树中的节点个数递归解法： O(n)
     * （1）如果二叉树为空，节点个数为0
     * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;  //左 右节点加上主节点1为总数
        }
    }



    /**
     * 求二叉树的深度（高度） 递归解法： O(n)
     * （1）如果二叉树为空，二叉树的深度为0
     * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
     *
     *
     *
     maxDepth()
     1. 如果树为空，那么返回0
     2. 否则
     (a) 递归得到左子树的最大高度
     例如，调用maxDepth( tree-> left-subtree )
     (b) 递归得到右子树的最大高度
     例如，调用maxDepth( tree-> right-subtree )
     (c) 对于当前节点，取左右子树高度的最大值并加1。
     max_depth = max(左子树的最大高度, 右子树的最大高度) + 1
     (d) 返回max_depth
     */
    public static int getDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getDepthRec(root.left);
        int rightDepth = getDepthRec(root.right);
        return Math.max(leftDepth, rightDepth) + 1;   // +1是因为根节点已经是一层了,否则root==null直接是0了
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
