package offer;

import java.text.NumberFormat;

/**
 * 题目
 * 　　把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 回到顶部
 * 思路
 * 　　对于n个骰子，要计算出每种点数和的概率，我们知道投掷n个骰子的总情况一共有6^n种，因此只需要计算出某点数和的情况一共有几种，即可求出该点数之和的概率。
 *
 * 　　方法一：基于递归的方法，效率较低
 *
 * 　　易知，点数之和s的最小值为n，最大值为6*n，因此我们考虑用一个大小为（6*n-n+1）的数组存放不同点数之和的情况个数，那么，如果点数之和为x，那么把它出现的情况总次数放入数组种下标为x-n的元素里。
 *
 * 　　确定如何存放不同点数之和的次数后，我们要计算出这些次数。我们把n个骰子分为1个骰子和n-1个骰子，这1
 *
 * 个骰子可能出现1~6个点数，由该骰子的点数与后面n-1个骰子的点数可以计算出总点数；而后面的n-1个骰子又可以分为1个和n-2个，把上次的点数，与现在这个骰子的点数相加，再和剩下的n-2个骰子的点数相加可以得到总点数……，即可以用递归实现。在获得最后一个骰子的点数后可以计算出几个骰子的总点数，令数组中该总点数的情况次数+1，即可结束遍历。
 *
 * 　　方法二：基于循环求骰子点数，时间性能好
 *
 * 　　用数组存放每种骰子点数和出现的次数。令数组中下标为n的元素存放点数和为n的次数。我们设置循环，每个循环多投掷一个骰子，假设某一轮循环中，我们已知了各种点数和出现的次数；在下一轮循环时，我们新投掷了一个骰子，那么此时点数和为n的情况出现的次数就等于上一轮点数和为n-1,n-2,n-3,n-4,n-5,n-6的情况出现次数的总和。从第一个骰子开始，循环n次，就可以求得第n个骰子时各种点数和出现的次数。
 *
 * 　　我们这里用两个数组来分别存放本轮循环与下一轮循环的各种点数和出现的次数，不断交替使用。
 *
 *
 *
 * 测试算例　
 *
 * 　　1.功能测试（1，2，3，4个骰子）
 *
 * 　　2.特殊测试（0个）
 *
 * 　　3.性能测试（11个）
 */

//题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
//的所有可能的值出现的概率。
public class Of60_DicesProbability {
    private static final int maxValue = 6;

    /**
     * 方法一：递归解法
     */
    public static void printProbability1(int number) {
        if(number<=0)
            return;  //错误
        int[] probabilities = new int[maxValue*number-number+1];
        //下标为i，对应的值代表点数之和为i+number总共出现的情况次数
        //点数从number~maxValue*number，所以数组大小为6*number-number+1
        for(int i=0;i<probabilities.length;i++)
            probabilities[i]=0;

        //计算不同点数出现的次数
        for(int i=1;i<=maxValue;i++)
            calP(probabilities,number,number-1,i);  //第一次掷骰子，总点数只能是1~maxValue(即6)

        int totalP = (int) Math.pow(maxValue, number);  //所有情况总共出现的次数
        for( int i=0;i<probabilities.length ;i++) {
            double ratio = (double)probabilities[i]/totalP;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
        }
    }

    /**
     * 计算每种点数出现的次数
     * @param number:骰子总个数
     * @param curNumber:当前剩余骰子个数
     * @param sum:各个骰子加起来的总点数
     */
    private static void calP(int[] probabilities, int number, int curNumber, int sum) {
        if(curNumber==0) {
            probabilities[sum-number]++; //总数为sum的情况存放在sum-number下标中
            return;
        }
        for(int i=1;i<=maxValue;i++)
            calP(probabilities, number, curNumber-1, sum+i);  //相当于剩余的骰子少一个，总点数增加。
    }

    //===========================================
    /**
     * 方法二：基于循环求骰子点数，时间性能好
     */
    public static void printProbability2(int number) {
        if(number<=0)
            return;  //错误
        int[][] probabilities = new int[2][number*maxValue+1];
        //[2]代表用两个数组交替保存，[number*maxValue+1]是指点数为所在下标时，该点数出现的总次数。
        //probabilities[*][0]是没用的，只是为了让下标对应点数
        for(int i=0;i<2;i++) {
            for(int j=0;j<number*maxValue;j++) {
                probabilities[i][j]=0;
            }
        }

        for(int i=1;i<=6;i++)
            probabilities[0][i]=1;  //第一个骰子出现的情况

        int flag=0;
        for(int curNumber=2;curNumber<=number;curNumber++) {   //当前是第几个骰子
            for(int i=0;i<curNumber;i++)
                probabilities[1-flag][i]=0;  //前面的数据清零

            for(int i=curNumber;i<=curNumber*maxValue;i++) {
                for(int j=1;j<=6 && j<=i ;j++) {
                    probabilities[1-flag][i]+=probabilities[flag][i-j];
                }
            }
            flag=1-flag;

        }

        int totalP = (int) Math.pow(maxValue, number);  //所有情况总共出现的次数
        for( int i=number;i<= number*6;i++) {
            double ratio = (double)probabilities[flag][i]/totalP;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(8);//设置保留几位小数
            System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
        }
    }
}
