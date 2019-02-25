package offer;

/**
 * Created by lifei on 2017/3/26.
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个节点的值。
 *
 * 思路:通常打印是一个只读操作，我们不希望打印时修改内容。假设面试官也要求这个题目不能改变链表的结构。
 接下来我们想到解决这个问题肯定要遍历链表。遍历的顺序是从头到尾的顺序，可输出的顺序却是从尾到头。也就是说第一个遍历的节点最后一个输出，
 而最后一个遍历到的节点第一个输出。这就是典型的'后进先出“，我们可以从栈实现这种顺序。没经过一个节点的时候，把该节点放到一个栈中。
 当遍历完整的链表后，再从栈顶开始逐个输出节点的值，此时输出的节点的顺序已经反转过来了。
 既然想到了用栈来实现这个函数，而递归在本身上就是一个栈结构，于是自然就想到了用递归来实现。
 要实现反过来输出链表，我们每访问到一个节点的时候，先递归输出后面的节点，再输出该节点本身，这样链表的输出结果就反过来了。
 *
 * 栈和递归之间的关系
 */
public class Of5 {
    static class Node{
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.nextNode = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;
        reverseRec(head);
    }

    private static void reverseRec(Node head) {
        if (head != null){
            if (head.nextNode != null){
                reverseRec(head.nextNode);//todo 此处是递归,一直在嵌套
            }
            System.out.println(head.data);
        } else {
            System.out.println("list is null!");
        }
    }
}
