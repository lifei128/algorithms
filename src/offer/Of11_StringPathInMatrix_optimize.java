package offer;

// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H

/**
 * 思路
 * 　　首先对所整个矩阵遍历，找到第一个字符，然后向上下左右查找下一个字符，由于每个字符都是相同的判断方法（先判断当前字符是否相等，再向四周查找），
 * 因此采用递归函数。由于字符查找过后不能重复进入，所以还要定义一个与字符矩阵大小相同的布尔值矩阵，进入过的格子标记为true。
 * 如果不满足的情况下，需要进行回溯，此时，要将当前位置的布尔值标记回false。
 * （所谓的回溯无非就是对使用过的字符进行标记和处理后的去标记）
 *
 * 测试用例
 *
 * 　　1.功能测试（多行多列矩阵中存在或者不存在路径）
 *
 * 　　2.边界值测试（矩阵只有一行；矩阵与路径的所有字符都相同）
 *
 * 　　3.特殊输入测试（null）
 *
 * 经典的搜索问题
 */
public class Of11_StringPathInMatrix_optimize {
    boolean hasPath(char[][] matrix, char[] str){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (dfs(matrix, str, 0,row,col))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, char[] str, int u, int x, int y) {
        if (u == str.length) return true;
        if (matrix[x][y] != str[u]) return false;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        char t = matrix[x][y];
        matrix[x][y] = '*';
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < matrix.length && b >= 0 && b < matrix[a].length){
                if (dfs(matrix,str,u + 1,a,b)) return true;
            }
        }
        matrix[x][y] = t;//todo 使用回溯
        return false;
    }
}
