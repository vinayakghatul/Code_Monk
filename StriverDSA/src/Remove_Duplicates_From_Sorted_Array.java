class Remove_Duplicates_From_Sorted_Array {
    public int removeDuplicates(int[] nums) {

        // base case
        if (nums.length == 0) {
            return 0;
        }

        // left pointer to track unique elements
        int left = 0;

        for (int right = 1;right<nums.length;right++) {

            // If we find the next unique element then move left++ and move that unique element to left
            if (nums[left]!= nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }

        // return length and not index of the array of unique sorted elements
        return left+1;

    }

    public static void main(String args[]) {
        int[] nums = {1,1,2,2,3,3,3};

        Remove_Duplicates_From_Sorted_Array removeDuplicatesFromSortedArray = new Remove_Duplicates_From_Sorted_Array();

        int index = removeDuplicatesFromSortedArray.removeDuplicates(nums);

        for (int i=0;i<index;i++) {
            System.out.print(nums[i] + " ");
        }
    }
}