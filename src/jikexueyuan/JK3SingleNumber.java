package jikexueyuan;

/**
 * Created by lifei on 2017/4/6.
 */
public class JK3SingleNumber {
    public static void main(String[] args) {
//        int array[]={12,23,12};
//        int x = singleNumber(array);
//        System.out.println(x);

//        int array[] = {1,1,2,3,4,4};
//        int pn[] = new int[2];
//        int[] x = singleNumberII(array,pn);
//        for (int xx:x) {
//            System.out.println(xx);
//        }

        int array[] = {1,1,1,3,4,4,4};
        int x = singleNumberIII(array);
        System.out.println(x);

    }

    /**
     * 一个数组中只有一个数组出现了一次 其他都是出现了两次
     找到这个出现一次的数字

     将整个数组中的整数进行异或 最后得到的结果就是所要找的数
     * @param array
     * @return
     */
    private static int singleNumber(int[] array) {
        if (array.length < 0) return -1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    /**
     * 如果一个数组中有两个数出现了一次 其他都是出现了两次 这两个数分别是什么
     *
     *
     * @param array
     * @return
     */
    private static int[] singleNumberII(int[] array,int[] pn) {
        int temp = 0;
        for (int x:array) {//计算这两个数的异或结果
            temp ^= x;
        }

        //找到异或结果中第一个为1的位
        int j = 0;
        for (j = 0; j < 4 * 8;j++){//4表示int4个字节
            if (((temp >> j)&1) ==1) break;
        }
        //todo 第j位为1，说明这两个数字在第j位上是不同的  根据这个来进行分组
        for(int i=0;i<array.length;i++)
            if(((array[i] >> j )&1) ==0)
                pn[0] ^= array[i];
            else
                pn[1] ^= array[i];
        return pn;
    }

    /**
     * 一个数组中只有一个数出现了一次 其他都是出现了三次 找出这个数
     * @param array
     * @return
     */
    private static int singleNumberIII(int[] array) {

        int i,j;
        int low = 0;
        int high = array.length - 1;
        int bit = 1;
        while (low <= high){//通过某一位的值将数组分为两部分，其中一部分包含了待找的数 另一部分不包含
            if (low == high)
                return array[low];
            i = low - 1;
            for (j = low; j <= high; j++) {
                if ((array[j] & bit) == 0){
                    i++;
                    swap(array,i,j);
                }
            }
            if (i >= low){
                if((i-low+1)%3 == 0)
                    low = i+1;
                else
                    high =i;
            }
            bit = bit << 1;
        }
        return -1;
    }

    private static void swap(int[] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
