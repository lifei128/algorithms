package com.lifeibigdata.offer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * Created by lifei on 16/11/13.
 */
public class PrintListReverse {
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5;
        printListReverse2(n1);
    }

    static void printListReverse1(Node head){
        Stack<Node> stack = new Stack();
        Node tmpNode = head;
        while (tmpNode != null){
            stack.push(tmpNode);
            tmpNode = tmpNode.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().val);
        }
    }

    /**
     * 栈的本质是递归,要实现反过来输出链表,我们访问到一个节点的时候,先递归输出后面的节点,再输入该节点本身,这样链表的输出结果就反过来了
     * @param head
     */
    static void printListReverse2(Node head){
        if (head != null){
            if (head.next != null){
                printListReverse2(head.next);
            }
            System.out.println(head.val);
        }
    }
}
