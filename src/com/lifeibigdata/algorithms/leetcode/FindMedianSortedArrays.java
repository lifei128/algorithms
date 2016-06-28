package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/27.
 *
 * 4
 *
 * 归并计数法 Merge and Count
 * 复杂度
 时间O(n) 空间O(1)
 思路
 如果对时间复杂度没有要求，这个方法是实现起来最简单的，我们只需要从下往上依次数(n+m)/2个元素即可。由于两个数组都已经排序，我们可以使用两个指针指向数组“底部”，通过比较两个数组“底部”的元素大小来决定计哪一个元素，同时将其所在数组的指针“向上”移一位。为了方便处理总元素为偶数的情况，这里将找中位数变成找第k小的元素。
 注意
 计数的循环是用来找到第k-1个元素的，最后return的时候再判断第k个元素是哪一个
 在每次计数的循环中要先判断两个数组指针是否超界，在最后return之前也要判断一次
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays fmsa = new FindMedianSortedArrays();
        System.out.println(fmsa.findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        if(total % 2==0){
            System.out.println("k:"+(total/2)+","+(total/2+1));
            return (findKth(nums1,nums2,total/2)+findKth(nums1,nums2,total/2+1))/2.0;
        } else {
            System.out.println("k:"+total/2+1);
            return findKth(nums1,nums2,total/2+1);
        }
    }
    private int findKth(int[] nums1, int[] nums2, int k){
        int p = 0, q = 0;//p表示基于nums1[],q表示基于nums2[]
        for(int i = 0; i < k - 1; i++){
            if(p>=nums1.length && q<nums2.length){//nums1[]已经遍历结束
                q++;
            } else if(q>=nums2.length && p<nums1.length){//nums2[]已经遍历结束
                p++;
            } else if(nums1[p]>nums2[q]){
                q++;
            } else {
                p++;
            }
        }
        System.out.println("p;"+p+",q:"+q);
        if(p>=nums1.length) {
            System.out.println("nums2[q]:"+nums2[q]);
            return nums2[q];
        } else if(q>=nums2.length) {
            System.out.println("nums1[p]:"+nums1[p]);
            return nums1[p];
        } else {//nums1[]和nums2[]都没有越界,此时需要比较
            System.out.println("nums1[p]:"+nums1[p]+",nums2[q]:"+nums2[q]);
            return Math.min(nums1[p],nums2[q]);//new int[]{1,3},new int[]{2,4},此时需要比较2,3中较小的数
        }
    }

    /***
     *
     *分治法 Divide and Conquer
     复杂度
     时间O(log(m+n)) 空间O(1)
     思路
     题目要求O(log(m+n))的时间复杂度，一般来说都是分治法或者二分搜索。首先我们先分析下题目，假设两个有序序列共有n个元素（根据中位数的定义我们要分两种情况考虑），当n为奇数时，搜寻第(n/2+1)个元素，当n为偶数时，搜寻第(n/2+1)和第(n/2)个元素，然后取他们的均值。进一步的，我们可以把这题抽象为“搜索两个有序序列的第k个元素”。如果我们解决了这个k元素问题，那中位数不过是k的取值不同罢了。
     那如何搜索两个有序序列中第k个元素呢，这里又有个技巧。假设序列都是从小到大排列，对于第一个序列中前p个元素和第二个序列中前q个元素，我们想要的最终结果是：p+q等于k-1,且一序列第p个元素和二序列第q个元素都小于总序列第k个元素。因为总序列中，必然有k-1个元素小于等于第k个元素。这样第p+1个元素或者第q+1个元素就是我们要找的第k个元素。
     所以，我们可以通过二分法将问题规模缩小，假设p=k/2-1，则q=k-p-1，且p+q=k-1。如果第一个序列第p个元素小于第二个序列第q个元素，我们不确定二序列第q个元素是大了还是小了，但一序列的前p个元素肯定都小于目标，所以我们将第一个序列前p个元素全部抛弃，形成一个较短的新序列。然后，用新序列替代原先的第一个序列，再找其中的第k-p个元素（因为我们已经排除了p个元素，k需要更新为k-p），依次递归。同理，如果第一个序列第p个元素大于第二个序列第q个元素，我们则抛弃第二个序列的前q个元素。递归的终止条件有如下几种：
     较短序列所有元素都被抛弃，则返回较长序列的第k个元素（在数组中下标是k-1）
     一序列第p个元素等于二序列第q个元素，此时总序列第p+q=k-1个元素的后一个元素，也就是总序列的第k个元素
     注意
     每次递归不仅要更新数组起始位置（起始位置之前的元素被抛弃），也要更新k的大小（扣除被抛弃的元素）
     */

//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length, n = nums2.length;
//        int k = (m + n) / 2;
//        if((m+n)%2==0){
//            return (findKth(nums1,nums2,0,0,m,n,k)+findKth(nums1,nums2,0,0,m,n,k+1))/2;
//        }   else {
//            return findKth(nums1,nums2,0,0,m,n,k+1);
//        }
//
//    }
//
//    private double findKth(int[] arr1, int[] arr2, int start1, int start2, int len1, int len2, int k){
//        if(len1>len2){
//            return findKth(arr2,arr1,start2,start1,len2,len1,k);
//        }
//        if(len1==0){
//            return arr2[start2 + k - 1];
//        }
//        if(k==1){
//            return Math.min(arr1[start1],arr2[start2]);
//        }
//        int p1 = Math.min(k/2,len1) ;
//        int p2 = k - p1;
//        if(arr1[start1 + p1-1]<arr2[start2 + p2-1]){
//            return findKth(arr1,arr2,start1 + p1,start2,len1-p1,len2,k-p1);
//        } else if(arr1[start1 + p1-1]>arr2[start2 + p2-1]){
//            return findKth(arr1,arr2,start1,start2 + p2,len1,len2-p2,k-p2);
//        } else {
//            return arr1[start1 + p1-1];
//        }
//    }
}
