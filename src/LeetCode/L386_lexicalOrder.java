package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
public class L386_lexicalOrder {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) { //10 20 30
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {//  1~9
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {//todo
                    curr /= 10;
                }
                System.out.println(">>>"+curr);// 19 29 39 49 55 9
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
    public static void main(String args[]){
        System.out.println(lexicalOrder(55));
    }
}
