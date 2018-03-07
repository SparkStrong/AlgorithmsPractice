package swordRefersOffer;

public class Question34 {
    public static boolean isUgly(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public static int getUglyNum(int index) {
        if (index <= 0) {
            return 0;
        }

        int num = 0;
        int uglyFlag = 0;

        while (uglyFlag < index) {
            num ++;

            if (isUgly(num)) {
                uglyFlag ++;
            }
        }

        return num;
    }

    public static int getUglyNum2(int index) {
        if (index < 0) {
            return 0;
        }

        int[] result = new int[index];
        result[0] = 1;
        int cur = 1, m2 = 0, m3 = 0, m5 = 0;
        while (cur < index) {
            result[cur] = minNum(result[m2]*2, result[m3]*3, result[m5]*5);

            while (result[m2]*2 <= result[cur]) {
                m2++;
            }

            while (result[m3]*3 <= result[cur]) {
                m3++;
            }

            while (result[m5]*5 <= result[cur]) {
                m5++;
            }
            cur++;
        }

        return result[index-1];
    }

    private static int minNum(int i, int j, int k) {
        int tmp = i < j ? i: j;
        return tmp < k ? tmp: k;
    }

    public static void main(String[] args) {
        int num = getUglyNum(1500);
        int num2 = getUglyNum2(1500);

        System.out.println(num);
        System.out.println(num2);
    }
}