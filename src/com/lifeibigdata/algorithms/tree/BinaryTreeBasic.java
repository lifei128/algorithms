package com.lifeibigdata.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lifei on 2018/6/12.

 */
public class BinaryTreeBasic {

    /*
                 1
                / \
               2   3
              / \   \
             4  5    6
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
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
     *  求二叉树中的节点个数迭代解法O(n)：基本思想同LevelOrderTraversal，
     *  即用一个Queue，在Java里面可以用LinkedList来模拟
     */
    public static int getNodeNum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int count = 1;          //初始化为1
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);            //将根节点先放到队列中

        while(!queue.isEmpty()){
            TreeNode cur = queue.remove();      //返回队头元素并移除
            if(cur.left != null){               // 如果有左孩子，加到队尾
                queue.add(cur.left);
                count++;
            }
            if(cur.right != null){              // 如果有右孩子，加到队尾
                queue.add(cur.right);
                count++;
            }
        }

        return count;
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

    /**
     * 求二叉树的深度（高度） 迭代解法： O(n)
     * 基本思想同LevelOrderTraversal，还是用一个Queue
     */
    public static int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int depth = 0;                  // 深度
        int currentLevelNodes = 1;      // 当前Level，node的数量
        int nextLevelNodes = 0;         // 下一层Level，node的数量

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);                //将根节点放入队列

        while( !queue.isEmpty() ){              //判断队列是否为空
            TreeNode cur = queue.remove();      // 从队头位置移除
            currentLevelNodes--;                // 减少当前Level node的数量
            if(cur.left != null){               // 如果有左孩子，加到队尾
                queue.add(cur.left);
                nextLevelNodes++;               // 并增加下一层Level node的数量
            }
            if(cur.right != null){              // 如果有右孩子，加到队尾
                queue.add(cur.right);
                nextLevelNodes++;
            }

            if(currentLevelNodes == 0){                 // 说明已经遍历完当前层的所有节点      ***********该判断是层级的界限,遍历完一层,则高度+1
                depth++;                                // 增加高度                         ***********高度+1
                currentLevelNodes = nextLevelNodes;     // 初始化下一层的遍历                ***********遍历下一层
                nextLevelNodes = 0;
            }
        }

        return depth;
    }

    /**
     * 若某一层的节点数不少于其他层次的节点数，那么该节点数即为二叉树的宽度。
     *
     * @param root
     * @return
     */
    public static int getWidth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int maxWidth = 1;           //初始化值为1
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);            //将根节点放入队列

        while (true){                               //第一层循环
            int len = queue.size();                 //获取当前层节点的个数
            if (len == 0)                           //队列为空,跳出第一层循环
                break;
            while (len > 0){                        //第二层循环,循环所有节点,将下一层节点放到队列中
                TreeNode t = queue.removeFirst();   //弹出第一个节点    https://www.yiibai.com/java/util/linkedlist_removefirst.html
                len--;                              //弹出一个结点-1，为0就退循环
                if (t.left != null){
                    queue.add(t.left);
                }
                if (t.right != null){
                    queue.add(t.right);
                }
            }
            maxWidth = Math.max(maxWidth,queue.size());
        }

        return maxWidth;
    }



    /**
     * 前序遍历，中序遍历，后序遍历 前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     */
    public static void preorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);            //左子树
        preorderTraversalRec(root.right);           //右子树
    }

    /**
     *  前序遍历:根左右
     *  前序遍历迭代解法：用一个辅助stack，总是把右孩子先放进栈
     */
    public static void preorderTraversal(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();      // 辅助stack
        stack.push(root);

        while( !stack.isEmpty() ){
            TreeNode cur = stack.pop();      // 出栈栈顶元素
            System.out.print(cur.val + " "); //todo 打印出遍历结果

            // 关键点：要先压入右孩子，再压入左孩子，这样在出栈时会先打印左孩子再打印右孩子
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    /**
     * 中序遍历递归解法
     * （1）如果二叉树为空，空操作。
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    public static void inorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    /**
     * 中序遍历迭代解法 ，用栈先把根节点的所有左孩子都添加到栈内，
     * 然后输出栈顶元素，再处理栈顶元素的右子树
     * http://www.youtube.com/watch?v=50v1sJkjxoc
     *
     * 还有一种方法能不用递归和栈，基于线索二叉树的方法，较麻烦以后补上
     * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
     */
    public static void inorderTraversal(TreeNode root){   //中序 是左中右  栈中首先存的是一路靠左的节点,到达最底部之后,取右边的,放到栈中,一旦某个环节结束,就跳出返到双亲节点
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();// 辅助stack
        TreeNode cur = root;

        while( true ){//第一层循环
            while(cur != null){     //第二层循环,先找到最左孩子 先添加一个非空节点所有的左孩子到栈
                stack.push(cur);
                cur = cur.left;
            }

            if(stack.isEmpty()){
                break;    // 跳出第一层循环
            }

            // 因为此时已经没有左孩子了，所以输出栈顶元素,即最左孩子
            cur = stack.pop();
            System.out.print(cur.val + " ");//todo 打印遍历结果
            cur = cur.right;    //处理最左孩子的右子树
        }
    }

    /**
     * 后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    public static void postorderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    /**
     *  后序遍历:左右根
     *  后序遍历迭代解法
     *  http://www.youtube.com/watch?v=hv-mJUs5mvU
     *  todo 重点重点重点重点重点重点重点重点重点重点
     *  https://www.cnblogs.com/turnips/p/5096578.html
     */
    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();      // 第一个stack用于添加node和它的左右孩子
        Stack<TreeNode> output = new Stack<TreeNode>(); // 第二个stack用于翻转第一个stack输出

        s.push(root);
        while( !s.isEmpty() ){      // 确保所有元素都被翻转转移到第二个stack
            TreeNode cur = s.pop(); // 把栈顶元素添加到第二个stack
            output.push(cur);
            // 关键点：要先压入左孩子，再压入右孩子，这样在出栈时会先弹出右孩子再弹出左孩子
            //这一点和前序遍历相反
            if(cur.left != null){       // 把栈顶元素的左孩子和右孩子分别添加入第一个stack
                s.push(cur.left);
            }
            if(cur.right != null){
                s.push(cur.right);
            }
        }

        while( !output.isEmpty() ){ // 遍历输出第二个stack，即为后序遍历
            System.out.print(output.pop().val + " ");
        }
    }

    /**
     * 分层遍历二叉树（按层次从上往下，从左往右）迭代
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。当队列不为空，进行如下操作：弹出一个节点
     * ，访问，若左子节点或右子节点不为空，将其压入队列
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
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
}
