package com.lifeibigdata.algorithms.my;

import java.util.Scanner;

/**
 * Created by lifei on 16/5/24.
 */
public class CheckPrime {


    static boolean isCheck(int x){
        for (int i = 2; i < x; i++){
//        for (int i = 2; i <= Math.sqrt(x); i++){
            if (x % 2 == 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(isCheck(x));
    }
}
/**
 * 2是素数,1不是素数
 *
 * 排除异常树
 * if(n < 2) return false;
 *
 * 偶数一定不适素数
 * if(n%2==0) return false;
 *
 * 定理: 如果n不是素数, 则n有满足1< d<=sqrt(n)的一个因子d.
 　证明: 如果n不是素数, 则由定义n有一个因子d满足1< d< n.
 　如果d大于sqrt(n), 则n/d是满足1< n/d<=sqrt(n)的一个因子.

   sqrt()是开方,开方的两个数是相等的,4*4=14,如果一个数大约平方根,那么另一个数一定小于平方根,才能满足二者的乘积等于两个平方根的积


 1、素数及相关

 素数，又称质数，在一个大于1的自然数中，除了1和此整数自身之外，不能被其他自然数整除的数。
 比1大但不是素数的数称为合数。
 1和0既不是素数，也不是合数。
 算术基本定理证明每个大于1的正整数都可以写成素数的乘积，并且这种乘积的形式是唯一的。


 */