package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/10/20.
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generate(result, "", 0, 0, n);
        return result;
    }

    public static void generate(List<String> result, String str, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }

        if (right > left) {
            return;
        }

        if (left < n) {
            String s = str + "(";
            generate(result, s, left+1, right, n);
        }

        if (right < n) {
            String s = str + ")";
            generate(result, s, left, right+1, n);
        }
    }

    public static void main(String[] args) {
//        int n = 3;
//        List<String> res = generateParenthesis(n);
//
//        for (String tmp: res) {
//            System.out.println(tmp);
//        }

//        long num = Integer.MIN_VALUE;
//        num = -num;
//
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(num);
        int[] nums = {1, 2};
        for (int i = 2; i < nums.length; i++) {
            System.out.println("i = " + i);
        }
    }
}
