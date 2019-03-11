package offer;

/**
 * 数值的整数次方
 *
 * 题目
 * 　　实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 回到顶部
 * 思路
 * 　　这道题很容易实现，但需要注意以下陷阱：1）0的负数次方不存在；2）0的0次方没有数学意义；3）要考虑exponent为负数的情况。所以可以对exponent进行分类讨论，在对base是否为0进行讨论。
 *
 * 测试用例
 *
 * 　　指数和底数都分别设置为正负数和0.
 */
public class Of15_power {

    boolean IsInvalid = false;//用全局变量标记是否出错

    public double power(double base, int exponent) {
        IsInvalid = false;
        double result; // double类型
        if (exponent > 0) {
            result = powerCore(base, exponent);
        } else if (exponent < 0) {
            if (base == 0) {
                IsInvalid = true; //0的负数次方不存在
                return 0;
            }
            result = 1 / powerCore(base, -exponent);
        } else {
            return 1; //这里0的0次方输出为1
        }
        return result;
    }

    private double powerCore(double base, int exponent) {
        if (exponent == 1)
            return base;
        if (exponent == 0)
            return 1;
        double result = powerCore(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }
}
