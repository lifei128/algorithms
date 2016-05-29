package com.lifeibigdata.algorithms.my;

import java.util.Scanner;

/**
 * Created by lifei on 16/5/24.
 */
public class Eratosthenes {

    static void getPrimes(int num){
        int []arr = new int[num +1];//长度为11的数组,能够存下表为0-10的数组,所以取10以内的数组,需要申请11长度的数组
        for (int i = 1; i <= num; i++){
            arr[i] = i;
        }
        arr[1] = 0;//1不是素数,排除1

        for (int i = 2; i < Math.sqrt(num); i++){
            for (int j = i+1; j < num; j++){
                if (arr[j] != 0 && arr[j]%i == 0){
                    arr[j] = 0;
                }
            }
        }

        for (int i = 0; i < num; i++){
            if (arr[i] != 0){
                System.out.printf(arr[i]+"\t");
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("请输入查询值:");
        int num = scanner.nextInt();
        getPrimes(num);



    }
}
