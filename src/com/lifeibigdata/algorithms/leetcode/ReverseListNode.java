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
        ListNode newHead = rln.reverse3(head);//TODO 3种方式
        Utils.print(newHead);
        System.out.println("===========create==============");
        ListNode cln = createList(new int[]{1,2,3,4,5});
        Utils.print(cln);
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

    //“头插法”思想描述：从链表的第一个结点开始，以每一个结点为单位，遍历链表，将遍历到的结点依次插入到头结点的后面
    ListNode reverse2(ListNode head){//TODO
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }

    ListNode reverse3(ListNode L){//TODO
        ListNode head = null;
        ListNode temp ;
        while (L != null){
            temp = L.next;
            L.next = head;
            head = L;
            L = temp;
        }
        return head;
    }

    static ListNode createList(int[] values){
        ListNode head = new ListNode(0);
        for(int i = 0;i < values.length;i++){
            ListNode node = new ListNode(values[i]);//新节点node
            node.next = head.next;//将头节点的尾部转移到新节点的尾部
            head.next = node;//将头结点尾部指向新节点
        }
        return head.next;
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
