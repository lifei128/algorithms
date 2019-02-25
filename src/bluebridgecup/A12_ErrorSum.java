package bluebridgecup;

public class A12_ErrorSum {
    public static void main(String[] args) {
        int sum = 6;
        int[] a = {3,2,4,3,1};
        boolean[] b = new boolean[a.length];//表示a对应项是否选取
        helper(sum,a,0,0,b);
    }

    //error_sum:有错误的和
    //a：明细
    //k:当前处理的位置
    //cur_sum:前边元素的累加和
    //b:记录取舍
    private static void helper(int error_sum, int[] a, int k, int cur_sum, boolean[] b) {
        if (cur_sum > error_sum)return;
        if (error_sum == cur_sum){
            for(int i = 0;i < b.length;i++) if (b[i] == true)System.out.printf(a[i]+" ");
            System.out.println();
            return;
        }
        if (k >= a.length)return;
        b[k] = false;
        helper(error_sum,a,k + 1,cur_sum,b);
        b[k] = true;
        cur_sum += a[k];
        helper(error_sum,a,k + 1,cur_sum,b);
        b[k] = false;//回溯！！！！！
    }
}
