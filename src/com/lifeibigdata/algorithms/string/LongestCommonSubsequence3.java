package com.lifeibigdata.algorithms.string;


/**
 * Created by lifei on 16/5/25.
 */
public class LongestCommonSubsequence3 {


    public static void main(String[] args) {
        LongestCommonSubsequence3 lcs = new LongestCommonSubsequence3();
        System.out.println(lcs.compute("ABCBDAB","BDCABA"));
    }

    public static int compute(char[] str1, char[] str2)
    {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度,默认初始化为0
        int[][] chess = new int[substringLength1 + 1][substringLength2 + 1];

        // 从从前到后，动态规划计算所有子问题。也可从前向后
        for (int i = 1; i <= substringLength1; i++)
        {
            for (int j = 1; j <= substringLength2; j++)
            {
                if (str1[i - 1] == str2[j - 1])
                    chess[i][j] = chess[i - 1][j - 1] + 1;// 状态转移方程
                else
                    chess[i][j] = Math.max(chess[i - 1][j], chess[i][j - 1]);// 状态转移方程
            }
        }
        System.out.println("substring1:" + new String(str1));
        System.out.println("substring2:" + new String(str2));
        System.out.print("LCS:");

        int i = str1.length, j = str2.length;
        String temp = "";
        while (i != 0 && j != 0)
        {
            if (str1[i - 1] == str2[j - 1])
            {
                temp += str1[i - 1];
                i--;
                j--;
            }
            else{
                if (chess[i][j - 1] > chess[i - 1][j])
                    j--;
                else
                    i--;
            }
        }
        for (int k = temp.length() - 1; k >= 0; k--) {
            System.out.print(temp.toCharArray()[k]);
        }
        System.out.println();
        return chess[str1.length][str2.length];
    }

    public int compute(String str1, String str2)
    {
        return compute(str1.toCharArray(), str2.toCharArray());
    }
}


/**
 * 滚动数组只求大小,可以降低空间复杂度,时间复杂度不变
 * 求全部的lcs
 * 求几个lcs
 *
 * 最长递增子序列
 * 最长回文子序列
 *
 * lis
 *
 */
