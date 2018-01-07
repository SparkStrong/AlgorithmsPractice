package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Nack on 2017/12/8.
 */
public class MultiplyStrings43 {
    public static String multiply(String num1, String num2) {
        ArrayList<String> charMulStrRes = new ArrayList<>();
        for (int i = num2.length() - 1, j = 0; i >= 0; i--, j++) {
            String charMulStr = charMulStr(num1, num2.charAt(i));
            char[] zeroChs = new char[j];
            Arrays.fill(zeroChs, '0');
            charMulStr += new String(zeroChs);
            charMulStrRes.add(charMulStr);
        }

        String result = charMulStrRes.get(0);
        for (int i = 1; i < charMulStrRes.size(); i++) {
            result = strAddStr(result, charMulStrRes.get(i));
        }

        char[] resultChar = result.toCharArray();
        int indexNotZero = 0;
        for (; indexNotZero < resultChar.length; indexNotZero++) {
            if (resultChar[indexNotZero] != '0') {
                break;
            }
        }

        if (indexNotZero == resultChar.length) {
            return "0";
        }

        StringBuilder builder = new StringBuilder();
        for (; indexNotZero < resultChar.length; indexNotZero++) {
            builder.append(resultChar[indexNotZero]);
        }

        return builder.toString();
    }

    public static String strAddStr(String num1, String num2) {
        LinkedList<Character> charList = new LinkedList<>();
        char carry = '0';
        char value = '0';
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        char[] charAddRes;

        while (i >= 0 && j >= 0) {
            charAddRes = charsAdd(num1.charAt(i--), num2.charAt(j--), carry);
            value = charAddRes[1];
            carry = charAddRes[0];
            charList.addFirst(value);
        }

        if (i >= 0) { // num1的长度长于num2
            while (i >= 0) {
                charAddRes = charsAdd(num1.charAt(i--), '0', carry);
                value = charAddRes[1];
                carry = charAddRes[0];
                charList.addFirst(value);
            }
        } else if (j >= 0) { // num2的长度长于num1
            while (j >= 0) {
                charAddRes = charsAdd('0', num2.charAt(j--), carry);
                value = charAddRes[1];
                carry = charAddRes[0];
                charList.addFirst(value);
            }
        }

        if (carry != '0') {
            charList.addFirst(carry);
        }

        StringBuilder builder = new StringBuilder();
        for (Character tmp: charList) {
            builder.append(tmp);
        }

        return builder.toString();
    }

    public static char[] charsAdd(char ch1, char ch2, char carry) {
        char[] res = new char[2];
        int num = (ch1 - '0') + (ch2 - '0') + (carry - '0');
        if (num < 10) {
            res[0] = '0';
            res[1] = String.valueOf(num).toCharArray()[0];
        } else {
            res = String.valueOf(num).toCharArray();
        }

        return res;
    }

    public static String charMulStr(String num1, char ch) {
        LinkedList<Character> chs = new LinkedList<>();
        char carry = '0';
        char value = '0';
        char[] charMulRes;
        for (int i = num1.length() - 1; i > 0; i--) {
            charMulRes = charMul(ch, num1.charAt(i), carry);
            value = charMulRes[1];
            carry = charMulRes[0];
            chs.addFirst(value);
        }
        charMulRes = charMul(ch, num1.charAt(0), carry);
        value = charMulRes[1];
        carry = charMulRes[0];
        chs.addFirst(value);
        if (carry != '0') {
            chs.addFirst(carry);
        }

        StringBuilder builder = new StringBuilder();
        for (Character tmp: chs) {
            builder.append(tmp);
        }

        return builder.toString();
    }

    public static char[] charMul(char ch1, char ch2, char carry) {
        char[] res = new char[2];
        int num = (ch1 - '0') * (ch2 - '0') + (carry - '0');
        if (num < 10) {
            res[0] = '0';
            res[1] = String.valueOf(num).toCharArray()[0];
        } else {
            res = String.valueOf(num).toCharArray();
        }

        return res;
    }

    public static void main(String[] args) {
        String num2 = "123";
        String num1 = "012";

//        String r1 = charMulStr(num1, num2.charAt(2));
        String r2 = strAddStr(num1, num2);

        String r3 = multiply(num1, num2);

        System.out.println(r3);
    }
}
