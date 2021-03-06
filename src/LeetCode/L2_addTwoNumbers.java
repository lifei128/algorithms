package LeetCode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class L2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode rst = dummy;
        int sum = 0;
        while (l1 != null && l2 != null){
            int tempSum = l1.val + l2.val;
            dummy.next = new ListNode((tempSum + sum) % 10);
            sum = (tempSum + sum) / 10;
            l1 = l1.next;
            l2 = l2.next;
            dummy = dummy.next;
        }

        while (l1 != null){
            dummy.next = new ListNode((l1.val + sum) % 10);
            sum = (l1.val + sum) / 10;
            l1 = l1.next;
            dummy = dummy.next;
        }
        while (l2 != null){
            dummy.next = new ListNode((l2.val + sum) % 10);
            sum = (l2.val + sum) / 10;
            l2 = l2.next;
            dummy = dummy.next;
        }
        if (sum > 0){
            dummy.next = new ListNode(sum);
        }
        return rst.next;
    }
}
