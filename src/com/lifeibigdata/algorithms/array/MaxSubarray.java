package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/10/9.
 */
public class MaxSubarray {
    static int from;
    static int to;
    public static void main(String[] args) {
        int a[] = {1,-2,3,10,-4,7,2,-5};
        int m = maxSubarray2(a);
        System.out.println(m+"---"+from+"---"+to);
    }

    private static int maxSubarray(int[] a) {
        if (a == null || a.length <= 0)
            return 0;
        int sum = a[0];
        int result = sum;
        for (int i = 0; i < a.length; i++) {
            if (sum > 0){
                sum += a[i];
            } else {
                sum = a[i];
            }
            result = Math.max(sum,result);//只计算和
        }
        return result;
    }


    private static int maxSubarray2(int[] a) {
        if (a == null || a.length <= 0){
            from = to = -1;
            return 0;
        }
        int sum = a[0];
        int result = sum;
        int fromNew = 0; //新的子数组起点
        for (int i = 0; i < a.length; i++) {
            if (sum > 0){
                sum += a[i];
            } else {
                sum = a[i];
                fromNew = i;
            }
            if (result < sum){//计算from to
                result = sum;
                from = fromNew;
                to = i;
            }
        }
        return result;
    }
}
