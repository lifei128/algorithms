package com.lifeibigdata.algorithms.leetcode;

import java.util.Arrays;

/**
 *
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 *
   P   A   H   N
   A P L S I I G
   Y   I   R

 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("PAYPALISHIRING",3));;
    }
    public String convert(String s, int nRows) {
        int len = s.length();
        if (len == 0 || nRows <= 1) return s;

        String[] ans = new String[nRows];//使用n行的数组存储结果
        Arrays.fill(ans, "");
        int row = 0, delta = 1;
        for (int i = 0; i < len; i++) {
            ans[row] += s.charAt(i);
//            System.out.println("row:"+row+",ans["+row+"]:"+ans[row]+",i:"+i);
            row += delta;
//            System.out.println("^^^"+row);
            if (row >= nRows) {
                row = nRows-2;  //最底层的上一层
                delta = -1;     //到达最底层之后,逐级递升
//                System.out.println("---"+row+","+i+"---");
            }
            if (row < 0) {
                row = 1;        //第二层
                delta = 1;      //逐级深入下一层
//                System.out.println("***"+"1,"+i+"***");
            }
        }
        String ret = "";
        for (int i = 0; i < nRows; i++) {
            ret += ans[i];
        }
        return ret;
    }

    /**
     * 发现所有行的重复周期都是 2 * nRows - 2            如果n为3    0 2 4
     * 对于首行和末行之间的行，还会额外重复一次，重复的这一次距离本周期起始字符的距离是 2 * nRows - 2 - 2 * i
     */
//    public String convert(String s, int nRows) {
//        int len = s.length();
//        if (len == 0 || nRows < 2) return s;
//
//        String ret = "";
//        int lag = 2*nRows - 2; //循环周期
//        for (int i = 0; i < nRows; i++) {
//            for (int j = i; j < len; j += lag) {
//                System.out.println("j:"+j);
//                ret += s.charAt(j);
//                //非首行和末行时还要加一个
//                if (i > 0 && i < nRows-1) {  //
//                    int t = j + lag - 2*i;
//                    if (t < len) {
//                        System.out.println("t:"+t);
//                        ret += s.charAt(t);
//                    }
//                }
//            }
//        }
//        return ret;
//    }
}

