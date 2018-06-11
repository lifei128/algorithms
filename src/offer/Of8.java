package offer;

/**
 * Created by lifei on 2017/3/26.
 * 题目:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为旋转。 输入一个递增的排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 * 例如数组｛3，4，5，1，2｝为{1,2,3,4,5}的一个旋转，该数组的最小元素为1
 *
 * 我们注意到旋转之后的数组实际上可以划分为两个排序的子数组，而且前面的子数组的元素都是大于或者等于后面子数组的元素
 *
 * 使用二分查找发,如果遇到三个值相等,minOrder使用minOrder查找
 *
 */
public class Of8 {
    public static void main(String[] args) {
//        int[] arr = {3,4,5,1,2};
        int[] arr = {2,2,2,2,2,0,1,2,2};
        System.out.println(minInReverseList(arr));;
    }

    private static int minInReverseList(int[] arr) {
        if (arr == null) return -1;
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex = leftIndex;
        while (arr[leftIndex] >= arr[rightIndex]){//数组的左侧大于或等于右侧的数据
            if (rightIndex - leftIndex <= 1){
                midIndex = rightIndex;
                break;
            }
            midIndex = (leftIndex + rightIndex)/2;//得到中间的数据项
            if (arr[leftIndex] == arr[rightIndex] && arr[midIndex] == arr[leftIndex]){//中间的数据项和两边的数据项相等
                return minOrder(arr,leftIndex,rightIndex);
            }
            if (arr[midIndex] >= arr[leftIndex])
                leftIndex = midIndex;
            if (arr[midIndex] < arr[rightIndex])
                rightIndex = midIndex;
        }
        return arr[midIndex];
    }

    private static int minOrder(int[] arr, int leftIndex, int rightIndex) {
        int result = arr[leftIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (result > arr[i]) result = arr[i];//todo
        }
        return result;
    }
}
