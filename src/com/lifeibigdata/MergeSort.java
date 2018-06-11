package com.lifeibigdata;

/**
 * Created by lifei on 2017/4/7.
 */
public class MergeSort {
    //合并两个有序子数组
    static void Mergearray(int[] a,int left,int mid,int right,int[] temp)
    {
        int i = left,j = mid+1;
        int m = mid,n = right;
        int k=0;
        //二路归并
        while(i<=m && j<=n)
        {
            if(a[i]<=a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        //处理子数组中剩余的元素
        while(i<=m)
            temp[k++] = a[i++];
        while(j<=n)
            temp[k++] = a[j++];

        //从临时数组中拷贝到目标数组
        for(i=0;i<k;i++)
            a[left+i] = temp[i];
    }

    //归并排序的核心工作
    static void MergeSort(int[] a,int left,int right,int[] temp)
    {
        if(left < right)
        {
            int mid = left + (right-left)/2;

            //归并排序 使得左边序列有序
            MergeSort(a,left,mid,temp);
            //归并排序 使得右边序列有序
            MergeSort(a,mid+1,right,temp);

            //合并两个有序序列
            Mergearray(a,left,mid,right,temp);
        }
    }

    public static void main(String[] args) {
        int array[]={6,3,2,1,4,10,9,8,7,5};
        int[] b = new int[10];
//        MergeSort(array,0,9,b);
        Inplace_MergeSort(array,0,9);
        for (int x:array) {
            System.out.print(x+",");
        }
    }

    /*
    题目要求：
两个有序子序列a[0,mid-1]和a[mid,num-1]， 将两个子数组归并，使其整体有序
空间复杂度为O(1)


思路：将同一个数组中两段有序序列合并为一个 可以使用插入的排序方式
将后半部分的元素插入到前半部分内 对后半部分的每一个元素 都在前半部分找到
合适的位置  然后插入（类似于插入排序）
*/

    void Merge2(int[] array,int begin,int end)
    {
        int middle = begin + (end-begin)/2;

        int i= begin;
        int temp;

        //将后半部分中的元素依序插入前面有序子序列中
        while(middle <= end)
        {
            temp = array[middle];//待插入的元素
            if(array[i] < array[middle]) //找到合适的位置
            {
                i++;
            }
            else //进行插入的操作
            {
                int index = middle;
                while(index != i)
                {
                    array[index] = array[index-1];
                    index--;
                }
                array[i++] = temp;
                middle++;
            }

        }
    }  //这个函数能否再精简？

    /*
原地归并的思想
假如有一个数组，里面有两段已经排序好的数组不使用额外的空间将这两段有序序列
进行合并 有两段有序空间分别为A B，从A中找第一个大于B[0]的元素并记录为A[i]
从B中找第一个大于A[i]的元素并记录为B[j] 在这段空间中进行右移 然后就变得有序
*/

    //对称交换
    static void Revere(int[] array,int begin,int end)
    {
        int temp;
        while(begin < end)
        {
            temp = array[begin];
            array[begin]=array[end];
            array[end] = temp;
            begin++;
            end--;
        }
    }

    //右旋转
/*
array为待旋转的数组
begin 为开始位置
middle是旋转中心
end 为后半段
*/
    static void Rotate_right(int[] array,int begin,int middle,int end)
    {
        Revere(array,begin,middle);
        Revere(array,middle+1,end);
        Revere(array,begin,end);
    }

    //原地合并
    static void Merge_second(int[] array,int begin,int end)
    {
        //[begin,mid-1] [mid,end]分别有序
        int mid = begin + (end-begin)/2+1;
        int i = begin;
        int index;
        //直到将两个有序子序列其中的元素排序完成 那么两个有序子序列就合并完成
        while(mid <= end && i<mid)
        {
            //从前面的有序序列中找到一个元素，其大于后序有序序列中的第一个元素
            while(array[i] <= array[mid]&& i < mid)
            {
                i++;
            }
            //记录当前两个有序子序列的分界点
            index = mid;
            //从后面有序子序列中找到一个元素，其大于前面有序序列的第i个元素
            while(mid <= end && array[mid]<= array[i])
            {
                mid++;
            }
            //以index为分界点，也就是以当前两个有序子序列的分界点为旋转中心,右旋转
            Rotate_right(array,i,index-1,mid-1);
            //更新前面子序列中未排序元素的位置
            i += (mid-index);
        }
    }

    //归并排序总体函数
    static void Inplace_MergeSort(int[] arr,int beg,int end)
    {
        if(beg < end)
        {
            int mid = (beg+end)/2;
            Inplace_MergeSort(arr,beg,mid);
            Inplace_MergeSort(arr,mid+1,end);
            Merge_second(arr,beg,end);
        }
    }
}
