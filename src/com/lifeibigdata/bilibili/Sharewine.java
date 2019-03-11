package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/20.
 * 穷举 泊松分酒
 */
public class Sharewine {

    //三个容器
    private int b1 = 12;
    private int b2 = 8;
    private int b3 = 5;
    private int m = 6;//目标酒量

    //初始酒量12 0 0
    //bb1 bb2 bb3酒量
    private void backBottle(int bb1,int bb2,int bb3){
        System.out.println("bb1="+bb1+",bb2="+bb2+",bb3="+bb3);
        //制定一定的倒酒策略 1->2->3->1
        if (bb1 == m || bb2 == m || bb3 == m){
            System.out.println("find the bottle");
            return;
        }
        if (bb2 != 0 && bb3 != b3){//瓶子2有酒,瓶子3不满
            if (bb2 + bb3 <= b3){//倒不满
                backBottle(bb1,0,bb2+bb3);
            } else {
                backBottle(bb1,bb2-(b3 -bb3),b3);
            }
        } else if (bb3 == b3){//瓶子3满了,往瓶子1到
            if (bb3+bb1 <= b1){//说明倒完后,瓶子1没满
                backBottle(bb1+bb3,bb2,0);
            } else {
                backBottle(b1,bb2,bb3-(b1 -bb1));
            }
        } else if (bb2 == 0){//从瓶子1往瓶子2里到
            if(bb1 >= b2){
                backBottle(bb1 - b2,b2,bb3);
            } else {
                backBottle(0,bb1,bb3);
            }
        }
    }

    public static void main(String[] args) {
        Sharewine sw = new Sharewine();
        sw.backBottle(12,0,0);
    }
}
