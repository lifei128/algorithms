package offer;

/**
 * Created by lifei on 2017/3/27.
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * todo 翻转链表,而不是从尾开始打印
 *
 */
public class Of16 {

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

        Node root = reverseList(head);
        while (root != null){
            System.out.println(root.data);
            root = root.nextNode;
        }
    }

    private static Node reverseList(Node head) {
        if (head == null)return null;
        Node pre = null;
        Node now = head;
        while (now != null){
            Node next = now.nextNode;   //保存下一个结点
            now.nextNode = pre;         //当前结点指向前一个结点

            //为下一轮循环做准备
            pre = now;                  //前任结点 到现任节点
            now = next;                 //现任节点到下一结点
        }
        return pre;
    }
}
