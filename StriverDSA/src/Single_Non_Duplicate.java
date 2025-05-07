class Single_Non_Duplicate {
    public int singleNonDuplicate(int[] nums) {

        // using XOR
        int xor = 0;

        for (int i=0;i<nums.length;i++) {
            xor=xor^nums[i];
        }
        return xor;
    }

    public static void main(String args[]) {
        int[] nums = {1,1,3,3,4,5,5,7,7,8,8};

        Single_Non_Duplicate singleNonDuplicate = new Single_Non_Duplicate();

        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
    }
}