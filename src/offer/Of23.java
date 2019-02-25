package offer;

import java.util.*;

/**
 * Created by lifei on 2017/3/28.
 * 题目：从上往下打印二叉树的每个结点，同一层的结点按照从左到右的顺序打印
 *
 */
public class Of23 {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(9);
        TreeNode t6 = new TreeNode(11);

        root1.left = t1;
        root1.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
//        printTree(root1);//层序遍历
//        System.out.println("\n------------------");
//        printTree2(root1);//递归遍历
//        printTree3(root1);//前序遍历
//        printTree4(root1);//中序遍历
//        System.out.println("\n------------------");
        printTree5(root1);//后序遍历

    }

    private static void printTree(TreeNode root1) {
        if (root1 == null) return;
        Queue<TreeNode> queue = new LinkedList<>();//todo 使用队列
        queue.add(root1);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data+",");
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

    }

    private static void printTree5(TreeNode root1) {
        if (root1 == null)return;
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> output = new Stack<>();

        s.add(root1);

        while (!s.isEmpty()){
            TreeNode cur = s.pop();
            output.push(cur);//第一个进栈,最后弹出,进栈顺序是根右左   弹出顺序是左右根,即后序遍历
            if (cur.left != null)//left 先进栈,后弹出,所以会优先遍历右子树
                s.add(cur.left);
            if (cur.right != null)//right 后进栈,所以会先弹出,优先遍历
                s.add(cur.right);
        }
        while (!output.isEmpty()){
            System.out.print(output.pop().data+",");
        }
    }

    private static void printTree4(TreeNode root1) {
        if (root1 == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root1;//只是遍历,不改变原来的结构,所以建立游标
        while (true){
            while (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()){
                break;
            }
            cur = stack.pop();//此时已经没有左孩子了,所以输出栈顶元素,此时的cur也是根节点,满足左中右原则
            System.out.print(cur.data+",");
            cur = cur.right;//处理最左孩子的右子树
        }
    }

    private static void printTree3(TreeNode root1) {
        if (root1 == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root1);
        while (!stack.isEmpty()){       //todo 使用栈
            TreeNode node = stack.pop();
            if (node.right != null)//todo 先将右子节点压栈,才能优先弹出左子节点
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);
        }
    }

    private static void printTree2(TreeNode root1) {
        if (root1 != null)
            System.out.println(root1.data);
        if (root1.left != null)
            printTree2(root1.left);
        if (root1.right != null)
            printTree2(root1.right);
    }

}
/*
*
*Quene
* add        增加一个元索                     如果队列已满，则抛出一个IIIegaISlabEepeplian异常
put         添加一个元素                      如果队列满，则阻塞
offer       添加一个元素并返回true       如果队列已满，则返回false

remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
element  返回队列头部的元素             如果队列为空，则抛出一个NoSuchElementException异常
poll         移除并返问队列头部的元素    如果队列为空，则返回null
peek       返回队列头部的元素             如果队列为空，则返回null
take        移除并返回队列头部的元素     如果队列为空，则阻塞

*************
*
stack
E push(E item)   把项压入堆栈顶部。
E pop()   移除堆栈顶部的对象，并作为此函数的值返回该对象。
E peek()  查看堆栈顶部的对象，但不从堆栈中移除它。
* */

