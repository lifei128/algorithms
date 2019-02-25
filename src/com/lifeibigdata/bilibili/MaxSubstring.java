package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/27.
 */
public class MaxSubstring {
    // 求解两个字符号的最长公共子串
    public static String maxSubstring2(String strOne, String strTwo){
        // 参数检查
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
        // 二者中较长的字符串
        String max = "";
        // 二者中较短的字符串
        String min = "";
        if(strOne.length() < strTwo.length()){
            max = strTwo;
            min = strOne;
        } else{
            max = strTwo;
            min = strOne;
        }
        String current = "";
        // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
        for(int i=0; i<min.length(); i++){
            for(int begin=0, end=min.length()-i; end<=min.length(); begin++, end++){
                current = min.substring(begin, end);
                if(max.contains(current)){
                    return current;
                }
            }
        }
        return null;
    }



    // 求解两个字符号的最长公共子串
    public static String maxSubstring(String strOne, String strTwo){
        // 参数检查
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
        // 矩阵的横向长度
        int len1 = strOne.length();
        // 矩阵的纵向长度
        int len2 = strTwo.length();

        // 保存矩阵的上一行
        int[] topLine = new int[len1];
        // 保存矩阵的当前行
        int[] currentLine = new int[len1];
        // 矩阵元素中的最大值
        int maxLen = 0;
        // 矩阵元素最大值出现在第几列
        int pos = 0;
        char ch = ' ';
        for(int i=0; i<len2; i++){
            ch = strTwo.charAt(i);
            // 遍历str1，填充当前行的数组
            for(int j=0; j<len1; j++){
                if( ch == strOne.charAt(j)){
                    // 如果当前处理的是矩阵的第一列，单独处理，因为其坐上角的元素不存在
                    if(j==0){
                        currentLine[j] = 1;
                    } else{
                        currentLine[j] = topLine[j-1] + 1;
                    }
                    if(currentLine[j] > maxLen){
                        maxLen = currentLine[j];
                        pos = j;
                    }
                }
            }
            // 将矩阵的当前行元素赋值给topLine数组; 并清空currentLine数组
            for(int k=0; k<len1; k++){
                topLine[k] = currentLine[k];
                currentLine[k] = 0;
            }
            // 或者采用下面的方法
            // topLine = currentLine;
            // currentLine = new int[len1];
        }
        return strOne.substring(pos-maxLen+1, pos+1);
    }


    public static void main(String[] args) {
        String strOne = "abcdefg";
        String strTwo = "adefgwgeweg";
        String result = MaxSubstring.maxSubstring(strOne, strTwo);
        System.out.println(result);
    }

}
