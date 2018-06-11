package offer;

/**
 * Created by lifei on 2017/3/28.
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * 在后序遍历得到的序列中，最后一个数字是树的根节点的值。数组中前面的数字可以分为两部分：第一部分是左子树结点的值，它们都比根节点的值小；第二部分是右子树结点的值，他们都比根节点的值大。
 */
public class Of24 {

    public static void main(String[] args) throws Exception {
        int[] arr = {5,7,6,9,11,10,8};
        boolean b = verifySequence(arr,0,arr.length - 1);
        System.out.println(b);
    }

    private static boolean verifySequence(int[] arr, int start, int end) throws Exception {
        if (arr == null || arr.length < 2)return true;//只有一个或0个节点,或者为null
        if (start < 0){
            throw new Exception("first can't be less than 0");
        }
        if (end > arr.length){
            throw new Exception("last can't be greater than the count of the element.");
        }
        int root = arr[end];
        int i = start;//在二叉搜索树中左子树的结点小于根节点
        for (; i < end; i++) {
            if (arr[i] > root) break;
        }

        int j = i;
        for (; j < end;j++){
            if (arr[j] < root) return false;//在二叉搜索树中右子树的结点大于根节点
        }

        boolean left = true;//判断左子树是不是二叉搜索树
        if (i > start){
            left = verifySequence(arr,start,i - 1);
        }

        boolean right = true;//判断右子树是不是二叉搜索树
        if (i < end){
            right = verifySequence(arr,i,end - 1);
        }
        return (left && right);
    }


}
