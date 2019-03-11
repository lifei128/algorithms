package offer;

/**
 *
 * 对称的二叉树
 * 题目　
 * 　　请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 回到顶部
 * 思路
 * 　　还是画图分析，不用分析根结点，只需要分析左右子树。可以看出，左右子树刚好是呈镜像的两颗二叉树，所以：对左子树采用（父-左-右）的前序遍历，
 * 右子树采用（父-右-左）的前序遍历，遍历时判断两个结点位置的值是否相等即可。
 * （也可以这样理解：左树的左子树等于右树的右子树，左树的右子树等于右树的左子树，对应位置刚好相反，判断两子树相反位置上的值是否相等即可）
 */
public class Of28_SymmetricalBinaryTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null)
            return true; //根结点为null时，认为是对称二叉树
        return isEqual(pRoot.left,pRoot.right);
    }

    private boolean isEqual(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1==null && pRoot2==null)
            return true;
        if(pRoot1==null || pRoot2==null)
            return false;
        return pRoot1.val==pRoot2.val
                && isEqual(pRoot1.left, pRoot2.right)
                && isEqual(pRoot1.right, pRoot2.left);
    }

}
