package offer;

/**
 * 　一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0到n-1之内。
 * 在范围0到n-1的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 * 由于是排序数组，我们继续考虑使用二分查找算法，结合上图可知：
 *
 * 　　　　当中间数字等于其下标时，我们在后半部分查找；
 *
 * 　　　　当中间数字不等于其下标时，
 *
 * 　　　　1）如果中间数字的前一个数字也不等于其下标，则在前半部分查找；
 *
 * 　　　　2）如果中间数字的前一个数字等于其下标，则说明中间数字的下标即为我们所要找的数字。
 */
public class Of53_2MissingNumber {
    public int getMissingNumber(int[] arr) {
        if(arr==null || arr.length<=0)
            return -1;
        int low=0;
        int high=arr.length-1;
        while(low<=high) {
            int mid=(low+high)>>1;
            if(arr[mid]!=mid) {
                if(mid==0 || arr[mid-1]==mid-1)
                    return mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return -1;
    }
}
