package leetcode.sixtyTo80;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Nack on 2018/1/3.
 */
public class SimplifyPath71 {
    public static String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str: strs) {
            if (str.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (str.equals(".") || str.equals("")) {
                continue;
            } else {
                stack.push(str);
            }
        }

        StringBuilder result = new StringBuilder();
        LinkedList<String> res = new LinkedList<>();

        if (stack.empty()) {
            res.addFirst("/");
        }

        while (!stack.empty()) {
            res.addFirst(stack.pop());
            res.addFirst("/");
        }

        for (String tmp: res) {
            result.append(tmp);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String path = "///////";
        String result = simplifyPath(path);

        System.out.println(result);
    }
}
