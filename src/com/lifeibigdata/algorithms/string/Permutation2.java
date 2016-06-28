package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/25.
 */
public class Permutation2 {

    public static void permutation(char[] buf, int start, int end) {
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        } else {// 多个字母全排列
            for (int i = start; i <= end; i++) {
                char temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;
                System.out.println(buf[start]+":"+buf[i]);
                permutation(buf, start + 1, end);// 后续元素递归全排列

                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] buf = new char[] { 'a', 'b', 'c','d' };
        permutation(buf, 0, 3);
    }

}
/**
 * 8皇后问题
 *
 * 下排列问题
 *
 * cantor数组
 *
 * trie树
 */
