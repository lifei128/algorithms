package offer;

/**
 * 礼物的最大价值
 *
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 *
 * 回到顶部
 * 思路
 * 　　动态规划：定义f(i,j)为到达(i,j)位置格子时能拿到的礼物总和的最大值，则有：f(i,j)=max{f(i,j),f(i,j)}+values(i,j)。
 *
 * 　　同上道题一样，如果直接使用递归会产生大量的重复计算，因此，创建辅助的数组来保存中间计算结果。
 */
public class Of47_MaxValueOfGifts {
    public int maxValueOfGifts(int[][] values) {
        if(values==null || values.length<=0 ||values[0].length<=0)
            return 0;
        int rows=values.length;
        int cols=values[0].length;
//      int[][] maxValue=new int[rows][cols];
        int[] maxValue=new int[cols];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                int left=0;
                int up=0;
                if(i>0)
//                  up=maxValue[i-1][j];
                    up=maxValue[j];
                if(j>0)
//                  left=maxValue[i][j-1];
                    left=maxValue[j-1];
//              maxValue[i][j]=Math.max(up, left)+values[i][j];
                maxValue[j]=Math.max(up, left)+values[i][j];
            }
        }
//      return maxValue[rows-1][cols-1];
        return maxValue[cols-1];
    }
}
