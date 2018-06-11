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
        ListNode newHead = rln.reverse4(head);//TODO 3种方式
        Utils.print(newHead);
//        System.out.println("===========create==============");
//        ListNode cln = createList(new int[]{1,2,3,4,5});
//        Utils.print(cln);
    }


    /**
     * 第一轮
     * 3.next (reverse) revHead 4
     * 3.next.next=4.next(赋值前为null)   3
     * 3.next -> null
     * 4 3 null
     *
     *第二轮
     * 2.next.next=3.next(赋值前为null)   2
     * 2.next -> null
     * 4 3 2 null
     *
     *
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head){
        if (null == head || null == head.next){//TODO 如果是终节点,就会将终结点返回,所以revHead就是终结点
            return head;
        }
        ListNode revHead = reverse(head.next);
        System.out.println("----"+head.val+","+head.next.val+"----");
        head.next.next = head;  //3.next.next=4.next   3
        head.next = null;       //3.next=4  null
        return revHead;
    }

    //“头插法”思想描述：从链表的第一个结点开始，以每一个结点为单位，遍历链表，将遍历到的结点依次插入到头结点的后面
    ListNode reverse2(ListNode head){//TODO
        if (null == head || null == head.next) {
            return head;
        }
        ListNode pre = null;    //新链表过程中的头结点
        ListNode cur = head;    //cur为遍历的游标,同时也是最后返回链表的头结点
        ListNode next = cur.next;
        while (next != null){   //todo cur为即将插入的节点,此处是判断循环终止的条件
            cur.next = pre;     //将待插入的节点->新链表的头结点
            pre = cur;          //将新插入的节点,作为下一次循环的头结点
            cur = next;         //循环下一个节点
            next = cur.next;    //判断新节点的下一个节点,进行循环
        }
        cur.next = pre;
        return cur;
    }

    //头插法
    static ListNode reverse3(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode nextHead = null;   //待转置的下一个节点
        ListNode newHead = null;	//新链的头节点
        ListNode newn = null;  		//待插入插入的节点			需要待插入的节点直接指向新链的头节点，那么返回新插入的节点，就是插入之后链的头节点

        newHead = head;		//把旧头结点赋值给新头结点
        head = head.next;	//此时的head已经是第二个节点
        newHead.next = null;

        while(head.next != null){	//此时的head是第二个节点,该节点为需要加入链表的新节点，即newn; head.next第三个节点,，
            nextHead = head.next;	//下一次待转置的节点
            newn = head;			//将要插入的新节点
            newn.next = newHead;	//新插入的节点指向 新链的头节点
            newHead = newn;			//将新插入的节点作为新链的节点

            // newn.next = newHead.next; //错误的  不能用创建链表的方式，因为创建链表的方式有一个空的头节点
            // newHead.next = newn;		 //错误的
            head = nextHead;
        }
        newn = head;	//因为每次判断的是新插入节点的下一个节点，所以最后一个节点不在循环中，此时的head就是最后一个节点
        newn.next = newHead;
        return newn;
    }

    ListNode reverse4(ListNode L){//TODO
        ListNode head = null;
        ListNode temp ;
        while (L != null){
            temp = L.next;//将第二个节点赋值给tmp
            L.next = head;//将第一个节点指向新的头结点
            head = L;     //将新的头结点L赋值给head,用于下次循环
            L = temp;     //下一次迭代中迭代的是第二个节点
        }
        return head;
    }

    /**
     * 图示
     * @param head
     * @return
     */
    ListNode reverse5(ListNode head){//TODO
        ListNode pRerverseHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null){
            ListNode next = pNode.next;
            if (next == null){
                pRerverseHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = next;
        }
        return pRerverseHead;
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


