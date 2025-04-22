import java.util.*;

class All_Permutations {

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            // Add new generated combination to result
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i=0;i<nums.length;i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }

            // tempList stores current partial permutation, once its equal to nums.length add it to result
            tempList.add(nums[i]);
            backtrack(result, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        // To store the final result
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new ArrayList<>(), nums);

        return result;
    }

    public static void main(String args[]) {

        int[] nums = {1,2,3};

        All_Permutations allPermutations = new All_Permutations();
        List<List<Integer>> results = allPermutations.permute(nums);

        for (List<Integer> res :  results) {
            System.out.println(res.size());
        }
    }
}