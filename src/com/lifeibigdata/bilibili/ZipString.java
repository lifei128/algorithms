package com.lifeibigdata.bilibili;

/**
 * Created by lifei on 2018/6/22.
 *
 */
public class ZipString {

    public void zipString(String origString){
        int low = 0,heigh = 0;
        int length = origString.length();
        StringBuffer sb = new StringBuffer();
        char c = ' ';
        int count = 0;
        while (low < length){
            heigh = low;//todo 从低位开始遍历
            c = origString.charAt(heigh);
            while (heigh < length && origString.charAt(heigh) == c){
                heigh++;
            }
            count = heigh - low;
            sb.append(c).append(count);
            low = heigh;//todo 从高位开始遍历
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        ZipString zs = new ZipString();
        zs.zipString("aabcccccaaa");//a2b1c5a3
    }
}
