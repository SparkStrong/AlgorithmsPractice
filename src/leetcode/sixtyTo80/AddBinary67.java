package leetcode.sixtyTo80;

/**
 * Created by Nack on 2018/1/3.
 */
public class AddBinary67 {
    public String addBinary(String a, String b) {
        char[] ch1s = a.toCharArray();
        char[] ch2s = b.toCharArray();
        StringBuilder result = new StringBuilder();

        int i = ch1s.length - 1;
        int j = ch2s.length - 1;
        int carry = 0;

        for (; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            if (i >= 0) {
                sum += ch1s[i] - '0';
            }

            if (j >= 0) {
                sum += ch2s[j] - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}
