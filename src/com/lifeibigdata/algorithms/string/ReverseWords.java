package com.lifeibigdata.algorithms.string;

import com.sun.deploy.util.StringUtils;

/**
 * Created by lifei on 16/5/25.
 *
 *
 I am a student 中国
 中国 student a am I

 先将每个单词反转，再将整体字符串反转
 或者
 先将整体字符串反转,再每个单词反转
 */
public class ReverseWords {

    static String word;

    public ReverseWords(String word) {
        this.word = word;
    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords("I love you");
//        ReverseWords rw = new ReverseWords("I am a student 中国");
        System.out.println(word);
        rw.reverseWords();
        System.out.println(word);


    }

    private void reverseWords() {
        int length = word.length();
        int begin = -1;
        int end = -1;
        for (int i = 0; i < length; i++){
            if (begin == -1 && word.charAt(i) == ' '){
                continue;
            }
            if (begin == -1){
                begin = i;
                continue;
            }
            if (word.charAt(i) == ' '){
                end = i - 1;
            } else if (i == length -1){
                end = i;
            } else {
                continue;
            }
            reverse(begin,end);
            begin = -1;
            end = -1;
        }
        reverse(0,length-1);
    }

    private void reverse(int begin, int end) {
        char[] tmp = word.toCharArray();
        while (begin < end){
            tmp[begin] ^= tmp[end];
            tmp[end] ^= tmp[begin];
            tmp[begin] ^= tmp[end];
            begin++;
            end--;
        }
        word = String.copyValueOf(tmp);
    }
}
