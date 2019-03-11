package offer;

/**
 * 删除链表中重复的结点
 * 　　在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复结点被删除之后，链表如图3.4（b）所示。
 *
 *
 * 思路
 * 　　设置一个preNode，用于记录当前结点的前一个结点，再设置一个布尔变量needDelete，如果当前结点和后一结点的值相同（记该值为dupVal），needDelete赋值为真。
 *
 * 　　当needDelete为真时，通过循环往后找到第一个不为dupVal的结点，把该结点设置为当前结点，并赋值给preNode.next，即相当于完成了删除操作；
 * 而当needDelete为假时，把当前结点和preNode往后移一位即可。
 */
public class Of18_deleteDuplicationLinkedNode {

    class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val,ListNode next) {
            this.val = val;
            this.next=next;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead==null||pHead.next==null) //空结点或者仅一个结点
            return pHead;
        ListNode preNode = null;
        ListNode curNode = pHead;

        while(curNode!=null){
            boolean needDelete=false;
            if(curNode.next!=null && curNode.val==curNode.next.val)
                needDelete=true;
            if(!needDelete){  //当前结点不重复
                preNode=curNode;
                curNode=curNode.next;
            }else{            //当前结点重复
                int dupValue=curNode.val;
                ListNode toBeDel = curNode;
                while(toBeDel!=null&&toBeDel.val==dupValue){
                    //这里删除暂时不涉及前一结点操作，其实主要是找出后面第一个不重复结点
                    toBeDel = toBeDel.next;
                }
                if(preNode==null){  //说明删除的结点为头结点
                    pHead=toBeDel;
                }else{
                    preNode.next=toBeDel;
                }
                curNode=toBeDel;  //这个结点还是可能会出现重复的，所以不能=next
            }
        }
        return pHead;
    }

}
