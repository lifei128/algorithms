package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/30.
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode l2 = new ListNode(0);

        l1.next = n1;
        n1.next = n2;

        MergeTwoLists mt = new MergeTwoLists();
        ListNode head = mt.mergeTwoLists(l1,l2);
        System.out.println(head.val);
        System.out.println(head.next.val);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        ListNode end = null;
        ListNode first = l1;   //第一个链表
        ListNode second = l2;  //第二个链表

        while (first != null && second != null){
            int tmp1 = first.val;
            int tmp2 = second.val;

            if (tmp1 <= tmp2){
                if (head == null){
                    head = first;
                    end = head;              //  head作为头指针,end作为操作指针***
                } else {
                    end.next = first;        //  赋值给操作指针
                    end = end.next;          //  将操作指针的下一个节点赋值给当前节点,用于循环
                }
                first = first.next;
            } else {
                if (head == null){
                    head = second;          //head只作返回结果用
                    end = head;             //  head作为头指针,end作为操作指针***
                } else {
                    end.next = second;        //  ?
                    end = end.next;          //  ?
                }
                second = second.next;
            }
        }
        if (first == null){
            while (second != null){
                end.next = second;
                end = end.next;
                second = second.next;
            }
        }
        if (second == null){
            while (first != null){
                end.next = first;
                end = end.next;
                first = first.next;
            }
        }
        return head;
    }
}
