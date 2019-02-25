package bluebridgecup;

public class A01_SumArray {

    public static int f1(int[] arr)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    //**************************线性递归**************************
    public static int f2(int[] arr,int start)
    {
        if (start == arr.length) //递归出口
            return 0;
        return arr[start] + f2(arr,start+1);
    }


    public static int f3_2(int[] arr,int end)
    {
        if (end < 0) //递归出口
            return 0;
        return f3_2(arr,end-1) + arr[end];
    }

    //**************************二分递归**************************
    public static int f4(int[] arr,int start,int end)
    {
        if (start > end) return 0;//递归出口
        int mid = (start + end)/2;
        return f4(arr,start,mid-1) + arr[mid] + f4(arr,mid+1,end);//todo 不如下面的方式
    }

    public static int f5(int[] arr,int start,int end)
    {
        if (start == end) return arr[start];//递归出口
        int mid = (start + end)/2;
        return f5(arr,start,mid) + f5(arr,mid+1,end);//注意分为mid    mid+1
    }

    public static void main(String[] args)
    {
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//        System.out.println(f1(arr));

//        System.out.println(f2(arr,0));
//        System.out.println(f3_2(arr,arr.length - 1));

//        System.out.println(f4(arr,0,arr.length - 1));
//        System.out.println(f5(arr,0,arr.length - 1));

    }
}
