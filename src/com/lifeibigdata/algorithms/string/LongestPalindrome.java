package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/10/8.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("12212321"));
    }

    //  https://segmentfault.com/a/1190000003914228
    public static int longestPalindrome(String s) {
        int n=s.length();
        boolean[][] pal=new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        int maxLen=0;
        for (int i=0;i<n;i++){  // i作为终点
            int j=i;    //j作为起点
            while (j>=0){
                if (s.charAt(j)==s.charAt(i)&&(i-j<2||pal[j+1][i-1])){
                    pal[j][i]=true;
                    maxLen=Math.max(maxLen, i-j+1);
                }
                j--;
            }
        }
        return maxLen;
    }
}
