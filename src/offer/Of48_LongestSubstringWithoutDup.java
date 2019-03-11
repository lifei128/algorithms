package offer;

/**
 * 最长不含重复字符的子字符串
 *
 *
 * 动态规划法：定义函数f(i)为：以第i个字符为结尾的不含重复字符的子字符串的最大长度。
 *
 * 　　（1）当第i个字符之前未出现过，则有：f(i)=f(i-1)+1
 *
 * 　　（2）当第i个字符之前出现过，记该字符与上次出现的位置距离为d
 *
 * 　　　　1）如果d<=f(i-1)，则有f(i)=d；
 *
 * 　　　　2）如果d>f(i-1)，则有f(i)=f(i-1)+1；
 *
 * 　　我们从第一个字符开始遍历，定义两个int变量preLength和curLength来分别代表f(i-1)和f(i)，
 * 再创建一个长度为26的pos数组来存放26个字母上次出现的位置，即可根据上述说明进行求解。
 *
 * 　　注意：每次最大长度和字母出现位置要记得更新。
 *
 * 　　另一种思路：遍历每个字符，把当前字符看成子字符串的末尾结点，同时更新开头结点 leetcode3
 */
public class Of48_LongestSubstringWithoutDup {
    public static int  maxLength(String str) {
        if(str==null || str.length()<=0)
            return 0;
        int preLength=0;  //即f(i-1)
        int curLength=0;  //即f(i)
        int maxLength=0;
        int[] pos= new int[26];  //用于存放字母上次出现的位置
        for(int i=0;i<pos.length;i++)
            pos[i]=-1;


        for(int i=0;i<str.length();i++) {
            int letterNumber = str.charAt(i)-'a';
            if(pos[letterNumber]<0 || i-pos[letterNumber]>preLength) {
                curLength=preLength+1;
            }else {
                curLength=i-pos[letterNumber];
            }
            pos[letterNumber]=i;
            if(curLength>maxLength)
                maxLength=curLength;
            preLength=curLength;
        }
        return maxLength;
    }
}
