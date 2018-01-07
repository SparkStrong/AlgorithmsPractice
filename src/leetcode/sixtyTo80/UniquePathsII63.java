package leetcode.sixtyTo80;

/**
 * Created by Nack on 2017/12/27.
 */
public class UniquePathsII63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    if (obstacleGrid[i-1][j] != 1 && obstacleGrid[i][j-1] != 1) {
                        result[i][j] = result[i-1][j] + result[i][j-1];
                    } else if (obstacleGrid[i-1][j] != 1) {
                        result[i][j] = result[i-1][j];
                    } else if (obstacleGrid[i][j-1] != 1) {
                        result[i][j] = result[i][j-1];
                    } else {
                        result[i][j] = 0;
                    }
                } else if (i == 0 && j > 0) {
                    if (obstacleGrid[i][j-1] != 1) {
                        result[i][j] = result[i][j-1];
                    } else {
                        result[i][j] = 0;
                    }
                } else if (i > 0) {
                    if (obstacleGrid[i-1][j] != 1) {
                        result[i][j] = result[i-1][j];
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }

        return result[m-1][n-1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] result = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                result[i][j] = 0;
            }
        }

        result[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i-1][j-1] != 1) {
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }

        return result[m][n];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0}};

        int result = uniquePathsWithObstacles(obstacleGrid);

        System.out.println(result);
    }
}
