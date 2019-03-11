package offer;

/**
 * 打印1到最大的n位数
 *
 *
 * 题目
 * 　　输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 *
 * 回到顶部
 * 思路
 * 　　陷阱：n过大时是大数问题，不能简单用int或者long数据输出，需要采用字符串或者数组表达大数。
 * 　　解决方法：通过字符数组char[]来进行输出数字。
 *
 * 　方法一：
 *
 * 　　1）在字符串表达的数字上模拟加法；
 * 　　2）把字符串表达的数字打印出来。
 *
 * 　方法二：
 *
 * 　　1）采用递归将每一位都从0到9排列出来；
 * 　　2）把字符串表达的数字打印出来。
 *
 * ·测试算例
 *
 * 　　功能测试（输入1，2，3……）
 * 　　特殊输入测试（输入0，-1）
 */
public class Of16_print1ToMaxOfNDights1s {
    public void print1ToMaxOfNDights1s(int n) {
        if(n<=0)
            return;
        char[] digit = new char[n];
        for(int i=0;i<n;i++)
            digit[i]='0';
        for(int i=n-1;i>=0;i--) {
            while(digit[i]!='9') {
                int m=0;
                digit[m]++;
                while(m<n-1 && digit[m]>'9') {
                    digit[m]='0';
                    digit[m+1]++;
                    m++;
                }
                printdigits(digit);
            }
        }
    }

    private void printdigits(char[] digit) {
        int m = digit.length-1;
        while(digit[m]=='0')
            m--;
        for(int i=m;i>=0;i--)
            System.out.print(digit[i]);
        System.out.println();
    }
}
