class MajorityElement {
    public int majorityElement(int[] nums) {

        int element = nums[0];
        int count = 0;

        for (int i=0;i<nums.length;i++) {
            if (count == 0) {
                element = nums[i];
                count++;
            } else if (element == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return element;

    }
}