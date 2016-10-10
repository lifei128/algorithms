package com.lifeibigdata.algorithms.linearlist;

/**
 * Created by lifei on 16/9/22.
 */
public class FindFirstSameNode {
    static class tagSNode{
        int value;
        tagSNode pNext;

        public tagSNode(int value) {
            this.value = value;
        }
    }

    private static void print(tagSNode pHead) {
        while (pHead != null){
            System.out.print(pHead.value+",");
            pHead = pHead.pNext;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        tagSNode pA = new tagSNode(0);
        tagSNode pB = new tagSNode(7);

        tagSNode p1 = new tagSNode(1);
        tagSNode p2 = new tagSNode(2);
        tagSNode p3 = new tagSNode(3);

        tagSNode p4 = new tagSNode(6);
//        tagSNode p5 = new tagSNode(3)3;
//        tagSNode p6 = new tagSNode(4);

        pA.pNext = p1;
        p1.pNext = p2;
        p2.pNext = p3;

        pB.pNext = p4;
        p4.pNext = p3;

        tagSNode same = getFirstSameNode(pA,pB);
        System.out.println(same.value);
    }

    private static tagSNode getFirstSameNode(tagSNode pA, tagSNode pB) {
        //因为有头指针,所以指向第一个有效节点
//        pA = pA.pNext;
//        pB = pB.pNext;

        //计算两个链表的长度
        int nA = calcLength(pA);
        int nB = calcLength(pB);
        if (nA > nB){
            int tmp = nA;
            nA = nB;
            nB = tmp;

            tagSNode tagSNode = pA;
            pA = pB;
            pB = tagSNode;
        }
        //空转nB-nA次
        for (int i = 0; i < nB - nA; i++) {
            pB = pB.pNext;
        }
        //齐头并进
        while (pA != null){
            if (pA.value == pB.value)return pA;
            pA = pA.pNext;
            pB = pB.pNext;
        }
        return null;
    }

//    private static void swap(int nA, int nB) {
//        int tmp = nA;
//        nA = nB;
//        nB = tmp;
//    }

    private static void swap(tagSNode pA, tagSNode pB) {
        tagSNode tmp = pA;
        pA = pB;
        pB = pA;
    }

    private static int calcLength(tagSNode p) {
        int nLen = 0;
        while (p != null){
            p = p.pNext;
            nLen++;
        }
        return nLen;
    }
}
