package com.lifeibigdata.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by lifei on 16/10/17.
 */
public class NumIslands {

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                { '1','0','0','1','1'},
                { '1','0','0','0','0'},
                { '1','0','0','1','1'},
                { '1','0','0','1','1'}
        }));
    }
    static int numIslands(char[][] grid){
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    helper2(grid,i,j);
                    ++answer;
                }
            }
        }
        return answer;
    }

    static void helper(char[][] a, int x, int y) {
        if (x < 0 || x >= a.length || y < 0 || y >= a[x].length || a[x][y] != '1'){
            return;
        }
        a[x][y] = '0';
        helper(a,x - 1,y);
        helper(a,x + 1,y);
        helper(a,x,y - 1);
        helper(a,x,y + 1);
    }

    static void helper2(char[][] a, int x, int y) {
        Queue<pair> q = new ArrayDeque<>();
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        a[x][y] = '0';
        for (q.add(new pair(x,y));!q.isEmpty();q.poll()) {
            x = q.peek().x;
            y = q.peek().y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < a.length && ny >=0 &&
                        ny < a[nx].length && a[nx][ny] == '1'){
                    a[nx][ny] = '0';
                    q.add(new pair(nx,ny));
                }
            }
        }
    }

    static class pair{
        int x,y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
