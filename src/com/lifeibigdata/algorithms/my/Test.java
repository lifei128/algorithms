package com.lifeibigdata.algorithms.my;

import java.util.LinkedList;

/**
 * Created by lifei on 16/10/21.
 */
public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.addLast(2);
        queue1.add(3);
        queue1.add(4);
        for (int x:queue1) {
            System.out.println(x);
        }
        System.out.println(queue1.removeFirst());
        System.out.println(queue1.remove());
    }
}
