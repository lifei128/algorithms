package offer;

/**
 * Created by lifei on 2017/3/27.
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 */
public class Of14 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        order(arr);
        for (int x : arr){
            System.out.println(x);
        }
    }

    private static void order(int[] arr) {
        int p = 0;
        int q = arr.length - 1;

        while (q - p > 1) {
            if (isEven(arr[p]) && isEven(arr[q])) {//两个都是偶数,q是正确的位置，所以q需要--，从高位走向低位
                q--;
            } else if (isEven(arr[p]) && !isEven(arr[q])) {//q是偶数,p是奇数需要替换
                int t = arr[q];
                arr[q] = arr[p];
                arr[p] = t;
            } else if (!isEven(arr[p]) && isEven(arr[q])) {//p是奇数,q是偶数
                    p++;
                    q--;
            } else {//都是奇数
                p++;
            }
        }
    }
    static boolean isEven(int n){//是否是偶数
        return (n & 1) == 0;
    }
}
