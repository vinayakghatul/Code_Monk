import java.util.Arrays;

class MergeSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         right pointer at m-1, left pointer and 0;
         move right-- and left++ until nums1[right] > nums2[left], swap at each success condition
         now all the large elements are in nums2 and smaller are in nums1
         now concat both
         */

        int right = m-1;
        int left = 0;

        while(right >=0 && left < n) {
            if (nums1[right] > nums2[left]) {
                int temp = nums1[right];
                nums1[right] = nums2[left];
                nums2[left] = temp;
                right--;
                left++;
            } else {
                break;
            }
        }

        /**
         Now merge two arrays with extra space in nums1
         Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
         Output: [1,2,2,3,5,6]
         Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
         The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
         */
        Arrays.sort(nums1,0,m);
        Arrays.sort(nums2);
        int j = 0;
        for (int i=m;i<m+n;i++) {
            nums1[i] = nums2[j];
            j++;
        }

        for (int i=0;i<nums1.length;i++) {
            System.out.println(nums1[i] + " ");
        }
        return;
    }

    public static void main(String args[]) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, nums2.length);
    }
}