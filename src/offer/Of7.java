package offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lifei on 2017/3/26.
 * 题目: 用两个栈实现队列与用两个队列实现栈
 *
 * http://blog.csdn.net/jsqfengbao/article/details/47089355
 */
public class Of7 {

    //用两个栈实现队列
    //todo 一个栈进,一个栈出;当出栈被清空之后,将进栈弹出加到出栈中;如果出栈不为空，则直接从出栈弹出
    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> outStack = new Stack<Integer>();

    public void appendTail(int i){
        inStack.push(i);
    }
    public int delHead(){
        if (outStack.isEmpty()){//出栈为空
            while (!inStack.isEmpty()){//进栈不空
                outStack.push(inStack.pop());//将进栈补入出栈
            }
        }
        if (outStack.isEmpty()){
            try {
                throw new Exception("队列为空，不能删除");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return outStack.pop();
    }



    //用两个队列实现栈
    //两个队列都为空为push到q1,否则哪个为空插入哪个
    //始终保证一个队列为空，弹出项为不为空队列的队尾元素
    LinkedList<String> q1 = new LinkedList<>();
    LinkedList<String> q2 = new LinkedList<>();

    public String push(String str){
        if(q1.size() ==0 && q2.size() == 0){
            q1.addLast(str);
        }else if(q1.size()!=0){
            q1.addLast(str);
        }else if(q2.size()!=0){
            q2.addLast(str);
        }
        return str;
    }


    public String pop(){
        String re =null;
        if(q1.size() == 0 && q2.size() == 0){//如果两个队列为空则返回null
            return null;
        }
        if(q2.size() == 0){
            while(q1.size() >0){
                re = q1.removeFirst();
                if(q1.size() != 0){
                    q2.addLast(re);
                }
            }
        } else if(q1.size() == 0){
            while(q2.size() >0){
                re = q2.removeFirst();
                if(q2.size()!=0){
                    q1.addLast(re);
                }
            }
        }
        return re;
    }
}
