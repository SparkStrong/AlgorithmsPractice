package leetcode;

/**
 * Created by Nack on 2017/12/7.
 */
public class ImplementStrStr28 {
    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String needle) {
        if (needle.length() == 0) {
            return new int[needle.length()];
        }

        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;

        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(j) == needle.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "lle";
        int pos = strStr(haystack, needle);
        System.out.println(pos);
    }
}
