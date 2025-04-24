class Binary_Search_Iterative {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            // safer way to calculate mid
            int mid = low + (high - low)/2;

            // check if mid is the target
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        Binary_Search_Iterative binarySearchIterative = new Binary_Search_Iterative();

        System.out.println(binarySearchIterative.search(nums, target));
    }
}