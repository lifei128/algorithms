package bluebridgecup;

public class A04_FactorialOfN {
    public static void main(String[] args) {
        System.out.println(helper(3));
    }

    private static int helper(int n) {
        if (n > 0)return n * helper(n - 1);
        return 1;
    }
}
