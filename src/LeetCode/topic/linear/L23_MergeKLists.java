package LeetCode.topic.linear;
/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 *
 * 两个思路：
 * 1、二分合并
 * 2、利用最小堆
 */


import java.util.Comparator;
import java.util.PriorityQueue;

public class L23_MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {//todo lists中保存的是k个链表的头节点
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        //todo PriorityQueue  里面只存储每个链表的头结点
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node:lists) {
            if (node != null){
                q.add(node);
            }
        }
        while (!q.isEmpty()){
            ListNode c = q.poll();
            cur.next = new ListNode(c.val);
            cur = cur.next;//todo
            c = c.next;
            if (c != null){//该节点纳入的比较PriorityQueue中
                q.add(c);
            }
        }
        return dummy.next;
    }

}
