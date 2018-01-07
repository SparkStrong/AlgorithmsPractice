package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/12/13.
 * 给出一串数字的全排列，可能含有重复数字
 */
public class PermutationsII47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(resultList, new LinkedList<>(), nums, used);

        return resultList;
    }

    public static void backtrack(List<List<Integer>> resultList, List<Integer> candidateList, int[] nums, boolean[] used) {
        if (candidateList.size() == nums.length) {
            resultList.add(new ArrayList<Integer>(candidateList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                    continue;
                }
                candidateList.add(nums[i]);
                used[i] = true;
                backtrack(resultList, candidateList, nums, used);
                candidateList.remove(candidateList.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        List<List<Integer>> result = permuteUnique(nums);

        for (List<Integer> tmp: result) {
            System.out.println(tmp);
        }
    }
}
