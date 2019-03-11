package offer;

/**
 * Created by lifei on 2017/3/26.
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下的数序排列。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * todo 右上角的数，比左边大，比下边小，所以可以利用二分法的原理
 */
public class Of3_findKey {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(findKey(mat, 2));
    }

    public static boolean findKey(int[][] array, int key) {
        int rows = array.length;
        int cols = 0;
        if (rows != 0) {
            cols = array[0].length;
        }
        boolean find = false;
        if (rows > 0 && cols > 0) {

            int row = 0;
            int col = cols - 1;//todo 从第一行的最后一列开始,使用while比较合适
            while (row <= rows - 1 && col >= 0) {
                if (array[row][col] > key) {
                    col--;
                } else if (array[row][col] < key) {
                    row++;
                } else {
                    find = true;
                    break;
                }
            }
        }
        return find;
    }
}
