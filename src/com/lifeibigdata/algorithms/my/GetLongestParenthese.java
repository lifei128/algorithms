package com.lifeibigdata.algorithms.my;

import java.util.Stack;

/**
 * Created by lifei on 16/9/23.
 */
public class GetLongestParenthese {

    public static void main(String[] args) {
        System.out.println(getLongestParenthese("()()".toCharArray()));
    }

    static int getLongestParenthese(char[] p){
        Stack<Integer> s = new Stack<Integer>();
        int answer = 0;
        int start = -1;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == '('){
                s.push(i);  //todo 如果为左括号,压栈;存储的是索引值
            } else {        //p[i] == ')';它一定与栈顶的左括号匹配
                if (s.empty()){//做若栈为空,表示没有匹配的左括号,start=i,为下一次可能的匹配做准备
                    start = i;
                } else {//如果栈不为空,出栈(因为和')'匹配了)
                    s.pop();
                    if (s.empty()){//如果栈为空,i-start即为当前找到的匹配长度,检查i-start是不比answer更大,使answer更新
                        answer = Math.max(answer,i - start);
                    } else {//如果栈不为空,则当前栈顶元素t是上次匹配的最后位置,检查i-s.pop()是否更大,是answer更新
                        answer = Math.max(answer,i - s.pop());
                    }
                }
            }
        }
        return answer;
    }

    static int getLongestParentthese2(char[] p) {
        int answer = 0;//最终解
        int deep = 0;//遇到了多少左括号
        int start = -1;//最深的(deep==0时)左括号的位置,其实,为了方便计算长度,该变量是最深左括号的前一个位置
        for (int i = 0; i < p.length; i++) {
            if (p[i] == '('){
                deep++;
            } else {        //p[i] == ')'
                deep--;
                if (deep == 0){
                    answer = Math.max(answer,i - start);
                } else if (deep < 0){       //说明右括号数目大于左括号,初始化为for循环前
                    deep = 0;
                    start = i;
                }
            }
        }


        deep = 0;       //遇到了多少右括号
        start = p.length;   ////最深的(deep==0时)右括号的位置,其实,为了方便计算长度,该变量是最深右括号的前一个位置
        for (int i = p.length - 1; i >= 0; i--) {
            if (p[i] == ')'){
                deep++;
            } else {        //p[i] == '('
                deep--;
                if (deep == 0){
                    answer = Math.max(answer,start - 1);
                } else if (deep < 0){       //说明右括号数目大于左括号,初始化为for循环前
                    deep = 0;
                    start = i;
                }
            }
        }
        return answer;
    }
}
