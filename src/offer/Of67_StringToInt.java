package offer;

/**
 * 把字符串转换成整数
 *
 * 题目很简单，主要就是实现对每个字符转化为数字，并进行累加即可。但是有很多特殊情况都需要考虑进去，例如null、空字符串、带有正负号、字符不是数字、溢出等等。
 *
 * 　　对于非法的特殊输入，返回值为0，还要用一个全局变量进行标记。
 *
 * 　　写代码时一定要考虑清楚各种测试用例。
 *
 *
 *
 *  测试用例
 *
 * 　　1.功能测试（正、负、零、带有正负号的数字）
 * 　　2.边界值测试（最大正整数，最小负整数）
 * 　　3.特殊测试（null，数空字符串，仅有正负号，非法字符）
 */
public class Of67_StringToInt {
    static boolean isValid = false;
    public static int strToInt(String str) {
        if(str == null || str.length()<=0)
            return 0;
        char[] chars = str.toCharArray();
        long num=0;  //先用long来存储，以防止越界
        boolean minus=false;
        for(int i=0; i<chars.length; i++){
            if(i==0 && chars[i]=='-'){
                minus=true;
            }else if(i==0 && chars[i]=='+'){
                minus=false;
            }else{
                int a=(int) (chars[i]-'0');
                if(a<0 || a>9){//todo 判断非法字符
                    isValid=false;//todo
                    return 0;
                }
                num= (minus==false) ? num*10+a : num*10-a;//todo 正负计算
                isValid=true;  //不放在最后面是为了防止str=‘+’的情况被判断为true
                if((!minus && num>0x7FFFFFFF) ||(minus && num<0x80000000)){//todo 边界判断
                    isValid=false;//todo
                    return 0;
                }
            }
        }
        return (int)num;
    }
}
