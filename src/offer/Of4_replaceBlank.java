package offer;

/**
 * Created by lifei on 2017/3/26.
 * 题目：请实现一个函数，把字符串中的每个空格替换成“%20”。例如输入“We are happy"，则输出”We%20are%20happy".
 *
 * java replace,StringBuilder
 *
 * 本题目考察更多的是数组替换,而非字符串替换
 *
 * 思路:
 *    1.先统计中空格的个数,计算替换之后的长度
 *    2.分配两个指针
 *
 *
 *    todo 从后往前遍历，实际从前往后也是可以的
 */
public class Of4_replaceBlank {
    public static void main(String[] args){
        String str = "we are happy.";
        char[] chars = str.toCharArray();
        int blankNum = 0;
        for (char c:chars) {//todo 获取空格的数目
            if (c == ' ')blankNum++;
        }
        if (blankNum == 0){
            System.out.println(str);
            return;
        }
        int oldlength = str.length();
        //todo 之所以这么做是因为c是静态数组，需要new出一个新数组
        int newlength = oldlength + 2*blankNum;//todo 获取新数组长度,声明新长度
        char[] newChars = new char[newlength];
        System.arraycopy(chars,0,newChars,0,oldlength);
        int p = oldlength - 1;//todo 从后向前遍历，依次赋值字母，如果遇到空格则新数组追加02%
        int q = newlength - 1;
        while (p >= 0){
            if (chars[p] != ' '){
                newChars[q--] = chars[p--];
            } else {
                newChars[q--] = '0';
                newChars[q--] = '2';
                newChars[q--] = '%';
                p--;
            }
        }
        System.out.println(new String(newChars));
    }

    public static String replaceBlank(char[] chars){
        String res = "";
        for (char c :chars) {
            if (c == ' '){
                res += "%20";
            } else {
                res += c;
            }
        }
        return res;
    }

}
