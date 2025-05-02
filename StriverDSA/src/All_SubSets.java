import java.util.*;

class All_SubSets {

    public void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // base condition
        // Add current combination to the final result list
        result.add(new ArrayList<>(current));

        // i start from index and not from 0 and till all remaining elements of nums
        for (int i=index;i<nums.length;i++) {
            // Add nums[i] to current list (with current element)
            current.add(nums[i]);
            // Move to the next element
            backtrack(i+1, nums, current, result);
            // remove last added to check without combination (without current element)
            current.remove(current.size()-1);

        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        // final result array
        List<List<Integer>> result = new ArrayList<>();
        // start with index 0, List<Integer> current to store current array
        backtrack(0,nums,new ArrayList<>(), result);

        return result;
    }

    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
        All_SubSets allSubsets = new All_SubSets();
        List<List<Integer>> subsets = allSubsets.subsets(nums);
        System.out.println("Subsets: " + subsets);
    }
}