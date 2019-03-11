package offer;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 *
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。
 *
 *
 * 　　指针法：
 *
 * 　　类似(57-1) 和为s的两个数字的方法，用两个指针small和big分别代表序列的最大值和最小值。令small从1开始，big从2开始。
 *
 * 　　当从small到big的序列的和小于s时，增加big，使序列包含更多数字；（记得更新序列之和）
 *
 * 　　当从small到big的序列的和大于s时，增加small，使序列去掉较小的数字；（记得更新序列之和）
 *
 * 　　当从small到big的序列的和等于s时，此时得到一个满足题目要求的序列，输出，然后继续将small增大，往后面找新的序列。
 *
 * 　　序列最少两个数字，因此，当small到了s/2时，就可以结束判断了。
 */
public class Of57_2FindContinuousSequence {
    //方法一：采用两个指针的方法
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > sequenceList = new ArrayList<ArrayList<Integer> >();
        if(sum<=0)
            return sequenceList;

        int small = 1;//正数序列 1 2 3 4 5 6 ...
        int big = 2;
        int curSum = small+big;
        while(small <= sum/2){
            if(curSum == sum){
//                System.out.println(big);
                ArrayList<Integer> sequence = new ArrayList<Integer>();
                for(int i=small;i<=big;i++)
                    sequence.add(i);

                sequenceList.add(sequence);
                curSum-=small;//todo 减去small,然后增加small,
                small++; //这两行位置先后要注意
            }
            if(curSum < sum){
                big++;
                curSum+=big;
            }
            if(curSum > sum){
                curSum-=small;
                small++;
            }
        }
        return sequenceList;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = Of57_2FindContinuousSequence.FindContinuousSequence(9);
        for (ArrayList<Integer> al : arrayLists) {
            for (Integer i:al) {
                System.out.println(i);
            }
            System.out.println("~~~~~~");
        }
    }
}
