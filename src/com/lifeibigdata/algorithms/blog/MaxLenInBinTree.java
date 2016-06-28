package com.lifeibigdata.algorithms.blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 16/6/22.
 */
public class MaxLenInBinTree {

    /*
     a.         1
               /  \
              2    3
             / \  / \
            4   5 6  7
        max=4   pass "root"

     b.         1
               /  \
              2    3
             / \
            4   5
           /     \
          6       7
         /         \
        8           9
        max=6. do not pass "root"
     */

    private int maxLen=0;

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7};  //层级遍历
        //store in LevelOrder,Complete Binary Tree. 0==no child
        MaxLenInBinTree m=new MaxLenInBinTree();

        Node aRoot=m.createTree(a);
        m.findMaxLen(aRoot);
        System.out.println(m.maxLen);

        int[] b={1,2,3,4,5,0,0,6,0,0,7,0,0,0,0,8,0,0,0,0,0,0,9};
        Node bRoot=m.createTree(b);
        m.findMaxLen(bRoot);
        System.out.println(m.maxLen);

    }

    public void findMaxLen(Node node){

        if(node==null) return ;

        if(node.getLeft()==null){
            node.setMaxLeftLen(0);
        }
        if(node.getRight()==null){
            node.setMaxRightLen(0);
        }

        if(node.getLeft()!=null){
            findMaxLen(node.getLeft());
        }
        if(node.getRight()!=null){
            findMaxLen(node.getRight());
        }

        if(node.getLeft()!=null){
            int temp=0;
            Node left=node.getLeft();
            if(left.getMaxLeftLen()>left.getMaxRightLen()){
                temp=left.getMaxLeftLen();
            }else{
                temp=left.getMaxRightLen();
            }
            node.setMaxLeftLen(temp+1);
        }
        if(node.getRight()!=null){
            int temp=0;
            Node right=node.getRight();
            if(right.getMaxLeftLen()>right.getMaxRightLen()){
                temp=right.getMaxLeftLen();
            }else{
                temp=right.getMaxRightLen();
            }
            node.setMaxRightLen(temp+1);
        }
        if(maxLen<node.getMaxLeftLen()+node.getMaxRightLen()){
            maxLen=node.getMaxLeftLen()+node.getMaxRightLen();
        }
    }

    public Node createTree(int[] data){
        List<Node> nodeList=new ArrayList<Node>();
        for(int each:data){
            Node n=new Node(each);
            nodeList.add(n);
        }
        int lastRootIndex=data.length/2-1;
        for(int i=0;i<=lastRootIndex;i++){
            Node root=nodeList.get(i);
            Node left=nodeList.get(i*2+1);
            if(left.getData()!=0){
                root.setLeft(left);
            }else{
                root.setLeft(null);
            }
            if(i*2+2<data.length){
                Node right=nodeList.get(i*2+2);
                if(right.getData()!=0){
                    root.setRight(right);
                }else{
                    root.setRight(null);
                }
            }

        }
        Node root=nodeList.get(0);
        return root;
    }
    class Node{
        private int data;
        private Node left;
        private Node right;
        private int maxLeftLen;//the max length of leftTree
        private int maxRightLen;

        public Node(int i){
            data=i;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
            this.left=null;
            this.right=null;
        }
        public Node getLeft() {
            return left;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
        public Node getRight() {
            return right;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public int getMaxLeftLen() {
            return maxLeftLen;
        }
        public void setMaxLeftLen(int maxLeftLen) {
            this.maxLeftLen = maxLeftLen;
        }
        public int getMaxRightLen() {
            return maxRightLen;
        }
        public void setMaxRightLen(int maxRightLen) {
            this.maxRightLen = maxRightLen;
        }
    }
}
