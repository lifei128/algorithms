package com.lifeibigdata.algorithms.my;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by lifei on 16/9/17.
 */
public class IsTaskable {



    public static void main(String[] args) {
        int N = 2;//任务数目
        int M = 14;//内存数目
        int[] R = new int[]{10,8};
        int[] O = new int[]{5,6};
        boolean b = taskable(N,M,R,O);
        System.out.println(b);
    }

    static boolean taskable(int N, int M, int[] R, int[] O) {
        TagTask[] tt = new TagTask[N];
        TagTask tagTask;
        for (int i = 0; i < N; i++) {
            tagTask = new TagTask();
            tagTask.taskID = i;
            tagTask.RO = R[i] - O[i];
            tt[i] = tagTask;
        }
        Collections.sort(Arrays.asList(tt));
        int occupy = 0;
        boolean bOK = true;
        int k;
        for (int i = 0; i < N; i++) {
            k = tt[i].taskID;
            if (occupy + R[k] > M){
                bOK = false;
                break;
            }
            occupy += O[k];
        }
        return bOK;
    }

}
class TagTask implements Comparable<TagTask>{
    int taskID;
    int RO;

    @Override
    public int compareTo(TagTask o) {
        return o.RO > this.RO ? 1: -1;
    }
}