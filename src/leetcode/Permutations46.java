package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/12/13.
 * 给出一串数字的全排列，不含有重复数字
 */
public class Permutations46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new LinkedList<>();
        backtrack(resultList, new LinkedList<>(), nums);

        return resultList;
    }

    public static void backtrack(List<List<Integer>> resultList, List<Integer> candidateList, int[] nums) {
        if (candidateList.size() == nums.length) {
            resultList.add(new ArrayList<Integer>(candidateList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (candidateList.contains(nums[i])) {
                    continue;
                }
                candidateList.add(nums[i]);
                backtrack(resultList, candidateList, nums);
                candidateList.remove(candidateList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);

        for (List<Integer> tmp: result) {
            System.out.println(tmp);
        }
    }
}
