package p39.CombinationSum;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> solutionList = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return solutionList;
        dfs(candidates, target, solutionList, solution);
        return solutionList;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> solutionList, List<Integer> solution) {
        if (target < 0) return;
        else if (target == 0) {
            solutionList.add(new ArrayList(solution));
            return;
        } else {
            for (int i = 0; i < candidates.length; i++) {
                solution.add(candidates[i]);
                dfs(candidates, target - candidates[i], solutionList, solution);
                solution.remove(solution.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}






