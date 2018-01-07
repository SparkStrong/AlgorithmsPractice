package leetcode;

import java.util.Arrays;

/**
 * Created by Nack on 2017/10/16.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int tmpSum = nums[left] + nums[right] + nums[i];
                if (tmpSum == target) {
                    return target;
                } else if (tmpSum < target) {
                    left++;
                } else {
                    right--;
                }

                if (shouldUpdate(target, result, tmpSum)) {
                    result = tmpSum;
                }
            }
        }

        return result;
    }

    private boolean shouldUpdate(int target, int oldSum, int newSum) {
        if (Math.abs(target-newSum) < Math.abs(target-oldSum)) {
            return true;
        } else {
            return false;
        }
    }
}
