import java.util.*;
class Three_Sum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<nums.length-2;i++) {
            int j = i+1;
            int k = nums.length -1;

            // Ignore duplicates in the array
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // add to the solution
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);

                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;

    }
}