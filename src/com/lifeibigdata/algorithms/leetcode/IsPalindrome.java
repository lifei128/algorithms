package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/6/28.
 *
 * 从两头依次取数字比较，向中间推进。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome(1221));

    }
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        //calcu the length of digit
        int len = 1;
        while (x / len >= 10) {   //得到最大的除数
            len *= 10;
        }
        while (x != 0) {
            int left = x / len;
            int right = x % 10;

            if (left != right)
                return false;
            //remove the head and tail digit
            x = (x % len) / 10;    //把余数作为下一次遍历对象   x%len去掉高位,  再 /10去低位
            len /= 100;            //减少len的步长
        }
        return true;
    }
}
