import java.util.*;

class Missing_Number {
    public int missingNumber(int[] nums) {

        int sum = 0;

        int n = nums.length;

        for (int i=0;i<n;i++) {
            sum+=nums[i];
        }
        return (n*(n+1)/2)-sum;
    }

    public static void main(String args[]) {
        int[] nums = {0,3,1};
        Missing_Number missingNumber = new Missing_Number();

        System.out.println(missingNumber.missingNumber(nums));
    }
}