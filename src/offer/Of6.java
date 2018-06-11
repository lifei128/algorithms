package offer;

/**
 * Created by lifei on 2017/3/26.
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重新构造出该二叉树
 *         1
 *     2         3
 *  4         5     6
 *    7           8
 *
 *    前序:1 2 4 7 3 5 6 8
 *    后序:4 7 2 1 5 3 8 6
 *
 * http://blog.csdn.net/jsqfengbao/article/details/47088947
 */
public class Of6 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     *
     * @param preOrder 前序遍历数组
     * @param inOrder  中序遍历数组
     * @param length   数组长度
     * @return         根结点
     */
    public static TreeNode construct(int[] preOrder,int[] inOrder,int length){
        if (preOrder == null || inOrder == null || length <= 0){
            return null;
        }
        try {
            return constructCore(preOrder,0,preOrder.length - 1,
                    inOrder,0,inOrder.length - 1);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param preOrder          前序遍历序列
     * @param startPreIndex     前序序列开始位置
     * @param endPreIndex       前序序列结束位置
     * @param inOrder           中序遍历序列
     * @param startInIndex      中序序列开始位置
     * @param endInIndex        中序序列结束位置
     * @return                  根结点
     */
    private static TreeNode constructCore(int[] preOrder, int startPreIndex, int endPreIndex,
                                          int[] inOrder, int startInIndex, int endInIndex) {
        int rootVal = preOrder[startPreIndex];
        System.out.println("rootVal = "+rootVal);
        TreeNode root = new TreeNode(rootVal);

        //只有一个元素
        if (startPreIndex == endPreIndex){
            if (startInIndex == endInIndex
                    && preOrder[startPreIndex] == inOrder[startInIndex]){
                System.out.println("only one element");
                return root;
            } else {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //在中序遍历中找到根节点的索引
        int rootInIndex = startInIndex;

        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootVal){
            ++rootInIndex;
        }

        if (rootInIndex == endInIndex && inOrder[rootInIndex] != rootVal){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int leftLength = rootInIndex - startInIndex;//中序遍历的左半部分
        int leftPreOrderEndIndex = startPreIndex + leftLength;//前序遍历的左子树

        if (leftLength > 0){
            //构建左子树
            root.left =
                    constructCore(preOrder,startPreIndex + 1, leftPreOrderEndIndex,
                            inOrder,startInIndex,rootInIndex - 1);
        }
        if (leftLength < endPreIndex - startPreIndex){
            //右子树有元素,构建右子树
            root.right = constructCore(preOrder,leftPreOrderEndIndex + 1, endPreIndex,
                    inOrder,rootInIndex + 1,endInIndex);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        printPreOrder(construct(preOrder,inOrder,preOrder.length));
    }

    private static void printPreOrder(TreeNode root) {
        if (root == null){
            return;
        } else {
            System.out.println(root.val + " ");
        }
        if (root.left != null)
            printPreOrder(root.left);
        if (root.right != null)
            printPreOrder(root.right);
    }
}
