package leetcode.sixtyTo80;

/**
 * Created by Nack on 2017/12/27.
 */
public class UniquePaths62 {

    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i-1][j] + result[i][j-1];
            }
        }

        return result[m-1][n-1];
    }

    /**
     * 超时
     * @param x
     * @param y
     * @param m
     * @param n
     * @param result
     */
    private void walk(int x, int y, int m, int n, int[] result) {
        if (x == m && y == n) {
            result[0] ++;
            return;
        }

        if (x < m) { // 当前没有走到m行，未走到底
            walk(x+1, y, m, n, result);  // 向下移动，x加1,y不变
            if (y < n) {
                walk(x, y+1, m, n, result);
            }
        } else {
            walk(x, y+1, m, n, result); // 向右移动
        }
    }
}
