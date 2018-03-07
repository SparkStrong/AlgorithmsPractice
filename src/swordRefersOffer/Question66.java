package swordRefersOffer;

import java.lang.reflect.Method;

/**
 * 给定一个二维数组，每一行从左到右递增，每一列从上到下递增，判断给定的k是否在数组中
 * 特殊起点在右上和左下
 *
 * 如果数组是从左到右递减，从上到下递减
 * 特殊起点在左上和右下
 *
 * -----> 这       这<--------
 * \                        \
 * \ 增                     \从上到下增
 * \                        \
 * 这                       这
 *
 * 数组从左到右递增，从下到上递增
 * 特殊点在左上和右下
 *
 */
public class Question66 {

    /**
     * 从右上角开始进行查找，如果arr[i][j] 小于k,则排除这一行，如果k小于arr[i][j]则排除这一列
     * @param arr 二维数组
     * @param k 要查找的值
     * @return 存在返回true
     */
    public static boolean findNum(int[][] arr, int k) {
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        int i = 0, j = arr[0].length - 1;
        while (i < arr.length && j >= 0) {
            if (k == arr[i][j]) {
                return true;
            } else if (k < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,7},
                {3,5,6,8},
                {4,7,8,9},
                {6,8,10,12}
        };

        int k = 11;

        if (findNum(arr, k)) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}
