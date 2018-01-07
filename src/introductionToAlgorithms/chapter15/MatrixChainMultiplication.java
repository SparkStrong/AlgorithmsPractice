package introductionToAlgorithms.chapter15;

/**
 * Created by Nack on 2017/11/1.
 */
public class MatrixChainMultiplication {
    private int[][] m;
    private int[][] s;

    public void matrixChainOrder(int[] p) {
        int matrixsNum = p.length - 1;
        for (int i = 1; i <= matrixsNum; i++) {
            m[i][i] = 0;
        }

        for (int chainLength = 2; chainLength <= matrixsNum; chainLength++) {
            for (int i = 1; i <= matrixsNum - chainLength + 1; i++) {
                int j = i + chainLength - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int tmp = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    if (tmp < m[i][j]) {
                        m[i][j] = tmp;
                        s[i][j] = k;
                    }
                }
            }
        }
    }

    public void printOptimalParens(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public void test() {
        int[] p = {30, 35, 15, 5, 10, 20, 25};
        m = new int[p.length][p.length];
        s = new int[p.length][p.length];
        matrixChainOrder(p);
        printOptimalParens(s, 1, 6);
    }
}
