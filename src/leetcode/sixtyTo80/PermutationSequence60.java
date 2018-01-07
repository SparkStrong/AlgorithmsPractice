package leetcode.sixtyTo80;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/12/21.
 */
public class PermutationSequence60 {
    public static String getPermutation(int n, int k) {
        int[] arrangNum = new int[n+1];  // An,n ,全排列
        List<Integer> nums = new LinkedList<>(); // 1...n
        StringBuilder result = new StringBuilder();

        arrangNum[0] = 1;
        for (int i = 1; i <= n; i++) {
            arrangNum[i] = arrangNum[i-1] * i;
            nums.add(i);
        }

        k--;  // 简化处理k%arrangNum[n-i] == 0的情形
        for (int i = 1; i <= n; i++) {
            int index = k / arrangNum[n-i];
            result.append(nums.get(index));
            nums.remove(index);

            k -= index * arrangNum[n-i];
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String result = getPermutation(3, 3);

        System.out.println(result);
    }
}
