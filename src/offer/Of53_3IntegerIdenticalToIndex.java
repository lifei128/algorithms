package offer;

/**
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 请编程实现一个函数找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组{-3, -1,1, 3, 5}中，数字3和它的下标相等。
 *
 *
 * 不再从头到尾遍历，由于是排序数组，我们继续考虑使用二分查找算法：
 *
 * 　　  1）当中间数字等于其下标时，中间数字即为所求数字；
 *
 * 　　  2）当中间数字大于其下标时，在左半部分区域寻找；
 *
 * 　　  2）当中间数字小于其下标时，在右半部分区域寻找；
 */
public class Of53_3IntegerIdenticalToIndex {

    public int getNumberSameAsIndex(int[] arr) {
        if(arr==null || arr.length<=0)
            return -1;  //代表错误
        int low=0;
        int high=arr.length-1;
        while(low<=high) {
            int mid= (high+low)>>1;
            if(arr[mid]>mid)
                high=mid-1;
            else if(arr[mid]<mid)
                low=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
