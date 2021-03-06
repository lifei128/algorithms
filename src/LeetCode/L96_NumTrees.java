package LeetCode;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *    n = 3
 *    root: 1   left:0 right:2  f(0)*f(2)
 *    root: 2   left:1 right:1  f(1)*f(1)
 *    root: 3   left:2 right:0  f(2)*f(0)
 *
 *    f(n) = f(0)*f(n-1)+f(1)*(n-2)+...+ f(n-2)*f(1) + f(n-1)*f(0)
 *    time:O(n)
 *    space:O(n)
 */
public class L96_NumTrees {
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {//从1开始
            for (int j = 0; j < i; j++) {//从0开始
                res[i] += res[j] * res[i -j - 1];//res[j]是左子树    i是总个数，1是根节点，所以i - 1 -j是右子树
            }
        }
        return res[n];
    }
}
