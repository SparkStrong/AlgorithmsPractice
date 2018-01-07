package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nack on 2017/11/15.
 */
public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        getResult(results, new LinkedList<Integer>(), candidates, target, 0);
        return results;
    }

    private void getResult(List<List<Integer>> results, List<Integer> curResult, int[] candidates, int target, int start) {
        if (target == 0) {
            results.add(new LinkedList<Integer>(curResult));
        } else if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                curResult.add(candidates[i]);
                getResult(results, curResult, candidates, target - candidates[i], i);
                curResult.remove(curResult.size() - 1);
            }
        }
    }
}
