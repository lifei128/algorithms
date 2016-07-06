package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/30.
 *
 * 1 转化为两两合并
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);

        l1.next = n1;
        n1.next = n2;
        n2.next = n3;

        ReverseKGroup mt = new ReverseKGroup();
        ListNode head = mt.reverseKGroup(l1,2);
        Utils.print(head);
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null)
            return head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode first = head, last = head;
        ListNode preGroup = preHead, nextGroup = preHead;
        int count = 1;
        while (last != null) {
            if (count == k) {          //当满足k个组合时进行翻转
                nextGroup = last.next; //下一个组合的首节点
                reverseList(first, last);
                preGroup.next = last;  //翻转之后last已经是首节点
                preGroup = first;      //preGroup设置自己为最末,此后first继续下一个组合,采用preGroup的深意,是不打扰first继续下一个组合


                first.next = nextGroup;
                first = nextGroup;
                last = nextGroup;
                count = 1;
                continue;
            }
            last = last.next;
            count++;
        }
        return preHead.next;
    }

    private void reverseList(ListNode head, ListNode tail) {
        ListNode pre = new ListNode(-1), node = head;
        pre.next = head;
        while (pre != tail) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
    }


}
