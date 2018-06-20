package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/19.
 */
public class HeapSort {

    public static void main(String[] args) {
        int a[] = {9,3,2,10,44,83,28,5,1,0,36};
        HeapSort hs = new HeapSort();
        hs.headSort(a);
        for (int x:a) {
            System.out.println(x);
        }
    }
    public void headSort(int[] a){
        if (a == null || a.length <= 1){
            return;
        }
        //创建大堆
        buildMaxHeap(a);
        for (int i = a.length - 1;i >= 1;i--){
            //最大元素已经排在了下标为0的地方
            exchangeElements(a,0,i);//每交换一次,就沉淀一个大元素
            maxHeap(a,i,0);
        }
    }
    private void buildMaxHeap(int[] a){
        int half = (a.length - 1)/2;//只需要遍历数组的一半即可,假设长度为9
        for (int i = half; i >= 0; i--) {
            //只需要遍历43210
            maxHeap(a,a.length,i);//todo 这里 i 表示从哪个地方开始构建
        }
    }

    //length表示用于构造大堆的数组长度和元素数量
    private void maxHeap(int[] a, int length, int i) {
        int left = i*2 +1;
        int right = i*2 + 2;
        int largest = i;
        if (left < length && a[left] > a[i]){
            largest = left;
        }
        if (right < length && a[right] > a[largest]){
            largest = right;
        }
        if (i != largest){
            //进行数据交互
            exchangeElements(a,i,largest);
            maxHeap(a,length,largest);
        }
    }

    //在数组a里进行两个下标元素交换
    private void exchangeElements(int[] a, int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }
}
