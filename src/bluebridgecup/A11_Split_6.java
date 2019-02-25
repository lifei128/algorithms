package bluebridgecup;

public class A11_Split_6 {

    public static void main(String[] args) {
        int[] a = new int[100];//做缓冲
        helper(3,a,0);
    }

    //对n进行加法划分
    // a:缓冲
    // k:当前的位置
    private static void helper(int n,int[] a,int k) {
        if (n <= 0){
            for(int i=0;i < k;i++)System.out.printf(a[i] + " ");
            System.out.println();
            return;
        }
        //6
        //5...f(1)
        //4...f(2)
        for (int i = n; i > 0; i--) {
            if (k > 0 && i > a[k - 1])continue;//a[k - 1]表示前一项   ;   后一项 > 前一项
            a[k] = i;
            helper(n - i,a,k + 1);
        }
    }
}
