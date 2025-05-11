/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 */

class Jump_Game_2 {
    public int jump(int[] nums) {

        // max reachable index
        int maxReach = 0;

        // current reached index
        int currReach = 0;

        // min jumps so far required
        int jump = 0;

        // no need to check jump from last index, hence for loop till n-1 index
        for (int i=0;i<nums.length-1;i++) {
            // updates maxReach for current index
            maxReach = Math.max(maxReach,i + nums[i]);

            if (i == currReach) {
                jump++;
                currReach = maxReach;
            }
        }

        return jump;
    }

    public static void main(String args[]) {
        int[] nums = {2,3,1,1,4};

        Jump_Game_2 jumpGame = new Jump_Game_2();

        System.out.println(jumpGame.jump(nums));
    }
}