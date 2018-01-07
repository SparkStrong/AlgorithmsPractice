package leetcode;

/**
 * Created by Nack on 2017/12/13.
 * 矩阵顺时针旋转90度
 */
public class RotateImage48 {
    public void rotate(int[][] matrix) {
        reverseUpDown(matrix);
        reverseAlongMainDiagonal(matrix);
    }

    public static void reverseUpDown(int[][] matrix) {
        for (int up = 0, down = matrix.length-1; up < down && up != down; up++, down--) {
            for (int i = 0; i < matrix.length; i++) {
                int tmp = matrix[up][i];
                matrix[up][i] = matrix[down][i];
                matrix[down][i] = tmp;
            }
        }
    }

    public static void reverseAlongMainDiagonal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
