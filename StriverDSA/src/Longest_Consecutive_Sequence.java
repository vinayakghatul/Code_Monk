import java.util.*;

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