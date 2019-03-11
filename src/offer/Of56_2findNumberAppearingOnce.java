package offer;

/**
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 　　将所有数字的二进制表示的对应位都加起来，如果某一位能被三整除，那么只出现一次的数字在该位为0；反之，为1。
 *
 *
 * 1.判断某个数x的第n位（如第3位）上是否为1，
 *
 * 　　　　1）通过 x&00000100 的结果是否为0 来判断。（不能根据是否等于1来判断）
 *
 * 　　　　2）通过（x>>3)&1 是否为0 来判断
 */
public class Of56_2findNumberAppearingOnce {

    public static int findNumberAppearingOnce(int[] arr) {
        if(arr==null || arr.length<=0)
            throw new RuntimeException();
        int[] bitSum = new int[32];//todo 声明32位的数组
        for(int i=0;i<32;i++)
            bitSum[i]=0;

        for(int i=0;i<arr.length;i++) {
//        通过number&bitMask的结果是否为0（不能用1判断），bitMask=1不断左移，可以将一个数的二进制存储到32位的数组中。
            int bitMask=1;
            for(int j=31;j>=0;j--) {
                int bit=arr[i]&bitMask;  //注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
                if(bit!=0)
                    bitSum[j]+=1;

                bitMask=bitMask<<1;
            }
        }
        //通过以下代码实现二进制转化为数字（注意左移语句的位置）
        int result=0;
        for(int i=0;i<32;i++) {
            result=result<<1;
            result+=(bitSum[i]%3);
        }
        return result;
    }

}
