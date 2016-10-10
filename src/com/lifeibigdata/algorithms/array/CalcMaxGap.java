package com.lifeibigdata.algorithms.array;

/**
 * Created by lifei on 16/9/19.
 */
public class CalcMaxGap {
    static class tagBugect{
        boolean bValid;
        int nMin;
        int nMax;

        void add(int n){//将数n加入到桶中
            if (!bValid){
                nMin = nMax = n;
                bValid = true;
            } else {
                if (nMax < n){
                    nMax = n;
                } else if (nMin > n){
                    nMin = n;
                }
            }
        }
    }
    static int getMaxGap(int[] A){

        tagBugect[] pBucket = new tagBugect[A.length];
        tagBugect tg ;
        for (int i = 0; i < A.length; i++) {
            tg = new tagBugect();
            pBucket[i] = tg;
        }
        //求最值
        int nMax = A[0];
        int nMin = A[0];
        for (int i = 0; i < A.length; i++) {
            if (nMax < A[i]){
                nMax = A[i];
            } else if(nMin > A[i]){
                nMin = A[i];
            }
        }
        //依次将数据放入到桶中    
        int delta = nMax - nMin;
        int nBucket;//某数应该放在哪个桶中
        for (int i = 0; i < A.length; i++) {
            nBucket = (A[i] - nMin)*A.length / delta;//TODO
//            System.out.println("nBucket:"+nBucket);
            if (nBucket >= A.length)
                nBucket = A.length - 1;
            pBucket[nBucket].add(A[i]);
        }
        //计算有效桶的间隔
        int i = 0;//首个桶一定是有效的
        int nGap = delta/A.length;//最小间隔
        int gap;
        for (int j = 0; j < A.length; j++) {//i是前一个桶,j是后一个桶
            if (pBucket[j].bValid){
                gap = pBucket[j].nMin - pBucket[i].nMax;
                if (nGap < gap)
                    nGap = gap;
                i = j;
            }
        }
        return nGap;
    }

    public static void main(String[] args) {
        System.out.println(getMaxGap(new int[]{1,4,7,9,13,14}));
    }
}
