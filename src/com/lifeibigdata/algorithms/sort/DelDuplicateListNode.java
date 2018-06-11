package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/9/22.
 */
public class DelDuplicateListNode {
    static class tagSNode{
        int value;
        tagSNode pNext;

        public tagSNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        tagSNode pHead = new tagSNode(0);
        int data[] = new int[]{2,3,5,7,8,8,8,9,9,30};
        for (int i = data.length - 1; i >=0; i--) {
            tagSNode p = new tagSNode(data[i]);
            p.pNext = pHead.pNext;
            pHead.pNext = p;
        }
        print(pHead);
        delDuplicate(pHead);
//        delDuplicate2(pHead);
//        delDuplicate3(pHead);
        print(pHead);
    }

    private static void delDuplicate(tagSNode pHead) {//TODO
        tagSNode pPre = pHead.pNext;
        tagSNode pCur;
        while (pPre != null){
            pCur = pPre.pNext;
            if (pCur != null && pCur.value == pPre.value){
                pPre.pNext = pCur.pNext;
            } else {
//                pPre.pNext = pCur;//todo 因为链表默认有这一层关系
                pPre = pCur;
            }
        }
    }

    private static void delDuplicate2(tagSNode pHead) {//TODO
        tagSNode pPre = pHead;
        tagSNode pCur = pPre.pNext;
        tagSNode pNext;
        while (pCur != null){
            pNext = pCur.pNext;
            while (pNext != null && pCur.value == pNext.value){//todo
                pPre.pNext = pNext;
                pCur = pNext;
                pNext = pCur.pNext;//=> pNext = pNext.pNext;
            }
            pPre = pCur;


            pCur = pNext;
        }
    }

    private static void delDuplicate3(tagSNode pHead) {//TODO
        tagSNode pPre = pHead;
        tagSNode pCur = pPre.pNext;
        tagSNode pNext;
        boolean bDup;
        while (pCur != null){
            pNext = pCur.pNext;
            bDup = false;//TODO
            while (pNext != null && pCur.value == pNext.value){
                pPre.pNext = pNext;

                pCur = pNext;

//                pNext = pCur.pNext;//todo 也可以
                pNext = pNext.pNext;

                bDup = true;
            }
            if (bDup){//此刻的pCurl与原数据重复,删之
                pPre.pNext = pNext;
            } else {//pCurl未发现重复,则pPre后移
                pPre = pCur;
            }
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
