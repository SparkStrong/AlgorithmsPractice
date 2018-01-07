package leetcode;

import java.util.Arrays;

/**
 * Created by Nack on 2017/11/6.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int pos = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            Arrays.sort(nums);
        } else {
            for (int i = nums.length - 1; i > pos; i--) {
                if (nums[i] > nums[pos]) {
                    int tmp = nums[pos];
                    nums[pos] = nums[i];
                    nums[i] = tmp;
                    break;
                }
            }

            Arrays.sort(nums, pos + 1, nums.length);
        }
    }
}
