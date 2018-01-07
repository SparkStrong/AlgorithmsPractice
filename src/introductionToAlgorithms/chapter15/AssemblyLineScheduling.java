package introductionToAlgorithms.chapter15;

/**
 * Created by Nack on 2017/10/31.
 */
public class AssemblyLineScheduling {
    int[][] a;
    int[][] t;
    int[] e = {0, 2, 4};;
    int[] x = {0, 3, 2};
    int n;

    int[][] l;
    int[][] f;
    int ff;
    int ll;

    public void fastestWay() {
        f[1][1] = e[1] + a[1][1];
        f[2][1] = e[2] + a[2][1];

        for (int j = 2; j <= n; j++) {
            if (f[1][j-1] + a[1][j] <= f[2][j-1] + a[1][j]) {
                f[1][j] = f[1][j-1] + a[1][j];
                l[1][j] = 1;
            } else {
                f[1][j] = f[2][j-1] + a[1][j];
                l[1][j] = 2;
            }

            if (f[2][j-1] + a[2][j] <= f[1][j-1] + t[1][j-1] + a[2][j]) {
                f[2][j] = f[2][j-1] + a[2][j];
                l[2][j] = 2;
            } else {
                f[2][j] = f[1][j-1] + t[1][j-1] + a[2][j];
                l[2][j] = 1;
            }
        }

        if (f[1][n] + x[1] <= f[2][n] + x[2]) {
            ff = f[1][n] + x[1];
            ll = 1;
        } else {
            ff = f[2][n] + x[2];
            ll = 2;
        }
    }

    public void printStations() {
        int i = ll;
        System.out.println("line " + i + " station " + n);

        for (int j = n; j >= 2; j--) {
            i = l[i][j];
            System.out.println("line " + i + " station " + (j-1));
        }
    }

    public int getLl() {
        return this.ll;
    }

    public void printStationsAsc(int i, int j) {
        int line = i;
        if (j > 1) {
            i = l[i][j];
            printStationsAsc(i, j-1);
        }
        System.out.println("line " + line + " station " + (j));
        return;
    }

    public AssemblyLineScheduling() {
        n = 6;
        l = new int[3][n+1];
        f = new int[3][n+1];
        ff = 0;
        ll = 0;

        a = new int[3][n+1];
        int[] line1 = {7, 9, 3, 4, 8, 4};
        int[] line2 = {8, 5, 6, 4, 5, 7};
        for (int i = 0; i < line1.length; i++) {
            a[1][i+1] = line1[i];
        }

        for (int i = 0; i < line2.length; i++) {
            a[2][i+1] = line2[i];
        }

        int[] t12 = {2, 3, 1, 3, 4};
        int[] t21 = {2, 1, 2, 2, 1};
        t = new int[3][n];

        for (int i = 0; i < t12.length; i++) {
            t[1][i+1] = t12[i];
        }
        for (int i = 0; i < t21.length; i++) {
            t[2][i+1] = t21[i];
        }
    }

}
