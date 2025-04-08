class FindDuplicate {
    /**
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     *
     * There is only one repeated number in nums, return this repeated number.
     *
     * You must solve the problem without modifying the array nums and using only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     * Example 2:
     *
     * Input: nums = [3,1,3,4,2]
     * Output: 3
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {

        // start slow pointer with 1 step and fast pointer with 2 step.

        // from 0 first step -> nums[0]
        // from 0 2 steps -> nums[nums[0]]

        int slow = nums[0];
        int fast = nums[nums[0]];

        // until they meet -> keep moving fast and slow

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //reset fast to 0, and to get the duplicate number, move fast and slow by 1 step only.
        fast = 0;

        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // return either slow or fast, as they both point same number
        return slow;
    }

    public static void main(String args[]) {
        int nums[] = {1,3,4,2,2};

        int ans = findDuplicate(nums);
        System.out.println(ans);
    }
}