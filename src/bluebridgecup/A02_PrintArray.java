package bluebridgecup;

public class A02_PrintArray {

    private static void f1(int n) {
        if (n > 0) f1(n - 1);
        System.out.println(n);

    }

    private static void f2(int start, int end) {
        if (start > end)return;
        System.out.println(start);
        f2(start+1,end);
    }

    public static void f_arr(int[] arr,int start){
        if (start > arr.length - 1)return;
        System.out.println(arr[start]);
        f_arr(arr,start+1);
    }

    public static void main(String[] args){
//        f1(10);
//        f2(0,10);

//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//        fa(arr,0);
    }
}
