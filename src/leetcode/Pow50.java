package leetcode;

/**
 * Created by Nack on 2017/12/13.
 */
public class Pow50 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        long num = n;

        if (n < 0) {
            long tmp = -n;
            n = -n;
            x = 1/ x;
        }

        if (n % 2 == 0) {
            return myPow(x*x, n/2);
        } else {
            return x * myPow(x*x, n/2);
        }
    }
}
