class Binary_Search_Recursive {

    public int binarySearch(int[] nums, int low, int high, int target) {

        int mid = low + (high - low)/2;

        if (low <= high) {
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                return binarySearch(nums, low, mid-1,target);
            } else {
                return binarySearch(nums, mid+1, high, target);
            }
        } else {
            return -1;
        }
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public static void main(String args[]) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        Binary_Search_Recursive binarySearchRecursive = new Binary_Search_Recursive();

        System.out.println(binarySearchRecursive.search(nums, target));
    }
}