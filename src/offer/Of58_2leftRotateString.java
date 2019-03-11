package offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 *
 * 正确思路：本题思路和上一道题翻转单词顺序的原理一模一样，只是上一道题有空格，这道题没空格，其实这道题还更简单。
 * 先分别翻转前半部分字符串和后半部分字符串，最后翻转整个字符串即可。
 */
public class Of58_2leftRotateString {
    public String leftRotateString(char[] chars,int n) {
        if(chars==null ||chars.length<=0)
            return String.valueOf(chars);
        if(n<=0 || n>chars.length)
            return String.valueOf(chars);
        Of58_1ReverseSentence.reverseSb(chars,0,n-1);
        Of58_1ReverseSentence.reverseSb(chars,n,chars.length-1);
        Of58_1ReverseSentence.reverseSb(chars,0,chars.length-1);
        return String.valueOf(chars);
    }
}
