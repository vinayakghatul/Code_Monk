class Sort_0_1_2 {
    public void sortColors(int[] nums) {

        // three variables to count 0,1,2

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int i =0;i<nums.length;i++) {
            if(nums[i] == 0) {
                zeros++;
            } else if (nums[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        for (int j=0;j<zeros;j++) {
            nums[j] = 0;
        }
        for (int j= zeros;j<zeros+ones;j++) {
            nums[j] = 1;
        }
        for (int j = zeros+ones;j<zeros+ones+twos;j++) {
            nums[j] = 2;
        }
    }

    public void sortNums(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap low and mid
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                // swap mid and high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }

        for (int i = 0;i< nums.length;i++) {
            System.out.println(nums[i]);
        }

    }

    public static void main(String[] args) {

        Sort_0_1_2 sortNums = new Sort_0_1_2();

        int[] nums = {2,1,0,2,1,2,2,0};
        sortNums.sortNums(nums);
    }
}