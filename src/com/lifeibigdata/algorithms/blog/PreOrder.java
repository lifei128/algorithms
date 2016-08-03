package com.lifeibigdata.algorithms.blog;

/**
 * Created by lifei on 16/8/3.
 */

/**
 * 中序遍历:ADEFGHMZ
 * 后序遍历:AEFDHZMG
 *
 *
 * 后序遍历最后一个结点即为根结点,即 根结点为G
 */
public class PreOrder {
    public static void main(String[] args) throws Exception{
        String post = "AEFDHZMG";
        String mid = "ADEFGHMZ";
        System.out.println(preOrder(post,mid));
    }
    private static String preOrder(String post, String mid) throws Exception{
        if(post.length() == 1)
            return post;
        else if(post.length() == 0)
            return "";
        int m = mid.indexOf(post.charAt(post.length() - 1));
        return post.charAt(post.length() - 1) + preOrder(post.substring(post.length() - mid.length(),m),mid.substring(0,m)) + preOrder(post.substring(m,post.length() - 1),mid.substring(m+1));
    }

}
