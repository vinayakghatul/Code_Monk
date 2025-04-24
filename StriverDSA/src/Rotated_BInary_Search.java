import java.util.*;

class Rotated_Binary_Search {

    public int rotatedBinarySearch(int[] nums, int low, int high, int target) {

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        // check if left half is sorted
        if (nums[low] <= nums[mid]) {
            // check if target is in left half
            if (nums[low] <= target && target <= nums[mid]) {
                return rotatedBinarySearch(nums, low, mid-1, target);
            } else {
                return rotatedBinarySearch(nums, mid+1, high, target);
            }
        }

        // check if right half is sorted
        else {
            // check if target is in right half
            if (nums[mid] <= target && target <= nums[high]) {
                return rotatedBinarySearch(nums, mid+1, high, target);
            } else {
                return rotatedBinarySearch(nums, low, mid-1, target);
            }
        }
    }

    public int search(int[] nums, int target) {
        return rotatedBinarySearch(nums, 0, nums.length - 1, target);
    }

    public static void main(String args[]) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        Rotated_Binary_Search rotatedBinarySearch = new Rotated_Binary_Search();

        System.out.println(rotatedBinarySearch.search(nums, target));
    }
}