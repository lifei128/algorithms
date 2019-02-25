package bluebridgecup;

/**
 * 在n个求中，任意取出m个，求有多少种不同取法
 */
public class A06_GraspBall {
    //从n个取m个
    public static void main(String[] args) {
        int k = helper(5,3);
        System.out.println(k);
    }

    private static int helper(int n, int m) {
        if (n < m) return 0;
        if (n == m) return 1;
        if (m == 0) return 1;
        return helper(n - 1,m - 1) + helper(n - 1,m);//n个里有个特殊球x，取法划分，包不包含x
    }
}
