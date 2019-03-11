package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数字能排成的最小数字321323。
 *
 * 回到顶部
 * 思路
 * 　　不好的方法：求出所有全排列（类似字符串的排列 ），将数字拼起来，最后求出所有的最小值。这效率太低，且没有考虑到大数问题。
 *
 * 　　好的方法：观察规律，自行定义一种排序规则。
 *
 * 　　对于数字m和n，可以拼接成mn和nm，如果mn<nm，我们定义m小于n。反之则相反。利用这个排序规则，从小排到大即可实现题目要求。
 *
 * 　　拼接m和n时，要考虑到大数问题，因此将m和n拼接起来的数字转换成字符串处理。因为mn和nm的字符串位数相同，因此它们的大小只需要按照字符串大小的比较规则就可以了。
 *
 * 　　具体实现：将数字存入ArrayList中，通过利用Collections.sort(List<T> list, Comparator<? super T> c)方法进行排序。Comparator中重写compar()方法来规定比较规则。
 */
public class Of45_SortArrayForMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null || numbers.length<=0)
            return "";
        ArrayList<String> list = new ArrayList<String>();
        for(int number:numbers)
            list.add(String.valueOf(number));
        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                String a=s1+s2;
                String b=s2+s1;
                return a.compareTo(b);
            }
        });
        StringBuilder sb= new StringBuilder();
        for(String str:list)
            sb.append(str);
        return sb.toString();
    }
}
