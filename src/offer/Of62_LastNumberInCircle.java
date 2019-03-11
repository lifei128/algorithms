package offer;

import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数字
 *
 * 0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 *
 * 采用链表来存放数据，每次对长度取余来实现循环
 *
 * 　　将所有数字放入LinkedList链表中（LinkedList比ArrayList更适合增删操作）。
 * 假设当前删除的结点下标为removeIndex，则下一个要删除的结点的下标为：(removeIndex+m-1)%list.size()，通过取余符号可以实现类型循环的操作。
 *
 * 　　注：没必要用循环链表，反而会更麻烦了。
 */
public class Of62_LastNumberInCircle {
    /*
     * 方法二：采用链表来存放，每次对长度取余来实现循环
     */
    public static int LastRemaining_Solution2(int n, int m) {
        if(n<1 || m<1)
            return -1; //出错
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            list.add(i);
        int removeIndex=0;
        while(list.size()>1){
            removeIndex=(removeIndex+m-1)%list.size();//list.size 10 ,  m = 5, removeIndex=0 ==>  4%10=4
            System.out.println(removeIndex);
            list.remove(removeIndex);
        }
        return list.getFirst();
    }

    public static void main(String[] args) {
        LastRemaining_Solution2(10,5);
    }
}
