package com.lifeibigdata.algorithms.sort;

/**
 * Created by lifei on 16/9/20.
 */
public class InterIace {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "accabdbbca";
        System.out.println(isInterIace2(s1.toCharArray(),s2.toCharArray(),s3.toCharArray()));
        System.out.println(isInterIace2(s1.toCharArray(),s2.toCharArray(),s4.toCharArray()));
    }
    static boolean isInterIace(char[] str1,char[]str2,char[] str ){
        int M = str1.length;
        int N = str2.length;
        int S = str.length;
        if (M + N != S)
            return false;
        boolean[][] p = new boolean[M+1][N+1];
        p[0][0] = true;
        for (int i = 1; i <= M; i++) {//首列
            p[i][0] = (p[i - 1][0] && str1[i - 1 ] == str[i - 1]);
        }
        for (int j = 1; j <= N; j++) {//首行
            p[0][j] = (p[0][j - 1] && str2[j - 1] == str[j - 1]);
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                p[i][j] = (p[i - 1][j] && str[i + j - 1] == str1[i - 1])
                        ||
                        (p[i][j - 1] && str[i + j -1] == str2[j -1]);
            }
        }

        return p[M][N];
    }

    static boolean isInterIace2(char[] str1,char[]str2,char[] str ) {
        int M = str1.length;
        int N = str2.length;
        int S = str.length;
        if (M + N != S)
            return false;
        if (M < N)
            return isInterIace2(str2,str1,str);
        boolean[] p = new boolean[N+1];
        p[0] = true;
        for (int i = 1; i <=N ; i++) {
            p[i] = (p[i - 1] && (str2[i -1] == str[i -1]));
        }
        for (int i = 1; i <= M; i++) {
            p[0] = (p[0] && (str1[i - 1] == str[i -1]));
            for (int j = 1; j <= N; j++) {
                p[j] = (p[j] && (str[i +j - 1] == str1[i -1]))
                || (p[j - 1] && (str[i + j - 1] == str2[j - 1]));
            }
        }
        return p[N];
    }
}
