package offer;

/**
 *
 * 顺时针打印矩阵
 * 题目　
 * 　　输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 回到顶部
 * 思路
 * 　　每次打印矩阵最外面的一圈（用方法printMatrixInCircle()表示），每次都是这个操作，所以可以采用递归。每次打印矩阵的左上角的横纵坐标相同，即为start，而其余三个角的坐标都与行列数以及start有关，因此只需要for循环即可实现打印。
 *
 * 　　当然，其实只要针对start进行循环判断，start*2的值小于行数和列数时才需要继续打印，这样，通过这个条件，可以用循环来打印每次的最外圈矩阵。
 *
 * 测试算例　
 *
 * 　　多行多列，单行多列，多行单列，一个数的矩阵，空矩阵，null
 */
public class Of29_PrintMatrix {
    public void printMatrix(int[][] matrix) {
        if(matrix==null || matrix.length<=0)
            return;
        printMatrixInCircle(matrix, 0);
    }

    private void printMatrixInCircle(int[][] matrix,int start) {
        int row=matrix.length;
        int col=matrix[0].length;
        int endX=col-1-start;
        int endY=row-1-start;
        if(endX<start || endY<start)
            return;
        //仅一行
        if(endY==start) {
            for(int i=start;i<=endX;i++) {
                System.out.print(matrix[start][i]+" ");
            }
            return;  //记得结束
        }
        //仅一列
        if(endX==start) {
            for(int i=start;i<=endY;i++) {
                System.out.print(matrix[i][start]+" ");
            }
            return;  //记得结束
        }

        //打印边界
        for(int i=start;i<=endX;i++) {
            System.out.print(matrix[start][i]+" ");
        }
        for(int i=start+1;i<=endY;i++) {
            System.out.print(matrix[i][endX]+" ");
        }
        for(int i=endX-1;i>=start;i--) {
            System.out.print(matrix[endY][i]+" ");
        }
        for(int i=endY-1;i>=start+1;i--) {
            System.out.print(matrix[i][start]+" ");
        }

        //继续打印更内部的矩阵，令start+1
        printMatrixInCircle(matrix, start+1);
    }
}
