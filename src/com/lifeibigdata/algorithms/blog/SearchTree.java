package com.lifeibigdata.algorithms.blog;

import java.util.Arrays;

/**
 *
 * 5、7、6、9、11、10、8
 *      8
    /      \
   6       10
  / \     / \
 5   7   9  11

 */
public class SearchTree {
    public static void main(String[] args) {
//        int[] a = {5,7,6,9,11,10,8};  //true
        int a[] = {7, 4, 6, 5} ;     //false
        System.out.println(searchTree(a,a.length)) ;

    }
    static boolean searchTree(int[] a,int length){
        if (a == null || length <= 0){
            return false;
        }
        boolean flag = true;
        int root = a[length - 1];
        int i = 0;
        while (a[i] < root){
            i++;           //得到左子树和右子树的分界线，a[i]为右子树第一个
        }
        int j = i;
        for (;j < length - 1; ++j){
            if (a[j] < root){
                flag = false;
            }
        }
        if (i > 0){
            searchTree(a,i);
        }
        if (i < length -1){
            searchTree(Arrays.copyOfRange(a,i,length -1),length -i - 1);
        }
        return flag;
    }
}
