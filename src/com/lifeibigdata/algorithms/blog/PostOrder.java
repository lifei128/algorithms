package com.lifeibigdata.algorithms.blog;

/**
 * Created by lifei on 16/7/7.
 *
 * 递归兑现已知前序中序求后序
 */
public class PostOrder{
    public static void main(String[] args) throws Exception{
//        Scanner in = new Scanner(System.in);
//        String pre,mid;
//        while(in.hasNext()){
//            pre = in.next();
//            mid = in.next();
//            System.out.println(postOrder(pre,mid));
//        }
        String pre = "GDAFEMHZ";
        String mid = "ADEFGHMZ";
        System.out.println(postOrder(pre,mid));
    }
    private static String postOrder(String pre, String mid) throws Exception{
        if(pre.length() == 1)
            return pre;
        else if(pre.length() == 0)
            return "";
        int m = mid.indexOf(pre.charAt(0));
        return postOrder(pre.substring(1,m+1 ),mid.substring(0, m)) + postOrder(pre.substring(m+1),mid.substring(m+1)) + pre.charAt(0);
    }
}


