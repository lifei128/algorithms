package com.lifeibigdata.algorithms.array;


        import java.util.Arrays;

/**
 * Created by lifei on 16/10/9.
 */
public class MinSubarray {

    static int minSubarray(int[] a){
        int[] sum = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        Arrays.sort(sum);//TODO collections不能用于Integer数组排序
        //http://www.cnblogs.com/xudong-bupt/p/3168618.html
        //Arrays针对基本数据类型排序,Collections针对复合数据类型排序
        int difference = Math.abs(sum[1] - sum[0]);
        int result = difference;
        for (int i = 0; i < a.length; i++) {
            difference = Math.abs(sum[i + 1] - sum[i]);
            result = Math.min(difference,result);
        }
        return result;
    }
}
