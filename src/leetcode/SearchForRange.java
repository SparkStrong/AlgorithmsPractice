package leetcode;

/**
 * Created by Nack on 2017/11/7.
 */
public class SearchForRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int left = 0, right = nums.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (nums[mid] < target) {
                left = mid + 1;
                mid = (left + right) / 2;
            } else if (nums[mid] > target) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                result[0] = searchLeft(nums, target, left, mid);
                result[1] = searchRight(nums, target, mid, right);
                break;
            }
        }

        return result;
    }

    public static int searchLeft(int[] nums, int target, int begin, int end) {
        int mid = (begin + end) / 2;
        while (begin < end) {
            // 左边的数小于target
            if (nums[mid] < target) {
                begin = mid + 1;
            } else { // 不是小于就必然是等于，因为不可能大于
                end = mid;
            }
            mid = (begin + end) / 2;
        }

        return begin;
    }

    public static int searchRight(int[] nums, int target, int begin, int end) {
        int mid = (begin + end) / 2;
        while (begin <= end) {
            // 右边的数大于target
            if (nums[mid] > target) {
                end = mid - 1;
            } else { // 不是大于就必然是等于，因为不可能小于
                if (begin + 2 <= nums.length) {
                    if (nums[begin + 1] != target) {
                        return begin;
                    } else {
                        begin = mid + 1;
                    }
                } else {
                    return begin;
                }
            }
            mid = (begin + end) / 2;
        }

        return end;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,2,2,2,2,3,3,4,4,4,5,6,6,6,7,8,8};
//        int target = 4;
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);

        System.out.println(res[0] + "---" + res[1]);
    }
}
