package com.lifeibigdata.algorithms.leetcode;

import java.util.List;

/**
 * Created by lifei on 16/5/27.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1n1 = new ListNode(4);
        ListNode l1n2 = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode l2n1 = new ListNode(6);
        ListNode l2n2 = new ListNode(4);

        l1.next = l1n1;
        l1n1.next = l1n2;

        l2.next = l2n1;
        l2n1.next = l2n2;

        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode pre = atn.addTwoNumbers(l1,l2);
        Utils.print(pre);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;

        ListNode newHead = new ListNode(0);//作为暂存首节点
        ListNode p1 = l1, p2 = l2, p3=newHead; //p3作为操作变量

        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }

            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }

        if(carry==1)
            p3.next=new ListNode(1);

        return newHead.next; //返回首节点
    }
}
