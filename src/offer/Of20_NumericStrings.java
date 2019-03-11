package offer;

/**
 * 题目
 * 　　请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，
 * 但“12e”、“1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是。
 *
 * 回到顶部
 * 思路
 * 　　刚开始的思路是从头到尾遍历，对遇到的不同情况进行分析，但很容易出错。因此采用《剑指OFFER》一书的方法：
 * 将数字的形式总结为：(A.B E/e A) ,按顺序进行判断（A代表带符号整数，B代表不带符号整数）。
 *
 * 　　另一种思路：借助几个flag从头到尾遍历，具体代码见：【LeetCode】65. Valid Number
 *
 * 测试算例　
 *
 * 　　1.功能测试（正负数；含整数与不含整数部分；含与不含小数部分；含与不含指数部分；不匹配情况）
 * 　　2.特殊测试（null，空字符串）
 */
public class Of20_NumericStrings {
    /*
     *  数字的基本格式为：(A.B E/e A) ,按顺序进行判断
     *  //A代表带符号整数，B代表不带符号整数
     *  小心：时刻要注意数组越界问题！
     */

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        int[] index = new int[1];
        index[0] = 0; // 用于记录当前字符位置
        // 先判断A
        boolean isNumeric; //用于记录是否满足条件
        isNumeric = isInteger(str, index);
        // 判断B
        if (index[0] < str.length && (str[index[0]] == '.')) {
            index[0]++;
            isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B和A.和A.B形式均可以
        }
        // 判断e后面的A
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length)
            return true;
        else
            return false;
    }

    private boolean isInteger(char[] str, int[] index) { // 用int[]才能传值，int的话需要定义index为全局变量
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
            index[0]++;
        return isUnsignedInteger(str, index);
    }

    private boolean isUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
            index[0]++;
        if (index[0] > start)
            return true;
        else
            return false;
    }
}
