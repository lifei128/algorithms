package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 思路：建立一个两端开口的队列，放置所有可能是最大值的数字（存放的其实是对应的下标），且最大值位于队列开头。从头开始扫描数组，
 */
public class Of59_1MaxInSlidingWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> max = new ArrayList<Integer>();
        if(num==null || num.length<=0 || size<=0 || size>num.length)
            return max;
        ArrayDeque<Integer> indexDeque = new ArrayDeque<Integer>();

        //todo 如果遇到的数字比队列中所有的数字都大，那么它就是最大值，其它数字不可能是最大值了，将队列中的所有数字清空，放入该数字，该数字位于队列头部；
        for(int i=0;i<size-1;i++){//先找到size中最大的数，依次和对尾索引指向的值比较，删除队列中比新来之小的，最大值的索引放到队头
            while(!indexDeque.isEmpty() && num[i]> num[indexDeque.getLast()])
                indexDeque.removeLast();//todo last
            indexDeque.addLast(i);//todo last 新元素放到队尾   如果遇到的数字比队列中的所有数字都小，那么它还有可能成为之后滑动窗口的最大值，放入队列的末尾；
        }

        for(int i=size-1;i<num.length;i++){//从size-1开始
            while(!indexDeque.isEmpty() && num[i]> num[indexDeque.getLast()])//将新来的数据和队列中的比较，看看新来的数是不是队列中最大的，依次删除队列中比新来之小的，最大值的索引放到队尾
                indexDeque.removeLast();//todo last

            //todo 如果遇到的数字比队列中最大值小，最小值大，那么将比它小数字不可能成为最大值了，删除较小的数字，放入该数字。
            //todo 由于滑动窗口有大小，因此，队列头部的数字如果其下标离滑动窗口末尾的距离大于窗口大小，那么也删除队列头部的数字。
            if(!indexDeque.isEmpty() && (i-indexDeque.getFirst())>=size)//判断当前索引和队列中的最小索引是否超过了size长度,则队列中保存的数据已经超过窗口，所以窗口之外的就可以删除了
                indexDeque.removeFirst();//todo first
            indexDeque.addLast(i);//将当前值放到队尾
            max.add(num[indexDeque.getFirst()]);
        }

        return max;
    }
//    注：队列中存放的是下标，以上讲的 队列头部的数字 均指 队列头部的下标所指向的数字。写代码时不要弄混了。
}
