package offer;

/**
 * Created by lifei on 2017/3/27.
 * 题目:合并两个排序的链表
 */
public class Of17 {
    static class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node h1 = new Node(1);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n7 = new Node(6);
        h1.nextNode = n3;
        n3.nextNode = n5;
        n5.nextNode = n7;

        Node h2 = new Node(2);
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n8 = new Node(8);
        h2.nextNode = n4;
        n4.nextNode = n6;
        n6.nextNode = n8;

        Node root = merge(h1,h2);
        while (root != null){
            System.out.println(root.data);
            root = root.nextNode;
        }
    }

    private static Node merge(Node h1, Node h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        Node newHead = null;
        if (h1.data > h2.data){
            newHead = h2;
            newHead.nextNode = merge(h1,h2.nextNode);//使用递归求解
        } else {
            newHead = h1;
            newHead.nextNode = merge(h1.nextNode,h2);
        }
        return newHead;
    }
}
