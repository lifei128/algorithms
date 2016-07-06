package com.lifeibigdata.algorithms.leetcode;


/**
 * Created by lifei on 16/6/30.
 */
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode n1 =new ListNode(2);
        ListNode n2 =new ListNode(3);
        ListNode n3 =new ListNode(4);
        //初始化链表
        head.next = n1 ;
        n1.next = n2;
        n2.next = n3;
        System.out.println("打印链表反转前：");
        Utils.print(head);
        ReverseListNode rln = new ReverseListNode();
        System.out.println("打印链表反转后：");
        ListNode newHead = rln.reverse(head);
        Utils.print(newHead);
    }




    ListNode reverse(ListNode head){
        if (null == head || null == head.next){
            return head;
        }
        ListNode revHead = reverse(head.next);
        head.next.next = head;  //注意这个地方是两个next
        System.out.println("----"+head.next.val+","+head.val+"----");
        head.next = null;
        return revHead;

    }

    /**
     *
     *
     打印链表反转前：
     1->2->3->4->
     打印链表反转后：
     ----4,3----
     ----3,2----
     ----2,1----
     4->3->2->1->

     */
}
