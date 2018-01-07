package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/10/13.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);

        for (int i= 0; i < nums.length-3; i++) {
            for (int j = nums.length-1; j > i+2; j--) {
                if ((i > 0 && nums[i] == nums[i-1]) || (j < nums.length-1  && nums[j] == nums[j+1])) {
                    continue;
                }

                int left = i + 1, right = j - 1;
                int sum = target - nums[i] - nums[j];

                while (left < right) {
                    if (nums[left] + nums[right] == sum) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right], nums[j]));
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] < sum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,4,-5,2,-2,4,2,-1,4};
        int target = 12;

        List<List<Integer>> result = fourSum(nums, target);

        System.out.println(result.toString());
    }
}
