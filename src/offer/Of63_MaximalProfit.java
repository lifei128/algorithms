package offer;

/**
 * 股票的最大利润
 *
 * 　假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股票可能获得的利润是多少？
 * 例如一只股票在某些时间节点的价格为{9, 11, 8, 5,7, 12, 16, 14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 *
 *
 * 思路
 * 　　遍历每一个数字，并保存之前最小的数字，两者差最大即为最大利润。
 *
 * 　　值得注意的是，我自己一开始写的代码是默认不能亏本（即可以不买入卖出，利润不能为负数），所以比较简单；但如果可以亏本，
 * 最大利润指的是最小的亏损，那么要注意最小数字不能是最后一个。在下面的代码中可以注意比较两种情况的差别。
 * 可以考虑的例子如 { 16, 11, 7, 4, 2, 1 }
 */
public class Of63_MaximalProfit {
    public static int MaxDiff(int[] arr) {
        if(arr==null || arr.length<2)
            return -1;  //error
        int min=arr[0];//todo 最小值默认第一个

        //最大利润可以是负数，只要亏损最小就行
        int maxDiff=arr[1]-min;//todo 利润默认为第二天，减去第一天
        for(int i=1;i<arr.length;i++) {
            if(arr[i-1]<min)     //保存“之前”最小数字
                min=arr[i-1];
            if(arr[i]-min>maxDiff)
                maxDiff=arr[i]-min;
        }

        //默认不能亏本，代码简单，上面复杂的代码注意细节
//      int maxDiff=0;//todo 利润默认为0
//      for(int i=1;i<arr.length;i++) {
//          if(arr[i]<min)
//              min=arr[i];
//          else if(arr[i]-min>maxDiff)
//              maxDiff=arr[i]-min;
//      }
      return maxDiff;
    }
}
