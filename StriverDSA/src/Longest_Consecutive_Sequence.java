import java.util.*;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

class Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {

        // using hashset for lookups
        Set<Integer> hs = new HashSet<>();

        int cnt = 0;
        int longest = 0;

        for (int i=0;i<nums.length;i++) {
            hs.add(nums[i]);
        }

        for (int num : hs) {
            // if num is the first element is the sequence
            if (!hs.contains(num-1)) {
                cnt = 1;
                int x = num;

                while(hs.contains(x+1)) {
                    cnt++;
                    x = x+1;
                }
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }

    public static void main(String args[]) {
        int[] nums = {100,4,20,3,1,2};

        Longest_Consecutive_Sequence longestConsecutiveSequence = new Longest_Consecutive_Sequence();

        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }
}