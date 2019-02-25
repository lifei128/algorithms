package LeetCode.topic.linear;

/**
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 *
 * 输入:
 * 26
 *
 * 输出:
 * "1a"
 * 示例 2：
 *
 * 输入:
 * -1
 *
 * 输出:
 * "ffffffff"
 *
 *
 * 就是按位与来获取。既然是得到十六进制，那么每次与上0xF（二进制就是1111），得到一个值，
 * 然后数字向右移动4位，这里需要注意的是数字是有符号的，刚好可以利用Java提供的无符号移动>>>。完美！！！
 *
 * 0xf也就是 0000 1111；与运算有一个0就是0
 * c>>4   c: 0101 1010   那么h就是 0101
 *
 * & 靠右运算，前面不足为补0
 */
public class L405_toHex {
    static char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public static String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 0xF)] + result;//取最后四位
            num = (num >>> 4);//取最后四位之前的
        }
        return result;
    }

//    问题写法
//    private static String getHex(int n){
//        String res="";
//        if(n<0){
//            res="-";
//            n = 0-n;
//        }
//
//        while (n!=0){
//            int i = n%16;
//            if(i<10){
//                res = res+i;
//            }else{
//                res = res+String.valueOf((char)(i+55));
//            }
//            n = n/16;
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
//        System.out.println(getHex(-55));
        System.out.println(toHex(-55));
    }



//    static final char[] hex = new char[] {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
//    static final int d = 16;

//    public static void main(String[] args) {
//        int num = Integer.MIN_VALUE;
//        StringBuffer ret = new StringBuffer();
//        boolean neg = false;
//        if (num < 0) {
//            neg = true;
//            num = -num;
//        }
//        int s = num;
//        int r = 1;
//        while (s > 0) {
//            int b = r > Integer.MAX_VALUE / d ? Integer.MAX_VALUE : r * d;
//            int p = s % b;
//            int e = p / r;
//            ret.append(hex[e]);
//            s = s - p;
//            r = r * d;
//        }
//        ret.reverse();
//        if (neg) {
//            ret.insert(0, "-");
//        }
//        System.out.println(ret.toString());
//    }
}
