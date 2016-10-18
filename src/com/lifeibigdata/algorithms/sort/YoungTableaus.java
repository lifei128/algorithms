package com.lifeibigdata.algorithms.sort;

import java.util.Random;

/**
 * Created by lifei on 16/9/18.
 */
public class YoungTableaus {

    int m_nRow;
    int m_nCol;
    int[][] m_pData;

    public YoungTableaus(int m_nRow, int m_nCol) {
        init(m_nRow,m_nCol);
    }

    private void init(int m_nRow, int m_nCol) {
        this.m_nRow = m_nRow;
        this.m_nCol = m_nCol;
        m_pData = new int[m_nRow][m_nCol];
        for (int i = 0; i < m_pData.length; i++) {
            for (int j = 0; j < m_pData[i].length; j++) {
                m_pData[i][j] = Integer.MAX_VALUE;
            }

        }
    }

    boolean insert(int x){
        int row = m_nRow - 1;
        int col = m_nCol - 1;
        if (m_pData[row][col] < Integer.MAX_VALUE){
            return false;//此处也可以新建一个更大的矩阵,将小的矩阵拷贝到大矩阵中,从而继续添加
        }
        m_pData[row][col] = x;
        int r = row;
        int c = col;
        while (row >= 0 || col >=0){
            if (row >= 1 && m_pData[row - 1][col] >m_pData[r][c]){//向上移动
                r = row - 1;
                c = col;
            }
            if (col >= 1 && m_pData[row][col - 1] > m_pData[r][c]){//向左移动
                r = row;
                c = col - 1;
            }
            if (r == row && c == col)
                break;
            swap(row,col,r,c);
            row = r;
            col = c;
        }
        return true;
    }
    boolean insert2(int x){
        int row = m_nRow - 1;
        int col = m_nCol - 1;
        if (m_pData[row][col] < Integer.MAX_VALUE){
            return false;//此处也可以新建一个更大的矩阵,将小的矩阵拷贝到大矩阵中,从而继续添加
        }
        m_pData[row][col] = x;
        int r = row;
        int c = col;
        while (row >= 0 || col >=0){
            if (row >= 1 && m_pData[row - 1][col] >m_pData[r][c]){//向上移动
                r = row - 1;
                c = col;
            }
            if (col >= 1 && isBig(m_pData[row][col - 1] , m_pData[r][c])){//向左移动
                r = row;
                c = col - 1;
            }
            if (r == row && c == col)
                break;
            swap(row,col,r,c);
            row = r;
            col = c;
        }
        return true;
    }

    private boolean isBig(int a, int b) {
        if (new Random().nextInt(5) % 2 == 0){//TODO 随机正整数
            return a >= b;
        }
        return a > b;
    }

    private void swap(int row, int col, int i, int i1) {
        int tmp = m_pData[row][col];
        m_pData[row][col] = m_pData[i][i1];
        m_pData[i][i1] = tmp;
    }

    void print(){
        for (int i = 0; i < m_pData.length; i++) {
            for (int j = 0; j < m_pData[i].length; j++) {
                System.out.print(m_pData[i][j]+",");
            }
            System.out.println();
        }
    }

    boolean find(int x){
        int row = 0;
        int col = m_nCol - 1;
        while (row < m_nRow &&  col >= 0){
            if (m_pData[row][col] == x)
                return true;
            if (x > m_pData[row][col]){
                row++;
            } else {
                col--;
            }

        }
        return false;
    }


    boolean find2(int x){
        int m = m_pData.length,n = m_pData[0].length;
        return find2(m_pData,0,0,m - 1,n - 1,x);
    }

    private boolean find(int[][] a, int x1, int y1, int x2, int y2, int target) {
        if (x1 > x2 || y1 > y2)
            return false;
        int midx = (x1 + x2) >> 1;
        int midy = (y1 + y2) >> 1;
        if (a[midx][midy] == target)
            return true;
        return (target < a[midx][midy])?
                (find(a,x1,y1,midx - 1,y2,target) || find(a,midx,y1,x2,midy - 1,target)):
                (find(a,x1,midy + 1,x2,y2,target) || find(a,midx + 1,y1,x2,midy,target));
    }

    private boolean find2(int[][] a, int x1, int y1, int x2, int y2, int target) {
        if (x1 > x2 || y1 > y2)
            return false;
        int midx = (x1 + x2) >> 1;
        int indy = help(a[midx],y1,y2,target);
        if (indy >= y1 && a[midx][indy] == target)
            return true;
        return find2(a,x1,indy + 1,midx - 1,y2,target) ||
                find2(a,midx + 1,y1,x2,indy,target);
    }

    private int help(int[] a, int y1, int y2, int target) {//last <= target
        int left = y1,right = y2;
        while (left <= right){
            int mid = (right + left) >> 1;
            if (a[mid] <= target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    void delete(int row,int col){
        int r = row;
        int c = col;
        while (row < m_nRow && col < m_nCol){
            if (m_pData[row][col] == Integer.MAX_VALUE)
                break;
            if (row + 1 <m_nRow){
                r = row + 1;
                c = col;
            }
            if (col + 1 <m_nCol && m_pData[row][col + 1] <m_pData[r][c]){
                r = row;
                c = col + 1;
            }
            if (row == r && col == c)
                break;
            m_pData[row][col] = m_pData[r][c];
            row = r;
            col = c;
        }
        m_pData[m_nRow - 1][m_nCol -1] = Integer.MAX_VALUE;
    }
    public static void main(String[] args) {
        YoungTableaus yt = new YoungTableaus(5,4);
        yt.insert(41);
        yt.insert(67);
        yt.insert(34);
        yt.insert(0);
        yt.insert(69);
        yt.print();
        yt.delete(0,0);
        yt.print();
        System.out.println(yt.find2(41));
    }

}
