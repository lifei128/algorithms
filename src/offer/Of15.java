package offer;

/**
 * Created by lifei on 2017/3/27.
 * 题目： 输入一个链表，输出该链表中倒数第k哥结点
 *
 */
public class Of15 {
    static class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;

        Node kthNode = findKthNode(head,2);
        System.out.println(kthNode.data);
    }

    private static Node findKthNode(Node head, int k) {
        if (head == null || k == 0){
            return null;
        }
        Node p = head;
        Node q = null;
        for (int i = 0; i < k -1; i++){//首先将前置节点跑到k;不必在一个循环中同时对p q做处理,容易出现问题
            if (p.nextNode != null){
                p = p.nextNode;
            } else {
                return null;
            }
        }
        q = head;
        while (p.nextNode != null){
            p = p.nextNode;
            q = q.nextNode;
        }
        return q;
    }
}
