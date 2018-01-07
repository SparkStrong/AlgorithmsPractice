package swordRefersOffer;


/**
 * Created by Nack on 2017/12/25.
 */
public class Question29 {

    public int moreThanHalfNum(int[] nums) {
//            throws Exception{
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int mid = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        try {
            int index = partition(nums, start, end);

            while (index != mid) {
                if (index > mid) {
                    end = index - 1;
                    index = partition(nums, start, end);
                } else {
                    start = index + 1;
                    index = partition(nums, start, end);
                }
            }
        } catch (Exception e) {
//            throw new Exception(e);
            System.out.println(e.toString());
        }

        int result = nums[mid];
        if (!checkMoreThanHalf(nums, result)) {
            return -1;
        }

        return result;
    }

    private int partition(int[] nums, int start, int end) throws Exception {
        if (nums == null || start < 0 || end > nums.length) {
            throw new Exception("Invalid parameters!");
        }

        int index = start + (int)(Math.random() * (end - start + 1));
        swap(nums, end, index);
        int base = nums[end];

        int pos = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < base) {
                if (i != pos) {
                    swap(nums, i, pos);
                }
                pos++;
            }
        }

        swap(nums, pos, end);

        return pos;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private boolean checkMoreThanHalf(int[] nums, int value) {
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                times++;
            }
        }

        if (times << 1 <= nums.length) {
            return false;
        }

        return true;
    }
}
