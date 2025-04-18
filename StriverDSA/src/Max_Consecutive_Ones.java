import java.util.*;

class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int result = 0;

        for (int i=0;i<n;i++) {
            if (nums[i] == 1) {
                maxLen++;
                result = Math.max(maxLen,result);
            } else {
                maxLen = 0;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nums = {1,1,0,0,1,1,1};

        Max_Consecutive_Ones maxConsecutiveOnes = new Max_Consecutive_Ones();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
}