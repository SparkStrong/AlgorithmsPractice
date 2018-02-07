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

    public static void main(String[] args) {
        int num = getUglyNum(1500);

        System.out.println(num);
    }
}