package leetcode;

/**
 * Created by Nack on 2017/12/19.
 */
public class JumpGame55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int zeroIndex = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                zeroIndex = Math.max(i, zeroIndex);
                for (; i >= 0; i--) {
                    if (zeroIndex == nums.length - 1) {
                        if (nums[i] >= (zeroIndex - i)) {
                            zeroIndex = -1;
                            break;
                        }
                    } else {
                        if (nums[i] > (zeroIndex - i)) {
                            zeroIndex = -1;
                            break;
                        }
                    }
                }
            }
        }

        if (zeroIndex == -1) {
            return true;
        } else {
            return false;
        }
    }
}
