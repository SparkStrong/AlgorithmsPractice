package swordRefersOffer;

import java.util.HashMap;

public class Question35 {

    public static char firstNotRepeatChar(String str) {
        HashMap<Character, Integer> charNum = new HashMap<>();
        char[] strChars = str.toCharArray();

        for (int i = 0; i < strChars.length; i++) {
            if (charNum.containsKey(strChars[i])) {
                charNum.put(strChars[i], charNum.get(strChars[i]) + 1);
            } else {
                charNum.put(strChars[i], 1);
            }
        }

        for (int i = 0; i < strChars.length; i++) {
            if (charNum.get(strChars[i]) == 1) {
                return strChars[i];
            }
        }

        return '\0';
    }

    public static char firstNotRepeatChar2(String str) {
        char[] strChars = str.toCharArray();
        int[] nums = new int[256];

        for (int i = 0; i < 256; i++) {
            nums[i] = 0;
        }

        for (char ch: strChars) {
            nums[ch]++;
        }

        for (char ch: strChars) {
            if (nums[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }
}
