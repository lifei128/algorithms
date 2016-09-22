package com.lifeibigdata.algorithms.sort;

import java.util.Random;

/**
 * Created by lifei on 16/9/19.
 */
public class ListPartition {
    static class tagSNode{
        int value;
        tagSNode pNext;

        public tagSNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        tagSNode pHead = new tagSNode(0);
        for (int i = 0; i < 10; i++) {
            tagSNode p = new tagSNode(new Random().nextInt(100));
            p.pNext = pHead.pNext;//头插法
            pHead.pNext = p;
        }
        print(pHead);
//        partition(pHead,50);//  将list分为50之前和50之后两部分
        Reverse(pHead,1,2);//翻转链表的部分
        print(pHead);
    }

    private static void partition(tagSNode pHead, int pivotKey) {
        //两个链表的指针
        tagSNode pLeftHead = new tagSNode(0);
        tagSNode pRightHead = new tagSNode(0);

        //两个链表的当前最后一个元素
        tagSNode left = pLeftHead;
        tagSNode right = pRightHead;
        tagSNode p = pHead.pNext;
        while (p != null){//遍历原链表
            if (p.value < pivotKey){
                left.pNext = p;//头插法
                left = p;
            } else {
                right.pNext = p;//头插法
                right = p;
            }
            p = p.pNext;
        }
        //将right链接到left尾部
        left.pNext = pRightHead.pNext;
        right.pNext = null;
        //将整理好的链表赋值给当前的链表头部
        pHead.pNext = pLeftHead.pNext;
    }

    static void Reverse(tagSNode pHead,int from,int to){
        tagSNode pCur = pHead.pNext;
        int i ;
        for (i = 0; i < from - 1; i++) {
            pHead = pCur;
            pCur = pCur.pNext;
        }
        tagSNode pPre = pCur;
        pCur = pCur.pNext;
        to--;
        tagSNode pNext;
        for (; i < to; i++) {
            pNext = pCur.pNext;
            pCur.pNext = pHead.pNext;
            pHead.pNext = pCur;
            pPre.pNext = pNext;
            pCur = pNext;
        }

    }
    private static void print(tagSNode pHead) {
        while (pHead != null){
            System.out.print(pHead.value+",");
            pHead = pHead.pNext;
        }
        System.out.println();
    }


}
