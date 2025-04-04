class Kadane {
    /**
     * max sum subarray using Kadane's algorithm
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        // variable sum and maxSum
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0;i<nums.length;i++) {
            sum = sum + nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }

            //if sum goes negative reset the sum
            if (sum < 0) {
                sum = 0;
            }
        }


        return maxSum;

    }
}