package offer;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 思路
 * 　　记住：两个相同的数字异或等于0.
 *
 * 　　如果数组中只有一个数字只出现一次，我们从头到尾异或每个数字，那么最终的结果刚好是那个只出现一次的数字。
 *
 * 　　而本题里数组中有两个数字只出现一次，如果能够将数组分为两部分，两部分中都只有一个数字只出现一次，那么就可以解决该问题了。
 *
 * 　　求解方法：
 *
 * 　　我们依旧从头到尾异或每个数字，那么最终的结果就是这两个只出现一次的数字的异或结果，由于两个数不同，
 * 因此这个结果数字中一定有一位为1，把结果中第一个1的位置记为第n位。因为是两个只出现一次的数字的异或结果，
 * 所以这两个数字在第n位上的数字一定是1和0。
 *
 * 　　 接下来我们根据数组中每个数字的第n位上的数字是否为1来进行分组，恰好能将数组分为两个都只有一个数字只出现一次的数组，
 * 对两个数组从头到尾异或，就可以得到这两个数了。
 */
public class Of56_1FindNumsAppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length<2)
            return;
        int resultExclusiveOR=0;
        for(int i=0;i<array.length;i++)
            resultExclusiveOR^=array[i];

        int indexOf1=0;//todo 是为了求出1的位置
        while(((resultExclusiveOR&1)==0) && (indexOf1<=4*8)){//todo (resultExclusiveOR&1)!=0则会停止循环，即找到1的位置
            resultExclusiveOR=resultExclusiveOR>>1;  //只有n>>1不完整，要n=n>>1
            indexOf1++;
        }

        num1[0]=0;
        num2[0]=0;
        for(int i=0;i<array.length;i++){
            if(((array[i]>>indexOf1)&1)==1)//todo 对数据分组
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
    }

}
