package com.lifeibigdata.algorithms.linearlist;

/**
 * Created by lifei on 16/5/26.
 */
public class ReverseList {

    public static void main(String[] args) {
        Node head = new Node("a");
        Node node2 = new Node("b");
        Node node3 = new Node("c");
//        Node node4 = new Node("d");
//        Node node5 = new Node("e");

        head.setNext(node2);
        node2.setNext(node3);
//        node3.setNext(node4);
//        node4.setNext(node5);
        System.out.println("翻转前:");
        print(head);
        reverse(head);
        System.out.println("翻转后:");
        head.next = null;
        print(node3);
    }




    private static void reverse(Node head) {
        if (head != null) {
            Node nNode = head.next;
            if (nNode != null) {
                reverse(nNode);
                nNode.next = head;
            }
        }
    }


    /**
     *
     * 递归方式
     * a b c
     * 定义指针节点nNode
     * 第一次nNode指向b,此时head是a
     * 第二次nNode指向c,此时head是b
     * c的next为空,所以结束第二次的reverse,然后开始增加nNode的next指向
     * 从第二次结果可以看出nNode=c,指向b,再从第一次中得到b->a
     *
     *
     *
     * */


//    private static void reverse(Node head) {
//        if(head!=null){
//            Node nextNode=head.getNext();
//            if(nextNode!=null){
//                System.out.println("1:"+head.getValue()+",2:"+nextNode.getValue());
//                reverse(nextNode);
//                nextNode.setNext(head);
//                System.out.println("n:"+nextNode.getValue()+",h:"+head.getValue());
//            }
//        }
//    }



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


