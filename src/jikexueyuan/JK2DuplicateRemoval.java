package jikexueyuan;

/**
 * Created by lifei on 2017/4/6.
 *
 * 题目描述
 给定一个已排序的数组，去除数组中的重复元素，只保留一个重复的元素，并且返回新的数组长度。
 要求：
 不要给数组分配额外的空间，你必须使用常量的内存大小进行原地操作。
 例如：
 给出数组A=[1,1,2]，你的函数调用之后必须返回长度length=2，并且A现在变成[1,2]。
 输入
 一个已排序的数组，例如[1,1,2]。
 输出
 返回数组新的长度，例如length=2。
 快慢指针法
 设置fast指针遍历数组，slow指针指向不重复元素的下一位。

 http://www.bitscn.com/pdb/java/201611/755461.html
 */
public class JK2DuplicateRemoval {
    public static void main(String[] args) {
        char str[]="AAABCCCDFGGIIIKKLMNNOOPQQQQR".toCharArray();
        int size  = removeAll(str);
        for (int i = 0; i < size; i++) {
            System.out.print(str[i]);
        }
    }

    /**
     * 一个已经排序好的字符串 将重复的字符串保留一个
     * @param str
     */
    private static int remove(char[] str) {
        if (str.length < 0)return -1;
        int slow = 1;
        for (int fast = 1; fast < str.length; fast++) {
            if (str[fast] != str[slow - 1]){
                str[slow++] = str[fast];
            }
        }
        return slow;
    }

    /**
     * 去除已排序数组中的重复元素，保留指定位数
     * @param str
     * @return
     */
    private static int removeN(char[] str,int repeatN) {
        if (str.length <= repeatN)
            return str.length;
        int index = repeatN;
        for (int i = repeatN; i < str.length; i++) {
            if (str[i] != str[index - repeatN]){
                str[index++] = str[i];
            }
        }
        return index;
    }

    /**
     * 重复的字符全部删除
     * @param str
     * @return
     */
    private static int removeAll(char[] str) {//遍历所有字符
        int flag = 0;
        int index = -1;
        int pos;
        for (pos = 0; pos + 1 < str.length; pos++) {
            if (str[pos] == str[pos+1]){//如果当前字符和下一个字符相同
                flag = 1;
            } else {//如果当前字符和下一个字符不同
                if (flag == 1){//跳过该字符
                    flag = 0;
                } else {
                    index++;
                    str[index] = str[pos];
                }
            }
        }
        if(str[pos]!= str[pos-1])
            str[++index] = str[pos];//todo ++index
        return ++index;
    }
}
