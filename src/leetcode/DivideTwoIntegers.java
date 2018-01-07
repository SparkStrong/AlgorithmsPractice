package leetcode;

/**
 * Created by Nack on 2017/10/30.
 */
public class DivideTwoIntegers {

    /**
     * 使用位运算来代替除法
     * 每一轮都从分母开始，每次左移一位，也即是翻倍，相应的这轮次的结果也翻倍
     * 在经过多个轮次后得到最终的结果
     * @param dividend 被除数  分子
     * @param divisor 除数  分母
     * @return 除法的结果
     */

    public int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);

        if (n == 0 || m < n) {
            return 0;
        }

        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        int result = 0;

        while (m >= n) {
            long num = n, flag = 1;
            while (m >= (num << 1)) {
                num <<= 1;
                flag <<= 1;
            }
            result += flag;
            m -= num;
        }

        return sign == 1 ? result : -result;
    }
}
