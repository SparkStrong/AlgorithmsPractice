package swordRefersOffer;

import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.util.LinkedList;
import java.util.List;

public class Question12 {

    public static void printNum(int n) {
        String num = "0";
        while (true) {
//            System.out.println(num);
            num = increment(num);
            if (num.length() > n) {
                break;
            }
        }
        System.out.println(num);
    }

    private static String increment(String num) {
        char[] numChar = num.toCharArray();
        char carry = '0';

        int tmp = numChar[numChar.length-1] - '0' + 1;
        if (tmp < 10) {
            numChar[numChar.length-1]++;
        } else {
            carry = '1';
            numChar[numChar.length-1] = '0';
            for (int i = numChar.length-2; i >= 0; i--) {
                tmp = numChar[i] - '0' + carry - '0';
                if (tmp == 10) {
                    numChar[i] = '0';
                    carry = '1';
                } else {
                    numChar[i]++;
                    carry = '0';
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (carry == '1') {
            sb.append('1');
        }

        for (char ch: numChar) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        printNum(9);
    }
}
