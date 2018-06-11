package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/5/15.
 */
public class FirstMoney {
    public static void main(String[] args) {
        double rate = 0.0171;
        double fetch = 1000;

        double[] money = new double[49];//用1~48表示月份
        money[48] = 1000;
        for (int i = 47;i > 0;i--){
            money[i] = (money[i + 1] + fetch)/(1+rate/12);
        }
        for (int i = 48;i > 0;i--) {
            System.out.println("第"+i+"个月末取钱时,余额应为"+money[i]);
        }
    }
}
