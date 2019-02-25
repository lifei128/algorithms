package bluebridgecup;

/**
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 *
 * 计算第m层，第n个系数，m和n都从0开始
 */
public class A09_YangTriangle {

    public static void main(String[] args) {
        int level = 5;
        for (int i = 0; i <= level; i++) {
            System.out.print(helper(level,i) +" ");
        }
        System.out.println();
    }

    //m层第n个元素
    private static int helper(int m,int n){
        if (n == 0)return 1;
        if (m == n)return 1;
        return helper(m - 1,n) + helper(m - 1,n - 1);
    }
}