package offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by lifei on 2017/4/2.
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4，5，1，6，2，7，3，8这8个数字，则最小的4个数字是1，2，3，4
 *
 * 解法一：O(n)的算法，只有当我们可以修改输入的数组时可用
 * 解法二：O(nlogk)的算法，特别适用处理海量数据
 *
 * 在最大堆中，根节点的值总是大于它的子树中的任意结点的值。于是我们每次可以在O(1）得到已有的k个数字中的最大值，但需要O(logk)时间完成删除及插入操作
 */
public class Of30 {
    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
//        int[] output = getLeastNumbers(arr,4);
//        for (int x:output) {
//            System.out.print(x+",");
//        }
//        getLeastNumbers2(arr,4);
        int x = findK(arr,2);
        System.out.println(x);
    }

    private static int[] getLeastNumbers(int[] input, int k) {
        if (input.length == 0 && k <= 0) return null;
        int[] output = new int[k];
        int start = 0;
        int end = input.length - 1;
        int index = Of29.partition(input,start,end);
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = Of29.partition(input,start,end);
            } else {
                start = index + 1;
                index = Of29.partition(input,start,end);
            }
        }
        for (int i = 0; i < k;i++) output[i] = input[i];
        return output;
    }

    /**
     * 查找一个数组中的第K大的元素
     * 调用这个Math.Random()函数能够返回带正号的double值，该值大于等于0.0且小于1.0，即取值范围是[0.0,1.0)的左闭右开区间，返回值是一个伪随机选择的数，在该范围内（近似）均匀分布
     *
     * http://blog.csdn.net/hzh_csdn/article/details/53446211
     *
     * PriorityQueue是从JDK1.5开始提供的新的数据结构接口。
     　如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头，字符串则按字典序排列。

     https://github.com/CarpenterLee/JCFInternals/tree/master/markdown
     https://my.oschina.net/leejun2005/blog/135085
     * @param input
     * @param k
     * @return
     */
    private static int findK(int[] input, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i:input) {
            q.offer(i);
            if (q.size() > k){
                q.poll();
            }
        }
        return q.peek();
    }


    /**
     * 第二种做法
     * @param input
     * @param k
     */
    private static void getLeastNumbers2(int[] input, int k) {
        if (input == null || k < 0 || k > input.length)return;
        //根据输入数组前k个数简历最大堆  
        //从k+1个数开始与根节点比较  
        //大于根节点，舍去  
        //小于，取代根节点，重建最大堆
        int[] kArray = Arrays.copyOfRange(input,0,k);
        heapSort(kArray);//使用数组构建大顶堆
        for(int i = k;i<input.length;i++){
            if(input[i]<kArray[k-1]){
                kArray[k-1] = input[i];
                heapSort(kArray);
            }
        }
        for(int i:kArray)
            System.out.print(i);
    }

    private static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            buildMaxHeap(arr,arr.length - i - 1);
            swap(arr,0,arr.length - i - 1);
        }
    }

    //新建大顶堆
    private static void buildMaxHeap(int[] arr, int lastIndex) {
        for (int i = (lastIndex -1) /2; i >=0 ; i--) {
            int k = i;
            while (2*k +1 <= lastIndex){
                int biggerIndex = 2*k + 1;
                if (biggerIndex < lastIndex){
                    if (arr[biggerIndex] < arr[biggerIndex +1]){
                        biggerIndex++;
                    }
                }
                if (arr[k] < arr[biggerIndex]){
                    swap(arr,k,biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
