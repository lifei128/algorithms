package com.lifeibigdata.algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lifei on 16/9/21.、
 *
 */
public class Sum100 {
    static int counts;
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8,9};
        List<Pair> op = new ArrayList<>();//某个位置存放的符号
        int count = 0;
        calc(a,0,0,0,op,100);
//        System.out.println(count);
    }

    //考察第cur个空位,当前表达式的值是n,最后一个数是last,操作符放置于op
    private static boolean calc(int[] a, int cur, int n, int last, List<Pair> op,int sum) {
        if (cur == a.length - 1){//递归结束
            last = 10 * last + a[a.length - 1];
            if ((lastOperator(op,cur - 1)?(n + last) : (n - last)) == sum){
                counts++;
//                System.out.println(lastOperator(op,cur - 1));
                print(counts,a,op,a.length);
                return true;
            }
            return false;
        }
        last = 10 * last + a[cur];
        calc(a,cur + 1,n,last,op,sum);//空

        boolean bAdd = lastOperator(op,cur -1);
        op.add(new Pair(cur,'+'));
        calc(a,cur + 1,bAdd ? n + last : n - last,0,op,sum);//'+'

        op.get(op.size() - 1).ch = '-';//TODO ???
        calc(a,cur + 1,bAdd ? n + last : n - last,0,op,sum);//'-'

        op.remove(op.size() - 1);//回溯
        return false;
//        return count != 0;
    }

    private static void print(int count, int[] a, List<Pair> op, int size) {
        Map<Integer,Character> map = new HashMap<>();
        for (Pair p:op) {
            map.put(p.value,p.ch);
        }
        String s = "";
        for (int i = 0; i < a.length; i++) {
            if (map.get(i) != null){
                s += (a[i]+" "+String.valueOf(map.get(i))+" ");
            } else {
                s += a[i];
            }
        }
        System.out.println(count+"===>"+s);
    }

    private static boolean lastOperator(List<Pair> op, int i) {
        if (op.size() == 0)
            return true;//TODO 同下
        for (Pair p:op) {
            if (p.value == i){
                if (p.ch == '+'){
                    return true;
                } else if (p.ch == '-'){
                    return false;
                }
            }
        }
        return op.get(op.size() - 1).ch == '+'?true:false; //TODO 如果找不到i,则返回最后一个符号
    }

    static class Pair{
        int value;
        char ch;

        public Pair(int value, char ch) {
            this.value = value;
            this.ch = ch;
        }
    }
}
