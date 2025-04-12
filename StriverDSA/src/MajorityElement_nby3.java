import java.util.*;

class MajorityElement_nBy3 {
    public List<Integer> majorityElement(int[] nums) {

        // As there can be maximum 2 candidates with more than n/3 times,
        // use two variables and counters to keep track of potential candidates

        int count1 = 0;
        int count2 = 0;

        Integer element1 = null;
        Integer element2 = null;

        int n = nums.length;

        for (int i=0;i<nums.length;i++) {
            if (element1 != null && element1 == nums[i]) {
                count1++;
            } else if (element2 != null && element2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                element1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                element2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        //Verify potential candidates again
        count1 = 0;
        count2 = 0;
        for (int i =0;i<n;i++) {
            if (element1 != null && nums[i]== element1) count1++;
            else if (element2 != null && nums[i] == element2) count2++;
        }


        List<Integer> res = new ArrayList<>();

        if (count1 > n/3) {
            res.add(element1);
        }
        if (count2 > n/3) {
            res.add(element2);
        }

        return res;
    }
}