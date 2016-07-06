package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/27.
 */
public class Utils {

    static void print(ListNode node){
        while (node != null){
            System.out.print(node.val + "->");
            if (node.next != null) {
                node = node.next;
            } else {
                System.out.println();
                return;
            }
        }
    }
}
