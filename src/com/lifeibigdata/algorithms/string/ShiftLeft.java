package com.lifeibigdata.algorithms.string;

/**
 * Created by lifei on 16/5/25.
 */
public class ShiftLeft {

    static String str;

    public ShiftLeft(String str){
        this.str = str;
    }

    public static void main(String[] args) {
        ShiftLeft sl = new ShiftLeft("abcdefghi");
        System.out.printf(sl.shift(12));


    }

    /**
     * abcdef循环左移两位得到cdefab
     *1 暴力求解,将左移字母的暂存临时变量中,将其他字母移位,再将临时变量,补充到移位后字符串的后面
     *2 ba ihgfedc  -> cdefghiab
     *
     *
     */
    private String shift(int digits) {
        if (digits == 0){
            return str;
        } else if (digits > 0){
            digits = digits % str.length();     //是保证循环移位的关键,可以输入大于字符串长度的移位
            String left = reverse(str.substring(0,digits));
            String right = reverse(str.substring(digits));
            System.out.println("left:"+left);
            System.out.println("right:"+right);
            return reverse(left + right);
        } else {   // < 0
            digits = -digits;
            digits = digits % str.length();     //同上
            return shift(str.length() - digits);
        }
    }

    private static String reverse(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] temp = new char[s.length()];
        for (int i = 0; i< temp.length; i++){
            temp[start] = s.charAt(end);
            temp[end] = s.charAt(start);
//          s.charAt(start) = s.charAt(end);  这样写是有问题的
            start++;
            end--;
        }

        return String.valueOf(temp);
    }

}
