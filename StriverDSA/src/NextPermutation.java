class NextPermutation {

    public int[] reverse(int[] nums, int start, int end) {

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        return nums;
    }

    public void nextPermutation(int[] nums) {

        // find the pivot point from right to left, say i (nums[i] < nums[i+1])

        // for (i+1 to n-1) find smallest number greater than nums[i]

        // swap them

        // To get the immediate next smallest permutation reverse Subarrya -> nums(i+1, n-1)

        int n = nums.length;

        int pivot = -1;

        for (int i=n-2;i>=0;i--) {
            if (nums[i] < nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            // return reversed list
            reverse(nums,0,n-1);

            return;
        }

        for (int j=n-1;j>pivot;j--) {
            if (nums[j] > nums[pivot]) {
                //swap with this smallest number greater than pivot
                int temp = nums[j];
                nums[j] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        reverse(nums,pivot+1,n-1);
        return;
    }
}