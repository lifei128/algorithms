package offer;

/**
 * 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整/数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 *
 *
 * 思路
 * 　　分析规律，从第一个数字开始累加，若走到某一个数字时，前面的累加和为负数，说明不能继续累加了，
 * 要从当前数字重新开始累加。在累加过程中，将每次累加和的最大值记录下来，遍历完成后，返回该数字。
 */
public class Of42_GreatestSumOfSubarrays {
    boolean InvalidInput = false;
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length<=0){
            InvalidInput = true;
            return 0;
        }
        InvalidInput = false;
        int sum=array[0];
        int maxSum=array[0];
        for(int i=1;i<array.length;i++){
            if(sum<0)
                sum=array[i];
            else
                sum+=array[i];
            if(sum>maxSum)
                maxSum=sum;
        }
        return maxSum;
    }

}
