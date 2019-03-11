package offer;

/**
 * Created by lifei on 2017/3/30.
 * 题目：输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 思路:
 * （a)把字符串分为两部分，一部分是字符串的第一个字符，另一部分是第一个字符以后的所有字符。接下来我们求阴影部分的字符串的排列。
 * （b）拿第一个字符和它后面的字符逐个交换。(即轮流当首字母)
 */
public class Of38_StringPermutation {

    public static void main(String[] args) {
        String str = "abcd";
        char[] chs = str.toCharArray();
        permutation(chs,0,4);
    }

    private static void permutation(char[] chs, int index, int size) {
        if (index == size){
            for (char x:chs) {
                System.out.print(x+",");
            }
            System.out.println();
        } else {
            for (int i = index; i < size; i++) {
                if (i != index && chs[i] == chs[index]) continue;//排除重复
                swap(chs,i,index);//首次是交换 0 0索引, 1 0;2 0
                permutation(chs,index + 1,size);
                swap(chs,i,index);
            }
        }
    }

    private static void swap(char[] chs, int idx1, int idx2) {
        char temp = chs[idx1];
        chs[idx1] = chs[idx2];
        chs[idx2] = temp;
    }
}
