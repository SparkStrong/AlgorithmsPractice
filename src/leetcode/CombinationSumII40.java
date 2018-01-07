package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/11/15.
 */
public class CombinationSumII40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        getResult(results, new LinkedList<Integer>(), candidates, target, 0);
        return results;
    }

    private static void getResult(List<List<Integer>> results, List<Integer> curResult, int[] candidates, int target, int start) {
        if (target == 0) {
            results.add(new LinkedList<Integer>(curResult));
        } else if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                if (i > start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                curResult.add(candidates[i]);
                getResult(results, curResult, candidates, target - candidates[i], i + 1);
                curResult.remove(curResult.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
//        int target = 8;
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> result = combinationSum2(candidates, target);

        System.out.println(result);
    }
}
