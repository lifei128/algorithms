package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/25.
 */
public class LongestCommonSubsequence2 {


    public static void main(String[] args) {
        LongestCommonSubsequence2 lcs = new LongestCommonSubsequence2();
        System.out.println(lcs.compute("ABCBDAB","BDCABA"));
    }

    public static int compute(char[] str1, char[] str2)
    {
        int substringLength1 = str1.length;
        int substringLength2 = str2.length;

        // 构造二维数组记录子问题A[i]和B[j]的LCS的长度
        int[][] opt = new int[substringLength1 + 1][substringLength2 + 1];

        // 从后向前，动态规划计算所有子问题。也可从前到后。
        for (int i = substringLength1 - 1; i >= 0; i--)
        {
            for (int j = substringLength2 - 1; j >= 0; j--)
            {
                if (str1[i] == str2[j])
                    opt[i][j] = opt[i + 1][j + 1] + 1;// 状态转移方程
                else
                    opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);// 状态转移方程
            }
        }
        System.out.println("substring1:" + new String(str1));
        System.out.println("substring2:" + new String(str2));
        System.out.print("LCS:");

        int i = 0, j = 0;
        while (i < substringLength1 && j < substringLength2)
        {
            if (str1[i] == str2[j])
            {
                System.out.print(str1[i]);
                i++;
                j++;
            }
            else if (opt[i + 1][j] >= opt[i][j + 1])
                i++;
            else
                j++;
        }
        System.out.println();
        return opt[0][0];
    }

    public int compute(String str1, String str2)
    {
        return compute(str1.toCharArray(), str2.toCharArray());
    }
}


/**
 * 滚动数组只求大小
 * 求全部的lcs
 * 求几个lcs
 *
 * 最长递增子序列
 * 最长回文子序列
 *
 */
