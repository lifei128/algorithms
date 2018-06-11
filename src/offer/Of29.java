package offer;

/**
 * Created by lifei on 2017/4/2.
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 *
 * 解法一：基于Partition函数的O(n)算法  求中位数
 * 解法二：根据数组的特点找出O(n)的算法
 *
 * 快速排序http://www.cnblogs.com/surgewong/p/3381438.html
 * https://baijiahao.baidu.com/po/feed/share?wfr=spider&for=pc&context=%7B%22sourceFrom%22%3A%22bjh%22%2C%22nid%22%3A%22news_3577540174517580868%22%7D
 * http://blog.csdn.net/morewindows/article/details/6684558
 */
public class Of29 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,2,2,2};
        int x = moreThanHalfNum(arr);
        System.out.println(x);
    }

    private static int moreThanHalfNum(int[] arr) {
        if (arr.length == 0)
            return -1;
        int length = arr.length;
        int middle = length >> 1;
        
        int start = 0;
        int end = length - 1;
        int index = partition(arr,start,end);
        while (index != middle){
            if (index > middle){
                end = index - 1;
                index = partition(arr,start,end);
            } else {
                start = index + 1;
                index = partition(arr,start,end);
            }
        }
        int result = arr[middle];
        if (!checkMoreThanHalf(arr,result)){
            result = -1;
        }
        return result;
    }

    private static boolean checkMoreThanHalf(int[] arr, int number) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number){
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if (times * 2 <= arr.length){
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    static int partition(int[] arr, int left, int right) {
        int result = arr[left];
        if (left > right) return  -1;
        while (left < right){
            while (left < right && arr[right] >= result){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < result){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = result;
        return left;
    }
}
