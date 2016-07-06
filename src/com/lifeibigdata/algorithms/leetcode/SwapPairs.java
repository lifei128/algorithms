package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/6/30.
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);

        l1.next = n1;
        n1.next = n2;


        SwapPairs sp = new SwapPairs();
        ListNode head = sp.swapPairs(l1);
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);

    }

    ListNode swapPairs(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode last = head.next;
        first.next = swapPairs(last.next);//递归思想 很重要
        last.next = first;
        return last;
    }
}
