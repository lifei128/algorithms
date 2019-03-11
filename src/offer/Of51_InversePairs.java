package offer;

/**
 * 逆序对
 */
public class Of51_InversePairs {
    public static int inversePairs(int[] data) {
        if (data == null || data.length < 1) {
            throw new IllegalArgumentException("Array arg should contain at least a value");
        }
        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);
        return inversePairsCore(data, copy, 0, data.length - 1);
    }
    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int mid = (end + start) / 2;
        int left = inversePairsCore(copy, data, start, mid);//todo copy data交换顺序
        int right = inversePairsCore(copy, data, mid + 1, end);

        int i = mid;// 前半段的最后一个数字的下标
        int j = end;// 后半段最后一个数字的下标
        int indexCopy = end;//todo 辅助数组复制的数组的最后一个数字的下标

        int count = 0;// 逆序数
        while (i >= start && j >= mid + 1) {
            if (data[i] > data[j]) {//出现逆序对
                copy[indexCopy] = data[i];//copy为排序后的数组,调整顺序
                indexCopy--;
                i--;
                count += j - mid; //对应的逆序数  todo ??? 为什么不是count++     先用两个指针分别指向两个子数组的末尾，并每次比较两个指针指向的数字。如果第一个子数组中的数字大于第二个子数组中的数字，则构成逆序对，并且逆序对的数目等于第二个子数组中剩余数字的个数,因为第二子数组也是排序好的，大于高位的，自然也大于低位的

//                count++;//该情况下有问题6, 5, 4, 3, 2, 1
            } else {//没有出现逆序对
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }
        for (; i >= start; i--) {
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }
        for (; j >= mid + 1; j--) {
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data));
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15
        int[] data3 = {1, 2, 3, 4, 5, 6};
        System.out.println(inversePairs(data3)); // 0
        int[] data4 = {1};
        System.out.println(inversePairs(data4)); // 0
        int[] data5 = {1, 2};
        System.out.println(inversePairs(data5)); // 0
        int[] data6 = {2, 1};
        System.out.println(inversePairs(data6)); // 1
        int[] data7 = {1, 2, 1, 2, 1};
        System.out.println(inversePairs(data7)); // 3
    }
}
