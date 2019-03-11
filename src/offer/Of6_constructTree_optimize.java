package offer;

import java.util.HashMap;
import java.util.Map;

public class Of6_constructTree_optimize {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int[] preOrder;
    int[] inOrder;
    Map<Integer,Integer> hash = new HashMap<>();

    TreeNode buildTree(int[] preOrder,int[] inOrder){
        preOrder = preOrder;
        inOrder = inOrder;
        for (int i = 0;i < inOrder.length;i++) {
            hash.put(inOrder[i],i);
        }
        return dfs(0,preOrder.length -1,0,inOrder.length - 1);
    }

    /**
     *
     * @param pl  preorder的左边界
     * @param pr  preorder的右边界
     * @param il  inorder的左边界
     * @param ir  inorder的右边界
     * @return
     */
    private TreeNode dfs(int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        int rootVal = preOrder[pl];//前序遍历的第一个元素是根节点
        TreeNode root = new TreeNode(rootVal);
        int k = hash.get(rootVal);//根节点在中序遍历中的索引位置
        //然后递归遍历
        //todo 边界问题也很重要
        TreeNode left = dfs(pl+1,pl+k-il,il,k - 1);//pl+k-il = pl+1+k-il-1
        TreeNode right = dfs(pl + k - il + 1,pr,k + 1,ir);
        root.left = left;
        root.right = right;
        return root;
    }

}
