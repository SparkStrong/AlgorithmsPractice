package leetcode.sixtyTo80;

/**
 * Created by Nack on 2017/12/18.
 */
public class PlusOne66 {
    public int[] plusOne(int[] digits) {
        int num = 1;
        int i = 0;

        for (i = digits.length - 1; i >= 0; i--) {
            digits[i] += num;
            if (digits[i] > 9) {
                num = 1;
                digits[i] = 0;
            } else {
                return digits;
            }
        }

        if (i == -1 && num == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int j = 1; j < digits.length; j++) {
                result[j+1] = digits[j];
            }

            return result;
        } else {
            return digits;
        }
    }
}
