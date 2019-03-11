package offer;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 *
 * 设置全局变量index=0，对BST进行中序遍历，每遍历一个结点，index+1，当index=k时，该结点即为所求结点。
 */
public class Of54_KthTreeNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int index=0;//todo 当前第几个

    TreeNode KthNode(TreeNode pRoot, int k){
        TreeNode pNode = null;
        if(pRoot==null || k<=0)
            return pNode;
        pNode = getKthNode(pRoot,k);
        return pNode;
    }

    private TreeNode getKthNode(TreeNode pRoot, int k){
        TreeNode kthNode=null;//todo 定义kthNode

        if(pRoot.left!=null)
            kthNode=getKthNode(pRoot.left,k);

        if(kthNode==null){
            index++;
            if(k==index)
                kthNode = pRoot;
        }

        if(kthNode==null && pRoot.right!=null)
            kthNode=getKthNode(pRoot.right,k);

        return kthNode;
    }
}
