package com.lifeibigdata.algorithms.leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by lifei on 16/5/30.
 * leetcode no.4
 *
 * 递归思想
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> list = gp.generateParenthesis(2);
        for (String str:list) {
            System.out.println(str);
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
//        dfs(result, "", n, n);
//        help(n,0,0,"",result);
        help(n,result);
        return result;
    }

    //BFS
    //c++ http://blog.csdn.net/zhy_cheng/article/details/8090346
    //java http://www.cnblogs.com/end/archive/2012/10/25/2738493.html
    private void help(int n, ArrayList<String> answer) {
        if (n == 0){
            answer.add("");
            return;
        }
        node temp = new node();
        Queue<node> q = new ArrayDeque<>();
        for (q.add(temp);!q.isEmpty();q.poll()) {
            temp = q.peek();
            node other;
            if (temp.x < n){
                other = new node();//TODO
                other.x = temp.x + 1;
                other.y = temp.y;
                other.now = temp.now + "(";
                q.offer(other);
            }
            if (temp.x > temp.y){
                other = new node();//TODO
                other.x = temp.x;
                other.y = temp.y + 1;
                other.now = temp.now + ")";
                if (other.y == n){
                    answer.add(other.now);
                } else {
                    q.offer(other);
                }
            }
        }
    }

    //DFS
    private void help(int n, int x, int y, String now, ArrayList<String> answer) {
        if (y == n){
            answer.add(now);
            return;
        }
        if (x < n){
            help(n,x + 1,y,now+"(",answer);
        }
        if (x > y){
            help(n,x,y + 1,now+")",answer);
        }
    }

    /*
    left and right represents the remaining number of ( and ) that need to be added.
    When left > right, there are more ")" placed than "(". Such cases are wrong and the method stops.
    */
    public void dfs(ArrayList<String> result, String s, int left, int right){
        if(left > right)         //阻止)开始的情况,必须是left减一开始
            return;

        if(left==0&&right==0){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(", left-1, right);          //
        }

        if(right>0){
            dfs(result, s+")", left, right-1);
        }
    }
}

class node{
    int x,y;
    String now = "";
}
