package com.lifeibigdata.algorithms.leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;

/**
 * Created by lifei on 16/5/29.
 */
public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        head.next = n1;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;

        RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();
        System.out.println(r.removeNthFromEnd(head,1).val);;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lead = head;
        ListNode follow = head;

        for (int i = 0; i < n; i++){
            lead = lead.next;
        }
        if (lead == null){
            head = head.next;
        } else {
            while (lead.next != null){
                lead = lead.next;
                follow = follow.next;
            }
            follow.next = follow.next.next;
        }
        return head;
    }






















//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if (head == null) return null;
//        ListNode p = head;  //后序节点
//        ListNode q = head;  //前序节点
//        for (int i = 0; i < n; i++){
//            q = q.next;
//        }
//        if (q == null){         //n的长度刚好等于链表的长度,所以此时只需要head = head.next即可
//            head = head.next;
//            p = null;
//            return head;
//        }
//        while (q.next != null){  //判断是否到最后
//            p = p.next;
//            q = q.next;
//        }
//        ListNode tmp = p.next.next;
//        p.next = tmp;
//        return head;
//    }
}
