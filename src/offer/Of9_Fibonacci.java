package offer;

/**
 * Created by lifei on 2017/3/27.
 *  题目一：写一个函数，输入n，求斐波那契数列的第n项
 *
 *  n = 0 时 f(n) = 0；
 *  n = 1 时 f(n) = 1;
 *  n > 1 时 f(n) = f(n - 1) - f(n - 2) ;
 */
public class Of9_Fibonacci {

    static long fibonacii(int n){
        long result = 0l;

        long preone = 1l;
        long pretwo = 0l;
        if (n ==0){
            return pretwo;
        }
        if (n == 1){
            return preone;
        }
        for (int i = 2; i <=n ; i++) {
            result = preone + pretwo;//结果保证由最后两个值得到
            pretwo = preone;
            preone = result;
        }
        return result;
    }
    /**
     * 扩展部分：
     一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     用Fib(n)表示青蛙跳上n阶台阶的跳法数，青蛙一次性跳上n阶台阶的跳法数，是定Fib(0)=1;
     当n = 1时，只有一种跳法，即1阶跳：Fib(1） =  1；
     当n = 2时，有两种跳法，一阶跳和二阶跳：Fib(2) = Fib(1)+FIb(0) = 2;
     当n  =3时，有三种跳法，第一次跳出一阶后，后面还有Fib(3-1)中跳法；第一次跳出二阶后，后面还有Fib(3-2)中跳法；第一次跳出三阶后，后面还有Fib(3-3)中跳法
     Fib(3)= Fib(2)+Fib(1)+Fib(0) = 4
     当n= n时，共有n种跳法方式，第一次跳出一阶后，后面还有Fib(n-1）种跳法；第一次跳出二阶后，后面还有Fib（n-2)种跳法，第一次跳出n阶后，后面还有Fib(n-n)种体哦啊发。
     Fib(n) = Fib(n-1)+Fib(n-2)+Fib(n-3)+..........+Fib(n-n)
            = Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-1)
     又因为Fib(n-1)=Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-2)
     两式相减得：Fib(n)-Fib(n-1)=Fib(n-1)         =====》  Fib(n) = 2*Fib(n-1)     n >= 2
     */
}
