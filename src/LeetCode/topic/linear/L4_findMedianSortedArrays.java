package LeetCode.topic.linear;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * https://baijiahao.baidu.com/s?id=1611232735171177699&wfr=spider&for=pc
 */
public class L4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        int halfLen = (m + n + 1)/2;
        boolean isOushu = false;
        if ((m + n) % 2 == 0){
            isOushu = true;
        }
        int aIndex = 0,bIndex = 0,count = 0;
        int[] nums = new int[m + n];
        while (count < halfLen + 1){
            if (aIndex == m){
                while (bIndex != n){
                    nums[count++] = b[bIndex++];
                     if (count == halfLen +1) break;
                }
                break;
            }
            if (bIndex == n){
                while (aIndex != m){
                    nums[count++] = a[aIndex++];
                     if (count == halfLen +1) break;
                }
                break;
            }
            if (a[aIndex] < b[bIndex]){
                nums[count++] = a[aIndex++];
            } else {
                nums[count++] = b[bIndex++];
            }
            // if (count == halfLen +1) break;
        }
        for(int x:nums)System.out.println(x);
        if(m+n==1){
            return nums[0];
        }
        System.out.println("count:"+count);
        if (isOushu) return (nums[halfLen] + nums[halfLen - 1])/2.0;//todo 2.0
        return nums[halfLen -1];
    }

//    public double findMedianSortedArrays(int[] a, int[] b) {
//        int m = a.length;
//        int n = b.length;
//
//        int halfLen = (m + n -1)/2;
//        boolean isOushu = false;
//        if ((m + n) % 2 == 0){
//            isOushu = true;
//            // halfLen = (m + n)/2;
//        } else {
//            // halfLen = (m + n + 1)/2;
//        }
//        int aIndex = 0,bIndex = 0,count = 0;
//        int[] nums = new int[m + n];
//        while (count < m + n){
//            if (aIndex == m){
//                while (bIndex != n){
//                    nums[count++] = b[bIndex++];
//                    // if (count == halfLen +1) break;
//                }
//                break;
//            }
//            if (bIndex == n){
//                while (aIndex != m){
//                    nums[count++] = a[aIndex++];
//                    // if (count == halfLen +1) break;
//                }
//                break;
//            }
//            if (a[aIndex] < b[bIndex]){
//                nums[count++] = a[aIndex++];
//            } else {
//                nums[count++] = b[bIndex++];
//            }
//            // if (count == halfLen +1) break;
//        }
//        for(int x:nums)System.out.println(x);
//        if(m+n==1){
//            return nums[0];
//        }
//        System.out.println("count:"+count);
//        if (count%2==0) return (nums[count/2] + nums[count/2 - 1])/2.0;//todo 2.0
//        return nums[count/2];
//    }
}
