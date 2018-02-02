package swordRefersOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question30 {

    public static List<Integer> getLeastNums(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();

        if (nums == null || k > nums.length) {
            return null;
        }

        int left = 0, right = nums.length - 1;
        int index = partition(nums, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
                index = partition(nums, left, right);
            } else {
                left = index + 1;
                index = partition(nums, left, right);
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(nums[i]);
        }

        IntStream numStream = Arrays.stream(nums);
        List<Integer> tmp = numStream.boxed().limit(k).collect(Collectors.toList());
        tmp.forEach(e -> System.out.println("e = " + e));

        return res;
    }

    private static int partition(int[] nums, int start, int end)  {
        if (nums == null || start < 0 || end > nums.length) {
            return -1;
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

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static List<Integer> getLeastNums2(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();

        TreeSet<Integer> kset = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (kset.size() < k) {
                kset.add(nums[i]);
            } else {
                if (nums[i] < kset.last()) {
                    kset.pollLast();
                    kset.add(nums[i]);
                }
            }
        }

        res.addAll(kset);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 34, 5, 6, 8, 9, 1, 20, 30};

        List<Integer> res = getLeastNums2(nums, 2);

        res.stream().forEach(System.out::println);
    }
}
