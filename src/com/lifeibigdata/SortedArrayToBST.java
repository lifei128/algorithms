package com.lifeibigdata;

/**
 * 将有序数组转换为二叉搜索树
 * Created by lifei on 2018/5/7.
 *
 * 思路:降序储存和顺序储存都会得到退化树。最有效保持树平衡的是，取数组中值（对于无重复元素的有序数组，中值就是数组中间元素）作为树根的值，
 * 将数组分为左右两个子数组，左子数组的数值均小于根节点，右子数组的值均大于根节点。将左子数组的中间元素作为根节点的左子树，
 * 将右子树的中间元素作为根节点的右子树，由此，形成递归关系，就能得到平衡的二叉搜索树
 *
 * https://blog.csdn.net/liangsir_l/article/details/52206879
 */
public class SortedArrayToBST {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
        public TreeNode(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArray2BST(nums);
        printInOrder(root);
    }

    public static TreeNode sortedArray2BST(int[] nums){
        if (nums == null || nums.length == 0){
            return null;
        }
        return getTree(nums,0,nums.length - 1);
    }

    private static TreeNode getTree(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0){
            return null;
        }
        if (start <= end){
            int mid = (start + end)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = getTree(nums,start,mid - 1);
            root.right = getTree(nums,mid+1,end);
            return root;
        } else {
            return null;
        }
    }


    private static  void printInOrder(TreeNode root){//todo 验证
        if(root!=null){
            printInOrder(root.left);
            System.out.print(root.data+" ");
            printInOrder(root.right);

        }
    }
}
