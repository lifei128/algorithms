package offer;

import java.util.ArrayDeque;

/**
 * 　　请定义一个队列并实现函数max得到队列里的最大值，要求函数max、push_back和pop_front的时间复杂度都是O(1)。
 *
 *
 * 利用一个双端队列来存储当前队列里的最大值以及之后可能的最大值。
 *
 * 　　在定义题目要求功能的队列时，除了定义一个队列data存储数值，还需额外用一个队列maxmium存储可能的最大值；
 * 此外，还要定义一个数据结构，用于存放数据以及当前的index值，用于删除操作时确定是否删除maxmium中最大值。
 *
 * 测试算例　
 *
 * 　　尾部插入不同大小数字，删除头部数字。插入删除同时获取最大值。
 */
public class Of59_2QueueWithMax {
    private ArrayDeque<InternalData> data = new ArrayDeque<InternalData>();
    private ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>();

    private class InternalData{//todo 节点结构
        int number;
        int index;
        public InternalData(int number,int index) {
            this.number=number;
            this.index=index;
        }
    }
    private int curIndex;

    public void push_back(int number) {
        InternalData curData = new InternalData(number,curIndex);
        data.addLast(curData);

        while(!maximum.isEmpty() && maximum.getLast().number<number)//如果新来的大于末尾的，则删除末尾的,队头是最大的
            maximum.removeLast();
        maximum.addLast(curData);//添加新来的

        curIndex++;  //别漏了这句
    }

    public void pop_front() {
        if(data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if(curData.index==maximum.getFirst().index)//todo 如果删除的刚好是最大的，则更新maximum
            maximum.removeFirst();
    }

    public int max() {
        if(maximum==null){
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return maximum.getFirst().number;//todo 队列头是最大的
    }
}
/**
 * 新来的如果大于队尾，则删除队尾，直到遇到最大的
 * 队列头始终是最大的
 */
