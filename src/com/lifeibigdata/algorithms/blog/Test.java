package com.lifeibigdata.algorithms.blog;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lifei on 16/6/22.
 */
public class Test {
    String str = new String("good");
    char[] ch = {'a','b','c'};
    int i = 10;


    public void change(String str,char ch,int i){  //change()方法里的入参char[] ch变成--------------char ch
        str = "test ok";
        ch = 'g';
        this.i = i+1;                               //this.i = i+1;这里面等号左边的i是属性i，等号右边的i是局部变量（入参里的i）
    }

    public static void main(String[] args){

        Test tt = new Test();
        System.out.println(tt.i);
        System.out.println(tt.str);
        System.out.println(tt.ch);
        System.out.println("------------");
        tt.change(tt.str,tt.ch[0],tt.i);            //这次传递的是个char值的单个数组元素，按照上面的解析
        System.out.println(tt.i);
        System.out.println(tt.str);
        System.out.println(tt.ch);

        System.out.println("************");
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.addLast("9");
        list.removeFirst();
        for (String str:list) {
            System.out.println(str);
        }
    }
}

