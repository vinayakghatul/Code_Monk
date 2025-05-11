class Jump_Game_2 {
    public int jump(int[] nums) {

        // max reachable index
        int maxReach = 0;

        // current reached index
        int currReach = 0;

        // min jumps so far required
        int jump = 0;

        // no need to check jump from last index, hence for loop till n-1 index
        for (int i=0;i<nums.length-1;i++) {
            // updates maxReach for current index
            maxReach = Math.max(maxReach,i + nums[i]);

            if (i == currReach) {
                jump++;
                currReach = maxReach;
            }
        }

        return jump;
    }

    public static void main(String args[]) {
        int[] nums = {2,3,1,1,4};

        Jump_Game_2 jumpGame = new Jump_Game_2();

        System.out.println(jumpGame.jump(nums));
    }
}