package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目　
 * 　　如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 回到顶部
 * 思路
 * 　　所谓数据流，就是不会一次性读入所有数据，只能一个一个读取，每一步都要求能计算中位数。
 *
 * 　　将读入的数据分为两部分，一部分数字小，另一部分大。小的一部分采用大顶堆存放，大的一部分采用小顶堆存放。
 * 当总个数为偶数时，使两个堆的数目相同，则中位数=大顶堆的最大数字与小顶堆的最小数字的平均值；
 * 而总个数为奇数时，使小顶堆的个数比大顶堆多一，则中位数=小顶堆的最小数字。
 *
 * 　　因此，插入的步骤如下：
 *
 * 　　1.若已读取的个数为偶数（包括0）时，两个堆的数目已经相同，将新读取的数插入到小顶堆中，从而实现小顶堆的个数多一。
 * todo 但是，如果新读取的数字比大顶堆中最大的数字还小，就不能直接插入到小顶堆中了 ，此时必须将新数字插入到大顶堆中，
 * todo 而将大顶堆中的最大数字插入到小顶堆中，从而实现小顶堆的个数多一。
 *
 * 　　2若已读取的个数为奇数时，小顶堆的个数多一，所以要将新读取数字插入到大顶堆中，此时方法与上面类似。
 *
 *
 * 大顶堆，节点的值大于其左右两个字节点的值
 * 小顶堆，节点的值小于其左右两个字节点的值
 */
public class Of41_StreamMedian {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //大顶堆，容量11
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    });
    public void Insert(Integer num) {
        if(((minHeap.size()+maxHeap.size())&1)==0){//偶数时,下个数字加入小顶堆
            if(!maxHeap.isEmpty() && maxHeap.peek()>num){
                maxHeap.offer(num);
                num=maxHeap.poll();
            }
            minHeap.offer(num);
        }else{//奇数时，下一个数字放入大顶堆
            if(!minHeap.isEmpty() && minHeap.peek()<num){
                minHeap.offer(num);
                num=minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        if((minHeap.size()+maxHeap.size())==0)
            throw new RuntimeException();
        double median;
        if((minHeap.size()+maxHeap.size()&1)==0){
            median=(maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            median=minHeap.peek();
        }
        return median;
    }

}
