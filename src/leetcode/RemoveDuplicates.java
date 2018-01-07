package leetcode;

/**
 * Created by Nack on 2017/10/25.
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int pos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        return pos;
    }
}
