package jikexueyuan;

/**
 * Created by lifei on 2017/4/7.
 * 在一个有序序列中 查找某一个元素是否存在
 如果存在，返回该元素在该序列中的索引位置
 如果不存在，返回-1


 */
public class JK5BinarySearch {
    public static void main(String[] args) {
        int array[]={1,2,3,4,5,6,7,8,9,10};
        int index = binary(array,4);
        System.out.println(index);
    }

    private static int binary(int[] array,int key) {
        int low = 0;
        int high = array.length-1;
        int mid;
        if(high < low)
            return -1;
        while(high >= low)
        {
            mid = low+((high-low)>>1);
            if(array[mid] == key)
                return mid;
            else if(array[mid] > key)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }
}
