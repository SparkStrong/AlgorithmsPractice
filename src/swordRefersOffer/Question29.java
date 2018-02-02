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

    /**
     * 检查给定的value在数组中出现的次数是否大于等于一半
     * @param nums 数组
     * @param value 给定的数字
     * @return 如果大于等于一半返回true，否则返回false
     */
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


    /**
     * 根据数字出现超过一半的特性来进行查找，出现超过一半则它出现的次数超过其他数字的总和
     * @param nums 数组
     * @return 出现超过一半的数
     */
    public int moreThanHalfNum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int times = 0;
        int value = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                value = nums[i];
                times ++;
            } else if (value == nums[i]) {
                times ++;
            } else {
                times--;
            }
        }

        if (!checkMoreThanHalf(nums, value)) {
            return -1;
        }

        return value;
    }
}
