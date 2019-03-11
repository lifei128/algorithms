package offer;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 */
public class Of57_1twoSum2 {
    static void twoSum2(int[] a,int sum){
        int i = 0;
        int j = a.length - 1;
        while (i < j){
            if (a[i] + a[j] < sum){
                i++;
            } else if (a[i] + a[j] > sum){
                j--;
            } else {
                System.out.println(a[i]+"---"+a[j]);
                i++;
                j--;
            }
        }
    }
}
