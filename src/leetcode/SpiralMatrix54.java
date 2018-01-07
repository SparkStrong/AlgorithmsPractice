package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/12/18.
 */
public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int m = 0, n = 0;
        m = matrix.length;
        if (m == 0) {
            return result;
        }
        n = matrix[0].length;

        int ibegin = 0, iend = m - 1;
        int jbegin = 0, jend = n - 1;

        while (ibegin <= iend && jbegin <= jend) {
            for (int j = jbegin; j <= jend; j++) {
                result.add(matrix[ibegin][j]);
            }
            ibegin++;

            for (int i = ibegin; i <= iend; i++) {
                result.add(matrix[i][jend]);
            }
            jend--;

            if (ibegin <= iend) {
                for (int j = jend; j >= jbegin; j--) {
                    result.add(matrix[iend][j]);
                }
            }
            iend--;

            if (jbegin <= jend) {
                for (int i = iend; i >= ibegin; i--) {
                    result.add(matrix[i][jbegin]);
                }
            }
            jbegin++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}};
        List<Integer> result = spiralOrder(matrix);

        System.out.println(result);
    }
}
