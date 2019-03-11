package offer;

/**
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n)。
 */
public class Of42_maxSubarray {

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

    private static int maxSubarray3(int[] a,int n) {
        if (n == 1)
            return a[0];
        int mid = n >> 1;
        //0...mid - 1      mid...n - 1
        int answer = Math.max(maxSubarray3(a,mid),maxSubarray3(a,n - mid));
        int now = a[mid - 1],may = now;
        for (int i = mid - 2; i >=0 ; --i) {
            may = Math.max(may,now+=a[i]);
        }
        now = may;
        for (int i = mid; i < n; ++i) {
            may = Math.max(may,now+=a[i]);
        }
        return Math.max(answer,may);
    }


    private static int maxSubarray4(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = a[0];
        int answer = dp[0];
        for (int i = 1; i < a.length; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i],a[i]);
            answer = Math.max(answer,dp[i]);
        }
        return answer;
    }


    private static int maxSubarray5(int[] a) {
        int sum = a[0];
        int minSum = Math.min(0,sum);
        int answer = a[0];
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
            answer = Math.max(answer,sum - minSum);
            minSum = Math.min(minSum,sum);
        }
        return answer;
    }
}
