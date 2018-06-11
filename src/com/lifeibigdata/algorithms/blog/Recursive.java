package com.lifeibigdata.algorithms.blog;

import com.lifeibigdata.algorithms.leetcode.TreeNode;

import java.util.List;

public class Recursive {

    public static void main(String[] args) {
//        System.out.println(factorial(3));
//        tower(2,'A','B','C');
//        perm(new int[]{1,2,3},0,2);
//        System.out.println(fib(12));
        System.out.println(fib_i(1,1,7));
//        System.out.println(factorial_tail(3,1,1));
//        System.out.println(is_palindereme(""));
//        System.out.println(binary_search(new int[]{1,2,3,4,5},4));
//        System.out.println(binSearch(new int[]{1,2,3,4,5},0,4,6));
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
//        maxSubArraySum3(arr);
//        System.out.println(getMax(arr));
    }

    /**
     * 阶乘
     * n! = n * (n-1) * (n-2) * ...* 1(n>0)
     *
     */
    static int factorial(int x){
        if (0 == x){
            return 1;
        } else {
            return x*factorial(x - 1);
        }
    }

    // 迭代计算过程
    static int factorial2(int n){
        return factIterator(1, 1, n);
    }

    static int factIterator(int result, int counter, int maxCount){
        if(counter > maxCount){
            return result;
        }
        return factIterator((counter * result), counter + 1, maxCount);
    }

    /**
     * 汉诺塔问题
     *
     *当n=1时，将A上的盘子直接移动到C上
     *当n>=2时：
     *1，将A上n-1个盘子移动到B上（此步骤的解决办法与移动n阶盘子的方法完全一样,只是问题的规模减小1阶)
     *2，将A上的一个盘子移动到C
     *3，将B上的n-1个盘子移动到C上。
     *
     */
    public static void tower(int n,char one,char two,char three){
        if(n==1){
            move(one,three,1);
        }else{
            tower(n-1,one,three,two);   //把第1个移动到第2个
            move(one,three, n);         //将第n个盘,从第1个移动到第3个柱子
            tower(n-1,two,one,three);   //把第2个移动到第3个
        }
        System.out.println("---");
        /**
         *
         A的第1盘移动到C
         A的第2盘移动到B
         C的第1盘移动到B

         A的第3盘移动到C
         B的第1盘移动到A
         B的第2盘移动到C
         A的第1盘移动到C
         */
    }
    //输出
    public static void move(char x,char y, int n){
        System.out.println(x+"的第"+n+"盘移动到"+y);
    }


    /**
     * 全排列问题
     * http://blog.csdn.net/xiazdong/article/details/7986015
     */
    static void swap(int a,int b,int arr[])
    {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void perm(int arr[], int begin,int end) {
        if(end==begin){         //一到递归的出口就输出数组，此数组为全排列
            for(int i=0;i<=end;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        else{
            for(int j=begin;j<=end;j++){
                swap(begin,j,arr);      //for循环将begin~end中的每个数放到begin位置中去
                perm(arr,begin+1,end);  //假设begin位置确定，那么对begin+1~end中的数继续递归
                swap(begin,j,arr);      //换过去后再还原
            }
        }
    }


    /**
     * 斐波纳契数列，又称黄金分割数列
     *
     * 这个数列从第三项开始，每一项都等于前两项之和
     * 斐波那契数列这样定义：f(0) = 0, f(1) = 1, 对n > 1, f(n) = f(n-1) + f(n-2)
     * 1、1、2、3、5、8、13
     */
    static long fib(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (n > 1)
            return fib(n-1) + fib(n-2);
        return 0;
    }

    static int fib_i(int a, int b , int n)
    {
        if(n == 2)
            return a+b;
        else
            return fib_i(b, a+b, n-1);
    }

    static int factorial_tail(int n,int acc1,int acc2)
    {
        if (n < 2)
        {
            return acc1;
        }
        else
        {
            return factorial_tail(n-1,acc2,acc1+acc2);
        }
    }

    /**
     *
     fibonacci(n-1,acc2,acc1+acc2)真是神来之笔，原本朴素的递归产生的栈的层次像二叉树一样，以指数级增长，但是现在栈的层次却像是数组，变成线性增长了，
     实在是奇妙，总结起来也很简单，原本栈是先扩展开，然后边收拢边计算结果，现在却变成在调用自身的同时通过参数来计算。
     小结
     尾递归的本质是：将单次计算的结果缓存起来，传递给下次调用，相当于自动累积。
     在Java等命令式语言中，尾递归使用非常少见，因为我们可以直接用循环解决。而在函数式语言中，尾递归却是一种神器，要实现循环就靠它了。
     */
//    def Fib(n,b1=1,b2=1,c=3):
//
//            if n <= 2:
//            return 1
//
//            else:
//            if n==c:
//            return b1+b2
//
//    else:
//            return Fib(n,b1=b2,b2=b1+b2,c=c+1)



    /**
     *
     *返回一个二叉树的深度
     */

    int depth(TreeNode t){
        if(t == null) return 0;
        else {
            int a=depth(t.right);
            int b=depth(t.left);
            return (a>b)?(a+1):(b+1);
        }
    }

    /**
     *
     *判断一个二叉树是否平衡
     */
    int isB(TreeNode t){
        if(t == null) return 0;
        int left=isB(t.left);
        int right=isB(t.right);
        if( left >=0 && right >=0 && left - right <= 1 || left -right >=-1)
            return (left<right)? (right +1) : (left + 1);
        else return -1;
    }

    /**
     * 求数组中的最大值
     *
     *
     * 用递归算法求数组中的最大值
     * @param a 数组
     * @param low 数组下标
     * @param heigh 数组上标
     * @return
     */
    public static int Max(int[] a, int low, int heigh) {
        int max;
        if(low > heigh-2) {
            if(a[low] > a[heigh]) max = a[low];
            else max = a[heigh];
        }else {
            int mid = (low + heigh)/2;
            int max1 = Max(a, low, mid);
            int max2 = Max(a, mid+1, heigh);
            max = max1>max2 ? max1 : max2;
        }
        return max;
    }
    /**
     * 数字塔问题
     *
     *
     * 用递归算法求解数字塔问题
     * @param n 数字塔的行数
     * @return 数字塔的字符串
     */
    public static String tourData(int n) {
        String str = new String();
        if(1 == n) {
            str = rowData(n) + "\n";
            return str;
        }
        else {
            str = tourData(n-1) + rowData(n) + "\n";
        }
        return str;
    }
    private static String rowData(int n) {
        String str = new String();
        for(int i=0; i<n; i++) {
            str = str+ n + "      ";
        }
        return str;
    }

    /**
     * 判断是否是回文
     * @param str
     * @return
     */
    static boolean is_palindereme(String str){
        if (str.isEmpty() || str.length() < 2){
            return true;
        } else {
//            char[] chars = str.toCharArray();
//            if (chars[0] == chars[chars.length -1]){
            if (str.charAt(0) == str.charAt(str.length() - 1)){
                return is_palindereme(str.substring(1,str.length()-1));
            }
        }
        return false;
    }

    /**
     * 已排序数组的二分查找算法
     */

    static boolean binary_search(int[] arr,int target){
        int mid = arr.length /2;
        if (arr[mid] == target){
            return true;
        } else if (arr[mid] > target){
            int[] narr = new int[arr.length - mid];
            System.arraycopy(arr,0,narr,0,arr.length - mid);
            return binary_search(narr,target);
        } else if (arr[mid] < target){
            int[] narr = new int[arr.length - mid];
            System.arraycopy(arr,mid,narr,0,arr.length - mid);
            return binary_search(narr,target);
        }
        return false;
    }

    /**
     * 递归方法实现二分查找法.
     * @param low 数组第一位置
     * @param high 最高
     * @param key 要查找的值.
     * @return 返回值.
     */
    static int binSearch(int[] Array,int low,int high,int key)
    {
        if (low<=high)
        {
            int mid = (low+high)/2;
            if(key == Array[mid])
                return mid;
            else if(key<Array[mid])
                //移动low和high
                return binSearch(Array,low,mid-1,key);
            else if(key>Array[mid])
                return binSearch(Array,mid+1,high,key);
        }
        return -1;
    }
//    static boolean binary_search(int[] arr,int arrlength,int target){
//        int mid;
//        if (arrlength == 1) {
//            return arr[0] == target;
//        } else {
//            mid = arrlength/2;
//            if (arr[mid-1] == target){
//                return true;
//            } else if (arr[mid - 1] > target){
//                return binary_search(arr,mid,target);
//            } else {
//                return binary_search(arr,arrlength - mid,target);
//            }
//        }
//    }
    /**
     * 兔子产子问题
     */
    /**
     * 走楼梯问题
     */
    /**
     * 在二元树中找出和为某一值的所有路径
     * http://z466459262.iteye.com/blog/1115316
     *
     */


/**
 * 纯递归问题的难易主要纠结于一些条件表达式的构造以及初值的设置（上面的为直接表达式值的设定）
 * 递归分两步，递和归
 *
 * 递归算法的一般形式：
 void   func(mode){
 if(endCondition){
 constExpression       //基本项
 }
 else
 {
 accumrateExpreesion /归纳项
 mode=expression //步进表达式
 func(mode) / /调用本身，递归
 }
 }
 */
}


