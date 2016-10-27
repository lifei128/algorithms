package com.lifeibigdata.fight;

/**
 * Created by lifei on 16/10/24.
 */
public class InsertSort {

    static int[] insertSort(int[] a){
        int j;
        for (int i = 1; i < a.length; i++) {
            int target = a[i];
            j = i;
            while (j > 0 && target < a[j - 1]){
                a[j] = a[j - 1];//TODO  将arr[i]复制为一个名为target的临时元素。
                // 向下扫描列表，比较这个目标值target与arr[i-1]、arr[i-2]的大小，依次类推。
                //这个比较过程在小于或等于目标值的第一个元素(arr[j])处停止，或者在列表开始处停止（j=0）。
                //在arr[i]小于前面任何已排序元素时，后一个条件（j=0）为真，
                //因此，这个元素会占用新排序子列表的第一个位置。
                //在扫描期间，大于目标值target的每个元素都会向右滑动一个位置（arr[j]=arr[j-1]）。
                //一旦确定了正确位置j，目标值target（即原始的arr[i]）就会被复制到这个位置。
                //todo 与选择排序不同的是，插入排序将数据向右滑动，并且不会执行交换。
                j--;
            }
            a[j] = target;
            for (int x:a) {
                System.out.printf(x +" ");
            }
            System.out.println();
        }
        return a;
    }

    //todo 通常，插入排序呈现出二次排序算法中的最佳性能。对于具有较少元素（如n<=15）的列表来说，二次算法十分有效。
    public static void main(String[] args) {//TODO 插入排序,只能在大于前一个值并且小于后一个值的地方交换,只大或者只小不能解决问题
        int[] a = new int[]{2,3,5,1,4};
        int[] r = insertSort(a);
        for (int x:r) {
            System.out.println(x);
        }
    }
}
