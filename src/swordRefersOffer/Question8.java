package swordRefersOffer;

/**
 * Created by Nack on 2017/11/7.
 */

/**
 * 旋转数组中查找最小的数
 * 借鉴二分查找
 */
public class Question8 {
    public static int minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int left = 0, right = nums.length - 1;
        int mid = left;  // 可能一开始数组就是递增的，并没有经过旋转
        while (nums[left] >= nums[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = (left + right) / 2;

            // 如果left、mid、right三者都相等，则无法判定最小数是在left与mid之间还是mid与right之间
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return minNumberOrder(nums, left, right);
            }

            if (nums[left] <= nums[mid]) {
                left = mid;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }

        return nums[mid];
    }

    /**
     *顺序查找最小的数
     * @param nums 数组
     * @param begin 起始index
     * @param end 终止Index
     * @return 最小的数
     */
    public static int minNumberOrder(int[] nums, int begin, int end) {
        int res = nums[begin];
        for (int i = begin + 1; i <= end; i++) {
            if (res > nums[i]) {
                res = nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1,1};
        int res = minNumber(nums);

        System.out.println(res);
    }
}
