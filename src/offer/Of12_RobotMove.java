package offer;

/**
 * 题目
 * 　　地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它每一次可以向左、右、上、下移动一格，
 * 但**不能进入行坐标和列坐标的数位之和大于k的格子**。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 思路
 * 　　与【Java】 剑指offer(11) 矩阵中的路径类似，也采用回溯法，先判断机器人能否进入(i,j)，再判断周围4个格子。这题返回的是int值。
 *
 * 测试用例
 *
 * 　　1.功能测试（多行多列矩阵，k为正数）
 * 　　2.边界值测试（矩阵只有一行或一列；k=0）
 * 　　3.特殊输入测试（k为负数）
 */
public class Of12_RobotMove {

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0)
            return 0;

        boolean[] isVisited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, isVisited);// 用两种方法试一下
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] isVisited) {
        if (row < 0 || col < 0 || row >= rows || col >= cols
                || isVisited[row * cols + col]          //todo 标记已经访问
                || cal(row) + cal(col) > threshold)     //todo 判断是否大于阈值
            return 0;
        int count = 0;
        isVisited[row * cols + col] = true;
        count =  1 + movingCountCore(threshold, rows, cols, row - 1, col, isVisited)
                + movingCountCore(threshold, rows, cols, row + 1, col, isVisited)
                + movingCountCore(threshold, rows, cols, row, col - 1, isVisited)
                + movingCountCore(threshold, rows, cols, row, col + 1, isVisited);
        isVisited[row * cols + col] = false;
        return count;
    }

    private int cal(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
