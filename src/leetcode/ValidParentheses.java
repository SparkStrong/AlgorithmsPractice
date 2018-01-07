package leetcode;

import java.util.Stack;

/**
 * Created by Nack on 2017/9/24.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character ch: chs) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character topChar = stack.peek();
                if (ch == ')' && topChar == '(') {
                    stack.pop();
                } else if (ch == ']' && topChar == '[') {
                    stack.pop();
                } else if (ch == '}' && topChar == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
