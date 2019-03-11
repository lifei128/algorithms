package offer;

/**
 * 我们把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。
 *
 *
 * 空间换时间的解法：
 *
 * 　　创建数组存放已经排序好的丑数，这将消耗一定的内存开销。
 * 根据丑数的定义，丑数应该是另一个丑数的2、3或者5倍的结果，
 * 因此，我们从数组中已有的丑数里找到三个丑数T2、T3、T5，它们分别和2、3、5相乘得到的值恰好比已有的最大丑数大，
 * 三个乘积中最小的一个就是下一个丑数，存放入数组中，同时更新T2、T3、T5，使它们仍然保持与2、3、5的乘积恰好比已有的最大丑数大。
 */
public class Of49_UglyNumbe {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int[] UglyNumbers=new int[index];//定义数组
        UglyNumbers[0]=1;
        int index2=0;
        int index3=0;
        int index5=0;
        for(int i=1;i<index;i++){
            //todo UglyNumbers[index2]，UglyNumbers[index3]，UglyNumbers[index5]第一次都是1
            UglyNumbers[i]=getMinimum(UglyNumbers[index2]*2,UglyNumbers[index3]*3,UglyNumbers[index5]*5);
            while(UglyNumbers[index2]*2<=UglyNumbers[i])//todo ???
                index2++;
            while(UglyNumbers[index3]*3<=UglyNumbers[i])
                index3++;
            while(UglyNumbers[index5]*5<=UglyNumbers[i])
                index5++;
        }
        return UglyNumbers[index-1];
    }

    private int getMinimum(int a,int b,int c){
        if(a>b)
            a=b;
        if(a>c)
            a=c;
        return a;
    }


   /*逐一判断每个数是否为丑数，效率太低
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)
            return 0;
        int number=1;
        int count=0;
        while(true){
            if(isUgly(number))
                count++;
            if(count==index)
                return number;
            number++;
        }
    }
    private boolean isUgly(int number){
        while(number%5==0)
            number/=5;
        while(number%3==0)
            number/=3;
        while(number%2==0)
            number/=2;
        return number==1;
    }
   */
}
