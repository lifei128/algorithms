package bluebridgecup;

import java.util.*;

/**
 * 给定1到n的连续自然数，把他们按字符顺序排列，比如1 10 11 12 2 3 ... 要求输出第k个数字是什么
 */
public class A16_zhaohai {
    public static int getK(int n, int k) {
        if (n < k) return 0;
        List<String> rst = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            rst.add(i + "");
        }

        Collections.sort(rst, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return Integer.parseInt(rst.get(k - 1));
    }

    public static void main(String[] args) {
        System.out.println(getK(30,3));;
    }
}
