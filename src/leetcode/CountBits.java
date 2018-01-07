package leetcode;

/**
 * Created by Nack on 2017/7/12.
 */

import java.util.ArrayList;

/**
 * 常规解法：对0到n中每个元素进行1的计数
 * 优化解法：运用递归以及2的倍数的特性进行求解
 */

public class CountBits {
    public static int countNumOf1(int num) {
        int count = 0;
        int flag = 1;
        for(int i = 0; i < 32; i++) {
            if((num & flag) != 0) {
                count += 1;
            }
            flag = flag << 1;
        }

        return count;
    }

    public static int countNumOfOne(int num) {
        int count = 0;

        while (num != 0) {
            count ++;
            num = num & (num -1);
        }

        return count;
    }

    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 0; i <= num; i++) {
            int count = countNumOfOne(i);
            result[i] = count;
        }

        return result;
    }

    public static int[] countBits2(int num) {
        int[] result = new int[num+1];
        for(int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }

    public static void main(String[] args) {
//        int num = 5;
////        int result = countNumOfOne(num);
////        int[] result = countBits(num);
//        int[] result = countBits2(num);
//        for(int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }

        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(0, 1);
        tmp.add(0, 2);
        for(int i = 0; i < tmp.size(); i++) {
            System.out.println(tmp.get(i));
        }
    }
}
