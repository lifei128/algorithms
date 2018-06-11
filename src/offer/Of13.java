package offer;

/**
 * Created by lifei on 2017/3/27.
 * 题目：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 *
 *  将待删除节点(A)下一个节点(B)的值,赋值给待删除节点;将待删除节点指向B的下一个节点
 *
 */
public class Of13 {
    static class Node{
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

        Node root = removeNode(head,node2);
        while (root != null){
            System.out.println(root.data);
            root = root.nextNode;
        }
    }

    private static Node removeNode(Node head, Node delNode) {
        if (head == null || delNode == null) return null;
        Node newhead = head;
        if (head == delNode){
            newhead = head.nextNode;
            head = null;
        } else {
            if (delNode.nextNode == null){//delnode
                while (newhead.nextNode.nextNode != null){//在倒数第二个节点停止   ... node node null
                    newhead = newhead.nextNode;
                }
                newhead.nextNode = null;
            } else {
                delNode.data = delNode.nextNode.data;
                delNode.nextNode = delNode.nextNode.nextNode;
            }
        }
        return newhead;
    }
}
