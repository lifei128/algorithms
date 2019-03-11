package offer;

/**
 * 题目
 * 　　请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 *
 * 回到顶部
 * 思路
 * 　　遇到与二进制有关的题目，应该想到位运算(与、或、异或、左移、右移)。
 *
 * 　　方法一：”与运算“有一个性质：通过与对应位上为1，其余位为0的数进行与运算，可以某一整数指定位上的值。
 * 这道题中，先把整数n与1做与运算，判断最低位是否为1；接着把1左移一位，与n做与运算，可以判断次低位是否为1……反复左移，
 * 即可对每一个位置都进行判断，从而可以获得1的个数。这种方法需要循环判断32次。
 *
 * 　　方法二（better）：
 * 如果一个整数不为0，把这个整数减1，那么原来处在整数最右边的1就会变为0，原来在1后面的所有的0都会变成1。其余所有位将不会受到影响。
 * 再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
 * 因此，把一个整数减1，再和原来的整数做与运算，会把该整数最右边的1变成0。这种方法，整数中有几个1，就只需要循环判断几次。
 *
 * 测试用例
 *
 * 　　1.正数（包括边界值1、0x7FFFFFFF）
 *
 * 　　2.负数（包括边界值0x80000000、0xFFFFFFFF）
 *
 * 　　3.0
 *
 *
 *
 * 把一个整数减1，再和原来的整数做与运算，会把该整数最右边的1变成0。这种方法一定要牢牢记住，很多情况下都可能用到，例如：
 *
 * 　　　1）一句话判断一个整数是否为2的整数次方；
 *
 * 　　　2）对两个整数m和n，计算需要改变m二进制表示中的几位才能得到n。
 *
 * 与数字操作有关的题目，测试时注意边界值的问题。对于32位数字，其正数的边界值为1、0x7FFFFFFF，负数的边界值为0x80000000、0xFFFFFFFF。
 */
public class Of14_NumberOf1InBinary {
    public int NumberOf1_Solution1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    public int NumberOf1_Solution2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
