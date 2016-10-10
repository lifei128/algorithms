package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/26.
 */
public class KMP {

    public static void main(String[] args) {
        //暴力求解
//        System.out.println(bruteForceSearch("abcdefg".toCharArray(),"def".toCharArray()));

        //原始kmp
        int[] next = new int[3];
        getNext2("def".toCharArray(),next);
        System.out.println(kmp("abcdefg".toCharArray(),"def".toCharArray(),next));
    }
    //查找s中首次出现p的位置
    static int bruteForceSearch(char[] s,char[] p){
        int i = 0;//当前匹配到的原始串首位
        int j = 0;//模式串的匹配位置
        int size = p.length;
        int nLast = s.length - size;
        while (i <= nLast && j <size){
            if (s[i + j] == p[j]){//若匹配,则模式串匹配位置后移
                j++;
            } else {//不匹配,则对比下一个位置,模式串回溯到首位
                i++;
                j = 0;
            }
        }
        if (j >= size)
            return i;
        return -1;
    }

    static void getNext(char[] p,int next[]){
        int nLen = p.length;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < nLen - 1){
            //此刻,k即next[j - 1],且p[k]表示前缀,p[j]表示后缀
            //注:k==-1表示未找到k前缀与k后缀相等,首次分析可先忽略
            if (k == -1 || p[j] == p[k]){
                ++j;
                ++k;
                next[j] = k;
            } else {    //p[j]与p[k]失配,则继续递归计算前缀p[next[k]]
                k = next[k];
            }
        }
    }

    static void getNext2(char[] p,int next[]){
        int nLen = p.length;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < nLen - 1){
            //此刻,k即next[j - 1],且p[k]表示前缀,p[j]表示后缀
            //注:k==-1表示未找到k前缀与k后缀相等,首次分析可先忽略
            if (k == -1 || p[j] == p[k]){
                ++j;
                ++k;
//                next[j] = k;
                if (p[j] == p[k]){
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {    //p[j]与p[k]失配,则继续递归计算前缀p[next[k]]
                k = next[k];
            }
        }
    }

    static int kmp(char[] g_s,char[] g_pattern,int[] g_next){
        int ans = -1;
        int i = 0;
        int j = 0;
        int pattern_len = g_pattern.length;
        while (i < g_s.length){
            if (j == -1 || g_s[i] == g_pattern[j]){
                ++i;
                ++j;
            } else {
                j = g_next[j];
            }
            if (j == pattern_len){
                ans = i - pattern_len;
                break;
            }
        }
        return ans;
    }
}
