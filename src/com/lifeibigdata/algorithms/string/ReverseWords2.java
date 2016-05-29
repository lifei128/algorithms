package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/25.
 */
public class ReverseWords2 {

    static char[] chars;

    public ReverseWords2(String word) {
        this.chars = word.toCharArray();
    }

    void reverseWord(){
        int begin = 0;
        int end = 0;
        for (int i = 0; i<chars.length;i++){
            if (begin == -1 && chars[i] == ' '){
                continue;
            }
            if (begin == -1){
                begin = i;
                continue;
            }
            if (chars[i] == ' '){
                end = i - 1;
            } else if (i == chars.length -1){
                end = i;
            } else {
                continue;
            }
            reverse(begin,end);
            begin = -1;
            end = -1;
        }
        reverse(0,chars.length-1);
    }

    private void reverse(int start, int end) {
        while (start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        ReverseWords2 rw2 = new ReverseWords2("I love you");
        rw2.reverseWord();
        System.out.println(String.valueOf(chars));
    }
}
