import java.util.*;

class Subset_Sums {

    public void backtrack(int index, int[] nums, int sum, List<Integer> result) {

        result.add(sum);

        for (int i=index;i<nums.length;i++) {
            sum= sum + nums[i];
            backtrack(i+1, nums, sum, result);
            sum= sum - nums[i];
        }

    }

    public List<Integer> subsetSums(int[] nums) {
        //your code goes here
        List<Integer> result = new ArrayList<>();

        backtrack(0,nums,0,result);

        return result;
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3};

        Subset_Sums subset_sums = new Subset_Sums();

        System.out.println(subset_sums.subsetSums(nums));
    }
}