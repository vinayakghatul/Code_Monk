import java.util.*;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such
 * that the sum of the elements in both subsets is equal or false otherwise.
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */

class Subset_Sum {

    /**
     * This is variation of subset sum, where instead of target, we have
     * to calculate total sum and divide into two parts as keep it as target
     * @param nums
     * @return
     */
    public boolean isPartitionPossible(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String args[]) {
        int[] nums = {1,5,11,5};
        Subset_Sum subsetSum = new Subset_Sum();

        System.out.println(subsetSum.isPartitionPossible(nums));
    }
}