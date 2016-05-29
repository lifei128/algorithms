package com.lifeibigdata.algorithms.linearlist;

/**
 * Created by lifei on 16/5/26.
 */
public class ReverseList2 {

    public static void main(String[] args) {
        Node head = new Node("a");
        Node node2 = new Node("b");
        Node node3 = new Node("c");
        head.setNext(node2);
        node2.setNext(node3);
        System.out.println("翻转前:");
        print(head);

        Node pre = reverse(head);

        System.out.println("翻转后:");
        print(pre);

    }

    static Node reverse(Node current) {
        //initialization
        Node previousNode = null;
        Node nextNode = null;

        while (current != null) {
            //save the next node
            nextNode = current.next;
            //update the value of "next"
            current.next = previousNode;
            //shift the pointers
            previousNode = current;
            current = nextNode;
        }
        return previousNode;
    }



    static void print(Node node){
        while (node != null){
            System.out.print(node.getValue() + "\t");
            if (node.getNext() != null) {
                node = node.getNext();
            } else {
                System.out.println();
                return;
            }
        }
    }


    static class Node{
        Node next;
        String value;

        public Node(String value){
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
