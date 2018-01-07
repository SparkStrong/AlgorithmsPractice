package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/10/13.
 */
public class CombinationsPhoneNumber {
    /**
     * 比如输入是“23”，首先把2对应的 a b c 加入到List，然后再把d e f跟a b c进行组合，添加进去
     * @param digits 输入的数字字符串
     * @return 组合的所有可能的字符串列表
     */
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) {
            return result;
        }

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            while (result.peek().length() == i) {
                String old = result.pop();
                for (char ch : mapping[digit].toCharArray()) {
                    result.add(old + ch);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> res = letterCombinations(digits);
        System.out.println(res.toString());
    }
}
