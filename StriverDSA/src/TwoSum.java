import java.util.*;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        int[] res = new int[2];

        for (int i=0;i<nums.length;i++) {
            if (mp.containsKey(target - nums[i])) {
                res[0] = mp.get(target - nums[i]);
                res[1] = i;
                break;
            } else {
                mp.put(nums[i], i);
            }
        }
        return res;
    }
}