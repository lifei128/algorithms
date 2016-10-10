package com.lifeibigdata.algorithms.my;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by lifei on 16/9/23.
 */
public class Topologic {


    public static void main(String[] args) {
        int[] toposort = {};
        topologic(toposort);
    }

    private static void topologic(int[] toposort) {
        int cnt = 0;
        Queue<Integer> q = new ArrayBlockingQueue<Integer>(toposort.length);
        int[][] graph = new int[toposort.length][toposort.length];
        int[] indegree = new int[toposort.length];
        for (int i = 0; i < toposort.length; i++) {
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        int cur;
        while (!q.isEmpty()){
            cur = q.poll();
            toposort[cur++] = cur;
            for (int i = 0; i < toposort.length; i++) {
                if (graph[cur][i] != 0){
                    indegree[i]--;
                    if (indegree[i] == 0){
                        q.add(i);
                    }
                }
            }
        }
    }
}
