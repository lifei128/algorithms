package com.lifeibigdata.algorithms.sort;

import java.util.*;

/**
 * Created by lifei on 16/9/20.
 */
public class WordBreak {

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("下雨天");
        dict.add("留客");
        dict.add("留客天");
        dict.add("天留");
        dict.add("留我不");
        dict.add("我不留");
        dict.add("留");
        String str = "下雨天留客天留我不留";
        List<String> answer = new ArrayList<>();
        wordBreak(dict,str,answer);
    }

    private static void wordBreak(Set<String> dict, String str,List<String>  answer) {
        //chess[i][j]: str[0...i - 1]中,是否可以在第i号元素的前面加break
        boolean[][] chess = new boolean[str.length() + 1][str.length()];
        boolean[] f = new boolean[str.length() + 1];//f[i]: str[0...i - 1]是否在词典中
        f[0] = true;//空串在词典中
        for (int i = 1; i <= str.length(); i++) {//str[0...i-1]:长度为i
            for (int j = i -1; j >= 0 ; j--) {
                if (f[j] && dict.contains(str.substring(j,i))){
                    f[i] = true;
                    chess[i][j] = true;
                }
            }
        }
        Stack oneBreak = new Stack();//一种可行的划分
        findAnswer(chess,str,str.length(),oneBreak,answer);//计算str[0...str.length - 1]的wordbreak有哪些
    }

    private static void findAnswer(boolean[][] chess, String str, int cur, Stack oneBreak, List<String> answer) {
        if (cur == 0){//叶子
            addAnswer(str,oneBreak,answer);
            return;
        }
        for (int i = 0; i < str.length(); i++) {//TODO
            if (chess[cur][i]){//str[i...cur]在词典中
                oneBreak.push(i);
                findAnswer(chess,str,i,oneBreak,answer);
                oneBreak.pop();
            }
        }
    }

    private static void addAnswer(String str, Stack oneBreak, List<String> answer) {
        int start = 0;
        int end = 0;
        String sentence = "";
        for (int i = oneBreak.size() - 2; i >= 0; i--) {//oneBreak[str.length - 1] == 0,特殊处理
            end = (int) oneBreak.get(i);//别忘了,k=oneBreak[i]的值表示再string[k]的前面添加break
            sentence += str.substring(start,end);
            sentence +=" ";
            start = end;
        }
        sentence += str.substring(start,str.length());//最后一个break
        answer.add(sentence);
        System.out.println(sentence);
    }

}
