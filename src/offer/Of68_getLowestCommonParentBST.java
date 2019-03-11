package offer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 该题首先要和面试官
 * 确定是否为二叉树，得到肯定答复后，
 * 还要确定是否为二叉搜索树，是否有父指针，或者仅仅是普通二叉树。
 *
 * 　　1.树为二叉搜索树时，最低公共祖先结点的大小在两个树结点大小的中间。
 *
 * 　　2.树为普通树时，使用遍历将子结点的信息往上传递。在左右子树中进行查找是否存在两个树结点，如果两个树结点分别在左右子树上，
 * 说明该根结点就是它们的最低公共祖先。
 *
 *
 * 《剑指OFFER》一书中的方法：普通二叉树时，可以采用链表来存储从根结点到两个树结点的路径，找出两条路径的最后公共结点，就是最低公共祖先。这个方法也要学会。
 */
public class Of68_getLowestCommonParentBST {
    private static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    /*
     * 二叉搜索树
     * 利用大小关系即可
     */
    public TreeNode getLowestCommonParentBST(TreeNode root,TreeNode node1,TreeNode node2) {
        while(true) {
            if(root==null)
                return root;
            if(root.val<node1.val && root.val<node2.val)
                root=root.right;
            else if(root.val>node1.val && root.val>node2.val)
                root=root.right;
            else
                return root;
        }
    }


    /*
     * 普通二叉树
     * 将下面结点的信息利用递归s往上传递
     */
    public TreeNode getLowestCommonParent(TreeNode root,TreeNode node1,TreeNode node2) {
        if(root==null || root== node1 || root== node2)
            return root;
        TreeNode left=getLowestCommonParent(root.left, node1, node2);
        TreeNode right=getLowestCommonParent(root.right, node1, node2);
        return left==null? right:right==null? left:root;
//  上面这句代码就是：
//  if(left==null) {
//          return right;
//  }else {
//      if(right==null)
//          return left;
//      else
//          return root;
//  }
    }


    /**
     * 为普通树时
     * 非递归解法：
     * 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
     */
    public static TreeNode getLastCommonParent(TreeNode root, TreeNode n1, TreeNode n2) {
        if (root == null || n1 == null || n2 == null) {
            return null;
        }

        ArrayList<TreeNode> p1 = new ArrayList<TreeNode>();
        boolean res1 = getNodePath(root, n1, p1);
        ArrayList<TreeNode> p2 = new ArrayList<TreeNode>();
        boolean res2 = getNodePath(root, n2, p2);

        if (!res1 || !res2) {
            return null;
        }

        TreeNode last = null;
        Iterator<TreeNode> iter1 = p1.iterator();
        Iterator<TreeNode> iter2 = p2.iterator();

        while (iter1.hasNext() && iter2.hasNext()) {
            TreeNode tmp1 = iter1.next();
            TreeNode tmp2 = iter2.next();
            if (tmp1 == tmp2) {
                last = tmp1;
            } else { // 直到遇到非公共节点
                break;
            }
        }
        return last;
    }

    // 把从根节点到node路径上所有的点都添加到path中
    private static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);     // 把这个节点加到路径中
        if (root == node) {
            return true;
        }

        boolean found = false;
        found = getNodePath(root.left, node, path); // 先在左子树中找

        if (!found) {               // 如果没找到，再在右子树找
            found = getNodePath(root.right, node, path);
        }
        if (!found) {//todo 如果实在没找到证明这个节点不在路径中，说明刚才添加进去的不是路径上的节点，删掉！
            path.remove(root);
        }

        return found;
    }
}
