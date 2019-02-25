package bluebridgecup.array.kmp;

public class Kmp {

    public static void main(String[] args) {

        int[] next = new int[14];
        char[] p = "abcdabdefgabca".toCharArray();
        getNext(p,next);
        for (int n:next) {
            System.out.println(n);
        }
    }

    static void getNext(char[] p,int next[]){
        int nLen = p.length;
        next[0] = -1;//todo 初始化为-1，所以
        int k = -1;
        int j = 0;
//        next[j]代表[0, j - 1]区段中最长相同真前后缀的长度
        while (j < nLen - 1){   //j
            //针对数组p,p[k]表示前项,p[j]表示后项;因为k=-1,j=0
            //注:k==-1表示未找到k前缀与k后缀相等,首次分析可先忽略
//            细心的朋友会问if语句中k == -1存在的意义是何？第一，程序刚运行时，k是被初始为-1，直接进行P[i] == P[k]判断无疑会边界溢出；
// 第二，else语句中k = next[k]，k是不断后退的，若k在后退中被赋值为-1（也就是j = next[0]），在P[i] == P[k]判断也会边界溢出。
// 综上两点，其意义就是为了特殊边界判断。
            if (k > -1)System.out.println(p[j]+"***"+p[k]+"$$$"+j+","+k);
            if (k == -1 || p[j] == p[k]){//匹配成功
                ++j;
                ++k;
                next[j] = k;//todo 首次是next[1] = 0;next中存的是索引;next[0] = -1是初始化的，不用再计算
            } else {    //p[j]与p[k]失配,则继续递归计算前缀p[next[k]]
                k = next[k];//todo next[0]=-1是初始化的，该出逻辑是判断k的取值为next数组的前一项，前一项如果为-1，则k=-1,那么下一次循环会进入两一个逻辑
            }
        }
    }
}
