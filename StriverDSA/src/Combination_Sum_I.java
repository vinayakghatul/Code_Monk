import java.util.*;

class Combination_Sum_I {

    /**
     * Given an array of distinct integers candidates and a target integer target,
     * return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
     *
     * The same number may be chosen from candidates an unlimited number of times.
     * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
     *
     * The test cases are generated such that the number of unique combinations
     * that sum up to target is less than 150 combinations for the given input.
     */

    public void backtrack(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> result) {

        // base condition
        if (target == 0) {
            // we have path which satisfies the condition of target sum
            // add it to the result
            result.add(new ArrayList<>(path));
            return;
        }

        // if we overshoot the target or checked all the candidates
        if (target < 0 || index >= candidates.length) {
            return;
        }

        // try adding candidate to the path
        path.add(candidates[index]);
        // backtrack to check if same element fulfills the target (repetitive addition of same number)
        backtrack(candidates, target-candidates[index], index, path, result);
        // remove the last added and check for the next index
        path.remove(path.size()-1);

        backtrack(candidates, target, index+1,path,result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        for (List<Integer> row : result) {
            for (int i=0;i<row.size();i++) {
                System.out.print(row.get(i) + " ");
            }
            System.out.println(" ");
        }

        return result;
    }

    public static void main(String args[]) {
        int[] candidates = {2,3,6,7};
        int target = 7;

        Combination_Sum_I combinationSum = new Combination_Sum_I();
        combinationSum.combinationSum(candidates, target);
    }
}