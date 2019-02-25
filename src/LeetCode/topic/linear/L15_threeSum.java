package LeetCode.topic.linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15_threeSum {

    /**
     *
     * 暴力解决法是每个人都能想到的，三层for循环，时间复杂度是O(n^3)，而且还要处理重复的问题，显然不是题目想要的解法。

     那能不能降到O(n^2)？排序算法的时间复杂度为O(nlgn)，小于O(n^2)，那么我们不妨先对数组排个序。
     *
     * 排序之后，我们就可以对数组用两个指针分别从前后两端向中间扫描了，如果是 2Sum，我们找到两个指针之和为target就OK了，
     * 那 3Sum 类似，我们可以先固定一个数，然后找另外两个数之和为第一个数的相反数就可以了。
     *
     *http://www.sigmainfy.com/blog/summary-of-ksum-problems.html
     * 做过leetcode的人都知道, 里面有2sum, 3sum(closest), 4sum等问题, 这些也是面试里面经典的问题, 考察是否能够合理利用排序这个性质,
     * 一步一步得到高效的算法. 经过总结, 本人觉得这些问题都可以使用一个通用的K sum求和问题加以概括消化,
     * 这里我们先直接给出K Sum的问题描述和算法(递归解法), 然后将这个一般性的方法套用到具体的K,
     * 比如leetcode中的2Sum, 3Sum, 4Sum问题. 同时我们也给出另一种哈希算法的讨论.
     *
     *
     K Sum求解方法, 适用leetcode 2Sum, 3Sum, 4Sum：
     方法一： 暴力，就是枚举所有的K-subset, 那么这样的复杂度就是 从N选出K个，复杂度是O(N^K)
     方法二： 排序
     2sum的算法复杂度是O(NlogN) 因为排序用了N log N以及头尾指针的搜索是线性的，所以总体是O(NlogN)，
     好了现在考虑3sum, 有了2sum其实3sum就不难了，这样想：
     先取出一个数，那么我只要在剩下的数字里面找到两个数字使得他们的和等于(target – 那个取出的数)就可以了吧。所以3sum就退化成了2sum,
     取出一个数字，这样的数字有N个，所以3sum的算法复杂度就是O(N^2 ), 注意这里复杂度是N平方，因为你排序只需要排一次，后面的工作都是取出一个数字，
     然后找剩下的两个数字，找两个数字是2sum用头尾指针线性扫，这里很容易错误的将复杂度算成O(N^2logN)，这个是不对的。
     我们继续的话4sum也就可以退化成3sum问题(copyright @sigmainfy)，那么以此类推，K-sum一步一步退化，最后也就是解决一个2sum的问题，
     K sum的复杂度是O(n^(K-1))。 这个界好像是最好的界了，也就是K-sum问题最好也就能做到O(n^(K-1))复杂度

     K Sum (2Sum, 3Sum, 4Sum) 算法优化(Optimization)：
     这里讲两点，第一，注意比如3sum的时候，先整体排一次序，然后枚举第三个数字的时候不需要重复，
     比如排好序以后的数字是 a b c d e f, 那么第一次枚举a, 在剩下的b c d e f中进行2 sum, 完了以后第二次枚举b,
     只需要在 c d e f中进行2sum好了，而不是在a c d e f中进行2sum, 这个大家可以自己体会一下，想通了还是挺有帮助的。
     第二，K Sum可以写一个递归程序很优雅的解决，具体大家可以自己试一试。写递归的时候注意不要重复排序就行了。
     */

    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) return ret;

        Arrays.sort(num);

        int len = num.length;
        for (int i = 0; i < len-2; i++) {
            if (i > 0 && num[i] == num[i-1]) continue;
            find(num, i+1, len-1, num[i]); //寻找两个数与num[i]的和为0      todo   i + 1, len - 1
        }

        return ret;
    }

    public void find(int[] num, int begin, int end, int target) {
        int l = begin, r = end;
        while (l < r) {
            if (num[l] + num[r] + target == 0) {
                List<Integer> ans = new ArrayList<Integer>();
                ans.add(target);
                ans.add(num[l]);
                ans.add(num[r]);
                ret.add(ans); //放入结果集中
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            } else if (num[l] + num[r] + target < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
}
