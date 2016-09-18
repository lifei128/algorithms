package com.lifeibigdata.algorithms.sort;


/**
 * Created by lifei on 16/8/5.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {49,38,65,97,76,13,27,49};
//        simpleSelectSort(nums);
//        treeSelectSort(nums);
        heapSelectSort(nums);
        for (int num:nums) {
            System.out.print(num+"\t");
        }

    }
    static void simpleSelectSort(int[] nums){//7,6,3,4,5
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;

            for (int j = i+1; j < nums.length; j++) {
                if (nums[minIndex]>nums[j]) {
                    minIndex = j;
                }
            }
            if (minIndex!=i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    static void treeSelectSort(int[] nums){//19 , 38 ,  65  ,97  , 76  ,13  , 27 , 49
        int len = nums.length;
        int treeSize = 2*len - 1;  //满二叉树的节点数
        int low = 0;
        int[] tree = new int[treeSize];//临时的树存储空间

        //由后向前填充此树，索引从0开始
        for (int i = len -1,j = 0;i >= 0;--i,j++){//填充叶子节点
            tree[treeSize - 1 - j] = nums[i];
        }
        for (int x:tree) {
            System.out.print(x+"\t");
        }
        System.out.println();
        for (int i = treeSize - 1; i > 0; i -=2){//填充非终端节点
//            System.out.println(i+"---"+((i - 1)/2));
            tree[(i-1)/2] = (tree[i - 1] < tree[i] ? tree[i - 1] : tree[i]);
        }
        for (int x:tree) {
            System.out.print(x+"\t");
        }
        System.out.println();
        //不断移走最小节点
        int minIndex;
        while (low < len){
            int min = tree[0]; //最小值
            nums[low++] = min;
            minIndex = treeSize - 1;
            while(tree[minIndex] != min){//不断移走最小节点
                minIndex--;
            }
            tree[minIndex] = Integer.MAX_VALUE;//设置一个最大值标志
            //找到其兄弟节点
            while (minIndex > 0){//如果其还有父节点     -->该步骤旨在重新生成一颗树
                if (minIndex % 2 == 0){//如果是右节点
                    tree[(minIndex - 1)/2] = (tree[minIndex - 1] < tree[minIndex] ? tree[minIndex - 1] : tree[minIndex]);
                    minIndex = (minIndex-1)/2;
                } else {//如果是左节点
                    tree[minIndex/2] = (tree[minIndex] < tree[minIndex + 1] ? tree[minIndex] : tree[minIndex + 1]);
                    minIndex = minIndex/2;
                }
            }
//            for (int x:tree) {
//                System.out.print(x+"\t");
//            }
//            System.out.println();
        }
    }

    static void heapSelectSort(int[] nums){
        int len = nums.length;
        //构建堆
        for (int i = (len -1)/2; i >= 0; i--) {
            heapAdjust(nums,i,len);
        }
        //输出堆顶元素并调整建新堆的过程
        int count = len-1;
        while(count > 0 ){
            //交换树根与最后一个值
            swap(nums,0,count);
            count -- ;
            heapAdjust(nums,0,count);
        }
    }

    static void heapAdjust(int[] nums, int i, int len) {
        int parent = nums[i];
        for (int j = (i+1)*2 - 1; j < len; j=(j+1)*2 - 1) {
            if (j < len -1 && nums[j] < nums[j+1]){
                ++j;
            }
            if (parent > nums[j]){
                break;
            }
            nums[i] = nums[j];
            i = j;
        }
        nums[i] = parent;
    }
    /**
     * 交换数组中两元素的值
     */
    private static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
