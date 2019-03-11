package offer;

/**
 * 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 *
 * 创建哈希表，键值key为字符，值value为出现次数。
 * 第一遍扫描：对每个扫描到的字符的次数加一；
 * 第二遍扫描：对每个扫描到的字符通过哈希表查询次数，第一个次数为1的字符即为符合要求的输出。
 *
 * 　　由于字符（char）是长度为8的数据类型，共有256中可能，因此哈希表可以用一个长度为256的数组来代替，数组的下标相当于键值key，对应字符的ASCII码值；
 * 数组的值相当于哈希表的值value，用于存放对应字符出现的次数。
 */
public class Of50_1FirstNotRepeatingChar {
    public char firstNotRepeatingChar(String str) {
        if(str==null)
            return '\0';
        int[] repetitions = new int[256];
        for(int i=0;i<256;i++)
            repetitions[i]=0;
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            repetitions[loc]+=1;
        }
        for(int i=0;i<str.length();i++) {
            int loc=(int) str.charAt(i);
            if(repetitions[loc]==1)
                return (char)loc;
        }
        return '\0';
    }
}
