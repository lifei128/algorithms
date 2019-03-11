package offer;

public class Of52_getFirstCommonNode {
    /**
     * 求两个单链表相交的第一个节点 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。
     * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和第一个链表的最后一个节点相同，若不相同，不相交，结束。
     * 两个链表均从头节点开始，假设len1大于len2
     * ，那么将第一个链表先遍历len1-len2个节点，此时两个链表当前节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到两个节点的地址相同。
     * 时间复杂度，O(len1+len2)
     *
     *              ----    len2
     *                   |__________
     *                   |
     *       ---------   len1
     *       |---|<- len1-len2
     */
    public static Node getFirstCommonNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        int len1 = 1;
        Node tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
            len1++;
        }

        int len2 = 1;
        Node tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
            len2++;
        }

        // 不相交直接返回NULL
        if (tail1 != tail2) {
            return null;
        }

        Node n1 = head1;
        Node n2 = head2;

        // 略过较长链表多余的部分
        if (len1 > len2) {
            int k = len1 - len2;
            while (k != 0) {
                n1 = n1.next;
                k--;
            }
        } else {
            int k = len2 - len1;
            while (k != 0) {
                n2 = n2.next;
                k--;
            }
        }

        // 一起向后遍历，直到找到交点
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
