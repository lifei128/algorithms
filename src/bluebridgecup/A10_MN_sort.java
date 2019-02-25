package bluebridgecup;
// m个a,n个b 可以有多少种组合
public class A10_MN_sort {
    public static void main(String[] args) {
        System.out.println(helper(3,2));
    }

    private static int helper(int m, int n) {
        if (m == 0 || n == 0)return 1;
        return helper(m - 1,n) + helper(m,n - 1);
    }
}
