package leetcode;

/**
 * Created by Nack on 2017/12/13.
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], maxNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNow = Math.max(maxNow + nums[i], nums[i]);
            maxSum = Math.max(maxSum, maxNow);
        }

        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum[i-1] > 0) {
                sum[i] = sum[i-1] + nums[i];
            } else {
                sum[i] = nums[i];
            }
        }

        int maxSub = sum[0];
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] > maxSub) {
                maxSub = sum[i];
            }
        }

        return maxSub;
    }

    public int maxSubArray3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maxSub = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            maxSub = Math.max(maxSub, dp[i]);
        }

        return maxSub;
    }
}
