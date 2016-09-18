package com.lifeibigdata.algorithms.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lifei on 16/9/17.
 */
public class LIS {
    /**
     * 动归仅仅获取LIS长度
     * @param A
     * @return
     */
    public static int LIS1(int[] A){
        int[] longest = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            longest[i] = 1;
        }
        int nLis = 1;
        for (int i = 1; i < A.length; i++) {    //从第二位开始,即小标是1
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i]){          //A[j]是历史数据
                    longest[i] = Math.max(longest[i],longest[j]+1);
                }
            }
            nLis = Math.max(nLis,longest[i]);// 2,3,3,4,5,5
            System.out.println(nLis);
        }
        return nLis;
    }


    public static int[] LIS2(int[] A,int[] pre){

        int[] longest = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            pre[i] = -1;
            longest[i] = 1;
        }
        int nLis = 1;
        int nIndex = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i] && longest[i] < longest[j]+1){
                    longest[i] = longest[j]+1;//此处因为上面有longest的比较所以可以这样写
                    pre[i] = j;
                }
//                if (A[j] <= A[i]){
//                    longest[i] = Math.max(longest[i],longest[j]+1);//此处不能写为longest[j]+1,必须判断
//                }
            }
            if (nLis < longest[i]){
                nLis = longest[i];
                nIndex = i;
            }
        }
        return new int[]{nLis,nIndex};
    }

    /**
     * 动归同时获取LIS本身
     */
    static void getLIS(){
        int array[] = {1,4,6,2,8,9,7};
        int[] pre = new int[array.length];
        int[] result = LIS2(array,pre);
        System.out.println("LIS is:"+result[0]);

        List<Integer> list = new ArrayList<>();
        int nIndex = result[1];
        while (nIndex >= 0){
            list.add(array[nIndex]);
            nIndex = pre[nIndex];
        }
        Collections.reverse(list);
        for (int x:list) {
            System.out.print(x+",");
        }
        System.out.println();

    }

    /**
     * 贪心法求最大值
     * @return
     */
    static int LIS3(int[] A){
        int[] buffer = new int[A.length];
        int max = 0;
        for (int x:A) {
            max = insert(buffer,max,x);
        }
        System.out.println(max);
        return max;
    }
    //贪心法的每一步插入都为后一次的插入做准备
    static int insert(int[] buffer,int max, int x) {
        if (max == 0){
            buffer[max] = x;
            max++;
            return max;
        }
        int low = 0;
        int high = max - 1;
        int mid ;
        while (low <= high){
            mid = (low + high)/2;
            if (x < buffer[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low >= max){
            buffer[max] = x;
            max++;
        } else {
            if (buffer[low] < x){
                buffer[low + 1] = x;
            } else {
                buffer[low] = x;
            }
        }
        return max;
    }

    static int LIS4(int[] A){
        int[] buffer = new int[A.length];
        int max = 0;
        int[] pre = new int[A.length];
        for (int i = 0;i < A.length;i++) {
            max = insert2(buffer,max,A,pre,i);
        }
        System.out.println("LIS:"+max);
        int cur = buffer[max -1];
        int i = 0;
        while (cur != -1){
            buffer[i] = A[cur];
            cur = pre[cur];
            i++;
        }
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < max; j++) {
            sb.append(buffer[j]+",");
        }
        sb = sb.reverse();
        System.out.println(sb);
        return max;
    }

    static int insert2(int[] buffer,int max, int[] A,int[] pre,int i) {
        if (max == 0){
            buffer[0] = i;
            max++;
            pre[i]= -1;
            return max;
        }
        int low = 0;
        int high = max - 1;
        int mid ;
        while (low <= high){
            mid = (low + high)/2;
            if (A[i] < A[buffer[mid]]){
                high = mid - 1;
            } else {
                low = mid +1;
            }
        }
        if (low >= max){
            buffer[max] = i;
            pre[i] = buffer[max -1];
            max++;
        } else {
            if (A[buffer[low]] < A[i]){
                buffer[low + 1] = i;//TODO
                pre[i] = buffer[low];
            } else {
                buffer[low] = i;
                pre[i] = (low ==0)?-1:buffer[low - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        LIS1(new int[]{1,4,6,2,8,9,7});
//        getLIS();
        LIS4(new int[]{1,4,6,2,8,9,7});
    }
}
