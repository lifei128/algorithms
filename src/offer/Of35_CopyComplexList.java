package offer;

/**
 * 复杂链表的复制
 *
 * 题目　
 * 　　请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复制一个复杂链表。
 * 在复杂链表中，每个结点除了有一个m_pNext指针指向下一个点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 *
 * 回到顶部
 * 思路
 * 　　思路1：先复制结点，用next链接，最后根据原始结点的sibling指针确定该sibling结点距离头结点的位置，从而对复制结点设置sibling指针。但是该思路对于n个结点的链表，每个结点的sibling都需要O(n)个时间步才能找到，所以时间复杂度为O(n^2)
 * 　　思路2：复制原始结点N创建N’，用next链接。将<N,N'>的配对信息存放入一个哈希表中；在设置sibling时，通过哈希表，只需要用O(1)的时间即可找到复制结点的sibling。该方法的时间复杂度为O(n)，但空间复杂度为O(n)。
 * 　　思路3：复制原始结点N创建N’，将N'链接到N的后面；根据原始结点N的sibling可以快速设置N'结点的sibling，最后将这个长链表拆分成原始链表和复制链表（根据奇偶位置）
 *
 * 测试算例　
 *
 * 　　1.功能测试（sibling指向自己；链表只有一个结点；sibling指向null或者指向结点）
 * 　　2.特殊测试（头结点为null）
 */
public class Of35_CopyComplexList {
    public class ComplexListNode {
        int val;
        ComplexListNode next = null;
        ComplexListNode sibling = null;

        ComplexListNode(int label) {
            this.val = label;
        }
    }

    /*
     * 主程序（包含三步）
     */
    public ComplexListNode cloneList(ComplexListNode head) {
        cloneNodes(head);           //1.复制结点
        connectSiblingNodes(head);  //2.设置sibling
        return reconnectNodes(head);//3.拆分长链表
    }

    /*
     * 第一步：复制每个结点，并插入到原始节点的后面
     */
    private void cloneNodes(ComplexListNode head) {
        ComplexListNode pNode=head;
        while(pNode!=null) {
            ComplexListNode clonedNode=new ComplexListNode(pNode.val);
            clonedNode.next=pNode.next;
            pNode.next=clonedNode;
            pNode=clonedNode.next;
        }
    }

    /*
     * 第二步：根据原结点的sibling，设置复制结点的sibling
     */
    private void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode pNode=head;
        while(pNode!=null) {
            if(pNode.sibling!=null) //必须考虑到siblingNode==null的情况！
                pNode.next.sibling=pNode.sibling.next;
            pNode=pNode.next.next;
        }
    }

    /*
     * 第三步：将长链表拆分成原始链表和复制链表（根据奇偶位置）
     */
    private ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode clonedHead=null;
        ComplexListNode clonedNode=null;
        ComplexListNode pNode=head;
        if(head!=null) {
            clonedHead=head.next;
            clonedNode=pNode.next;
            pNode.next=clonedNode.next;
            pNode=pNode.next;   //提前将pNode指向下一个结点，方便判断是否为null
        }
        while(pNode!=null) {
            clonedNode.next=pNode.next;
            clonedNode=clonedNode.next;
            pNode.next=clonedNode.next;
            pNode=pNode.next;
        }
        return clonedHead;
    }

}
