package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/25.
 *
 *
 */
public class Permutation2 {

    /**
     * /**
     全排列算法原理和实现
     全排列是将一组数按一定顺序进行排列，如果这组数有n个，那么全排列数为n!个。现以{1, 2, 3, 4, 5}为例说明如何编写全排列的递归算法。


     1、首先看最后两个数4, 5。 它们的全排列为4 5和5 4, 即以4开头的5的全排列和以5开头的4的全排列。

     由于一个数的全排列就是其本身，从而得到以上结果。

     2、再看后三个数3, 4, 5。它们的全排列为3 4 5、3 5 4、 4 3 5、 4 5 3、 5 3 4、 5 4 3 六组数。

     即以3开头的和4,5的全排列的组合、以4开头的和3,5的全排列的组合和以5开头的和3,4的全排列的组合.

     从而可以推断，设一组数p = {r1, r2, r3, ... ,rn}, 全排列为perm(p)，pn = p - {rn}。

     因此perm(p) = r1perm(p1), r2perm(p2), r3perm(p3), ... , rnperm(pn)。当n = 1时perm(p} = r1。

     为了更容易理解，将整组数中的所有的数分别与第一个数交换，这样就总是在处理后n-1个数的全排列。

     * @param buf
     * @param start
     * @param end
     */
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

                permutation(buf, start + 1, end);// 后续元素递归全排列

                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

    public static void permutation2(char[] buf, int start, int end) {
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        } else {// 多个字母全排列
            for (int i = start; i <= end; i++) {
                if (isSwap(buf,start,i)){
                    char temp = buf[start];// 交换数组第一个元素与后续的元素
                    buf[start] = buf[i];
                    buf[i] = temp;

                    permutation2(buf, start + 1, end);// 后续元素递归全排列

                    temp = buf[start];// 将交换后的数组还原
                    buf[start] = buf[i];
                    buf[i] = temp;
                }
            }
        }
    }

    public static void permutation3(char[] buf, int start, int end) {
        if (start == end) {// 当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        } else {// 多个字母全排列
            int dup[] = new int[256];//256根据所需配置
            for (int i = start; i <= end; i++) {
                if (dup[buf[i]] == 1)
                    continue;
                dup[buf[i]] = 1;
                char temp = buf[start];// 交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;

                permutation2(buf, start + 1, end);// 后续元素递归全排列

                temp = buf[start];// 将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }
    }

    static boolean isSwap(char[] a,int begin, int end){
        for (int i = end; i >begin ; i--) {
            if (a[end] == a[i - 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] buf = new char[] { 'a', 'b', 'b' };
        permutation(buf, 0, 2);//不能解决重复元素全排列
        System.out.println("====================");
        permutation2(buf, 0, 2);//可以解决重复元素全排列
        System.out.println("====================");
        permutation3(buf, 0, 2);//可以解决重复元素全排列
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

