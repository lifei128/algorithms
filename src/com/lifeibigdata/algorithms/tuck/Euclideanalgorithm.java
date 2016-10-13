package com.lifeibigdata.algorithms.tuck;

/**
 * Created by lifei on 16/10/12.
 *
 * 辗转相除法， 又名欧几里德算法（Euclidean algorithm）乃求两个正整数之最大公因子的算法。它是已知最古老的算法， 其可追溯至3000年前。
 　　设两数为a、b(a>b)，求a和b最大公约数(a，b)的步骤如下：用a除以b，得a÷b=q......r1(0≤r1)。若r1=0，则(a，b)=b；若r1≠0，则再用b除以r1，得b÷r1=q......r2 (0≤r2）.若r2=0，则(a，b)=r1，若r2≠0，则继续用r1除以r2，……如此下去，直到能整除为止。其最后一个为被除数的余数的除数即为(a, b)。
 　　例如：a=25,b=15，a/b=1......10,b/10=1......5,10/5=2.......0,最后一个为被除数余数的除数就是5,5就是所求最大公约数。
 */
public class Euclideanalgorithm {

    public static void main(String[] args) {
        System.out.println(gcd(25,15));  //7,2
    }

    public static int gcd(int a,int b){
        while (b != 0){
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
