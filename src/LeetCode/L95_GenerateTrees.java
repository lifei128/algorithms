package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class L95_GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n ==0) return new ArrayList<>();
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end){
            res.add(null);
            return res;
        }
        // 每一个i作为根
        // start～～i-1为左子树
        // i+1～～end为右子树
        for (int i = start;i <= end;i++){
            List<TreeNode> subLeftTree = generateTrees(start,i - 1);//todo i-1
            List<TreeNode> subRightTree = generateTrees(i + 1,end);//todo  i+1
            for (TreeNode left : subLeftTree){
                for (TreeNode right: subRightTree) {
                    TreeNode node = new TreeNode(i);//todo i
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
