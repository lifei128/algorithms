package offer;

/**
 *
 * 超经典
 * 二叉树的下一个结点
 * 题目
 * 　　todo 给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 *    树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * 思路    todo 中序遍历是左根右
 * 　　首先自己在草稿纸上画图，进行分析（不再展开）。可以发现下一个结点的规律为：
 * 　　1.若当前结点有右子树时，其下一个结点 todo 为右子树中最左子结点；
 * 　　2.若当前结点 todo 无右子树时，
 * 　　　　（1）若当前结点为其父结点的 todo **左**子结点时（左儿子）， 其下一个结点为其父结点；
 * 　　　　（2）若当前结点为其父结点的 todo **右**子结点时（右儿子），继续向上遍历父结点的父结点，直到找到一个结点是其父结点的左子结点（与（1）中判断相同），该结点即为下一结点。
 *
 * 如果是二叉搜索树就是比当前元素大的第一个节点
 *
 * Oh时间复杂度取决于树的高度
 *
 * todo 重点是分情况讨论
 *
 * 思考题：对所有节点求后继，时间复杂度是On
 */
public class Of7_getNextTreeNode {

    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {//todo 每次根据当前节点判断
        if (pNode == null) {
            System.out.print("结点为null ");
            return null;
        }
        if (pNode.right != null) {//todo  1.若当前结点有右子树时，其下一个结点为右子树中最左子结点；
            pNode = pNode.right;
            while (pNode.left != null)
                pNode = pNode.left;
            return pNode;
        }
        //todo 2.若当前结点  无右子树时，
//        while (pNode.parent != null) {
//            if (pNode == pNode.parent.left)//todo 判断当前结点为其父结点的 **左**子结点（左儿子）
//                return pNode.parent;
//            pNode = pNode.parent;//todo 若当前结点为其父结点的 **右**子结点时，顺着父亲节点往上找，直到找到一个节点是其父节点的左儿子。
//        }
//        return null;

        //更简单的写法
        while (pNode.parent != null && pNode == pNode.parent.right) {//todo pNode是父节点的右儿子，如果是做儿子会直接跳过循环
            pNode = pNode.parent;
        }
        return pNode.parent;

    }
}
