package com.lifeibigdata.algorithms.string;

public class IsPalindrome {
    public static boolean isHuiWen(String text) {
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String text = "abcecba";
        System.out.println(isHuiWen(text));
    }
}
