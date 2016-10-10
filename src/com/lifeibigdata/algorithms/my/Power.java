package com.lifeibigdata.algorithms.my;

/**
 * Created by lifei on 16/9/27.
 */
public class Power {

    public static void main(String[] args) {
        System.out.println(power(1.01d,365));
    }

    static Double pow(double x,int n){
        if (n == 0)
            return 1d;
        if (n == 1)
            return x;
        if (n == 2)
            return x*x;
        double p = pow(x,n/2);
        p *= p;
        return (n%2 == 0) ? p : p*x;
    }

    static double power(double x,int n){
        if (n < 0)
            return 1/pow(x,-n);
        return pow(x,n);
    }
}
