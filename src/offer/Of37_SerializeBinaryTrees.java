package offer;

/**
 * 题目　
 * 　　请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 回到顶部
 * 思路
 * 　　一般情况下，需要采用前/后序遍历和中序遍历才能确定一个二叉树，但是其实可以只采用前序遍历（从根结点开始），将空结点(null)输出为一个特殊符号（如“$”），就可以确定一个二叉树了。
 *
 *  　　将二叉树序列化为字符串，就是前序遍历的过程，遇见空结点时，序列化为“$”，每个结点间使用逗号分隔开。
 *
 * 　　将字符串反序列化为二叉树，也使用前序遍历，遇见一个新数字(或者$)就建立一个新结点，不过需要注意的是，数字可能不只是个位数字，因此创建了一个全局Int变量index（在字符串上的移动的指针），以便于截取字符串中当前的结点值。（详见代码）
 *
 * 测试算例　
 *
 * 　　1.功能测试（一个结点；左右斜树；完全二叉树；普通二叉树）
 *
 * 　　2.特殊测试（根结点为null）
 */
public class Of37_SerializeBinaryTrees {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            sb.append("$,");
        } else {
            sb.append(node.val + ",");
            sb.append(Serialize(node.left));
            sb.append(Serialize(node.right));
        }
        return sb.toString();
    }

    int index = 0;
    TreeNode Deserialize(String str) {
        TreeNode node = null;
        if (str == null || str.length() == 0)
            return node;
        int start = index;
        while (str.charAt(index) != ',')
            index++;
        if (!str.substring(start, index).equals("$")) {
            node = new TreeNode(Integer.parseInt(str.substring(start, index)));
            index++; // 这条语句位置别放错了
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        } else {
            index++;
        }
        return node;
    }
}
