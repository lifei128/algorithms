package offer;

/**
 * Created by lifei on 2017/3/29.
 * 题目：输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建新的结点，只能调整树中结点指针的指向。
 *
 * 中序遍历,结果从小到大
 * 每个节点保持只有两个指针
 *
 * http://wiki.jikexueyuan.com/project/for-offer/question-twenty-seven.html
 */
public class Of27 {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode t6 = new TreeNode(6);
        TreeNode t14 = new TreeNode(14);

        TreeNode t4 = new TreeNode(4);
        TreeNode t8 = new TreeNode(8);

        TreeNode t12 = new TreeNode(12);
        TreeNode t16 = new TreeNode(16);

        root.left = t6;
        root.right = t14;
        t6.left = t4;
        t6.right = t8;
        t14.left = t12;
        t14.right = t16;

        TreeNode head = convert(root);
        while (head != null){
            System.out.print(head.data+",");
            head = head.right;//todo 此处必须是right
        }
    }

    private static TreeNode convert(TreeNode root) {
//        TreeNode node = null;//不可行
        TreeNode[] lastnode = new TreeNode[1];//用于保存处理过程中的双向链表的尾结点
        convert(root,lastnode);
        TreeNode head = lastnode[0];
        while (head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

//    lastNode 已经处理好的双向链表的尾结点，使用一个长度为1的数组，类似C++中的二级指针
    private static void convert(TreeNode root, TreeNode[] lastnode) {//采用中序遍历 lastnode表示已经转换好列表的最后一个节点
        if (root == null)return;
        TreeNode current = root;
        if (current.left != null)//current.left == null时找到最左节点
            convert(current.left,lastnode);
        current.left = lastnode[0];// 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点

        // 如果左子树转换成的双向链表不为空，设置尾结点的后继
        if (lastnode[0] != null)
            lastnode[0].right = current;

        lastnode[0] = current;//todo  记录当前结点为尾结点
        //处理右子树
        if (current.right != null)
            convert(current.right,lastnode);
    }
}
