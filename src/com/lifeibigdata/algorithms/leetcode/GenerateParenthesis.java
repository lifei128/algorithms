package com.lifeibigdata.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifei on 16/5/30.
 *
 * 递归思想
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> list = gp.generateParenthesis(1);
        for (String str:list) {
            System.out.println(str);
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        dfs(result, "", n, n);
        return result;
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
