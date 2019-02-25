package bluebridgecup;

/**
 * 求n个不同元素的全排列
 *
 * 回溯问题，用于八皇后和迷宫问题
 * 如果包含重复元素怎么办?
 * 罗列出每一种可能用什么方法?动态规划怎么实现
 *
 *
 * R的全排列可归纳定义如下：
 * 当n=1时，perm(R)=(r)，其中r是集合R中唯一的元素；
 * 当n>1时，perm(R)由(r1)perm(R1)，(r2)perm(R2)，…，(rn)perm(Rn)构成。
 * 实现思想：将整组数中的所有的数分别与第一个数交换，这样就总是在处理后n-1个数的全排列。
 */
public class A05_FullPermutation {
    public static void main(String[] args) {
        char[] chars = "ABC".toCharArray();
        helper(chars,0);
    }

    //k:当前的交换位置(关注点),与其后的元素交换
    private static void helper(char[] chars,int k) {
        if (k == chars.length){
            for (char c:chars) System.out.print(c +" ");
            System.out.println();
        }
        for (int i = k; i < chars.length; i++) {
            {char t = chars[k];chars[k] = chars[i];chars[i] = t;}//试探
            helper(chars,k + 1);
            {char t = chars[k];chars[k] = chars[i];chars[i] = t;}//回溯
        }
    }
}
