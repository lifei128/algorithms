package com.lifeibigdata.algorithms.leetcode;

/**
 * Created by lifei on 16/5/29.
 */
public class ContainerWithMostWater {
    /***
     * 就是说，x轴上在1,2,...,n点上有许多垂直的线段，长度依次是a1, a2, ..., an。找出两条线段，使他们和x抽围成的面积最大。面积公式是 Min(ai, aj) X |j - i|
     *
     * 11
     */

    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i = 0;
        int j = n-1;
        while(i<j)
        {
            int temp = (j - i)*(height[i]>height[j]?height[j]:height[i]);//每次面积

            if(height[i] < height[j])  //木板低的一方移动
            {
                i++;
            }
            else
            {
                j--;
            }
            if(maxArea < temp)
            {
                maxArea = temp;
            }
        }
        return maxArea;
    }
}
