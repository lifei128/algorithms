package com.lifeibigdata.algorithms.linearlist;

/**
 * Created by lifei on 16/5/26.
 *
 * 问题描述:
 1,单链表反转
 2,链表翻转(此题为2013.9.11美团校招面试题)。给出一个链表和一个数k 比如链表1→2→3→4→5→6 若k=2，则翻转后2→1→4→3→6→5 ; 若k=3,翻转后3→2→1→6→5→4
 */
public class ReverseLink {

    public static void main(String[] args) {
        Node on = createLink();
        printLink(on);
        on = reverse1(on);
        printLink(on);
        on = reverse2(createLink(), 2);
        printLink(on);
    }

    /**
     * 链表翻转。给出一个链表和一个数k 比如链表1→2→3→4→5→6 若k=2，则翻转后2→1→4→3→6→5 若k=3,翻转后3→2→1→6→5→4
     * 若k=4，翻转后4→3→2→1→5→6
     *
     * @param on
     * @param offset
     * @return
     */
    private static Node reverse2(Node on, int offset) {
        if (on == null)
            return null;
        Node pre = null;//部分反转的链表
        Node newN = null;//新的链表
        Node tail = null;//记录下一部分的真实引用
        //TODO 需要计算划分为几部分,现在是写死的
        for (int j = 0; j < 3; j++) {
            //tmp起始为0,目的是尾部的临时链表
            Node tmp = on;
            for (int i = 0; i < offset; i++) {
                Node next = on.getNextNode();
                on.setNextNode(pre);
                pre = on;
                on = next;
            }
            //记录第一部分反转的引用
            if (j == 0)
                newN = pre;
            //tmp起始为下一部分的引用,没有则为null
            tmp.setNextNode(on);
            if (tail != null)
                tail.setNextNode(pre);//设置下一个部分的起始引用指向当前部分的反转引用
            //记录下一个部分的起始引用
            tail = tmp;
        }
        return newN;
    }

    /**
     * 单链表反转
     *
     * @param on
     * @return
     */
    private static Node reverse1(Node on) {
        if (on == null)
            return null;
        Node pre = on;
        Node cur = on.getNextNode();
        Node next = null;
        while (cur != null) {
            next = cur.getNextNode();
            cur.setNextNode(pre);
            pre = cur;
            cur = next;
        }
        on.setNextNode(null);
        return pre;
    }

    private static void printLink(Node node) {
        Node on = node;
        while (on != null) {
            System.out.print(on.getCount() + "\t");
            on = on.getNextNode();
        }
        System.out.println("\n");
    }

    private static Node createLink() {
        Node on = new Node(0);
        Node next;
        Node cur = null;
        for (int i = 1; i < 6; i++) {
            next = new Node(i);
            if (i == 1)
                on.setNextNode(next);
            else
                cur.setNextNode(next);
            cur = next;
        }
        return on;
    }

}

class Node {
    private int count;
    private Node nextNode;

    public Node(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}