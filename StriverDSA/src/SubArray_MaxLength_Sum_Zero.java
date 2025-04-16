import java.util.*;
class SubArray_MaxLength_Sum_Zero {

    int maxLen(int arr[]) {

        // sum - prefix sum
        // map to store prefix sum and its index
        // maxLen to track max length found so far

        // Keep on calculating prefix sum for each index and store it in map
        // For each prefix sum, check if it exists in map
        // If it does then current index sum - found index sum is zero and maxLength can be updated
        // If prefix sum at any index is zero then compare with maxLen and update.

        int n = arr.length;
        int[] sum = new int[n];
        Map<Integer, Integer> mp = new HashMap<>();
        int maxLen = 0;

        for (int i=0;i<n;i++) {
            if (i==0) {
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i-1] + arr[i];
            }

            if (sum[i] == 0) {
                maxLen = i + 1;
            }

            if (mp.containsKey(sum[i])) {
                maxLen = Math.max(maxLen,i-mp.get(sum[i]));
            } else {
                mp.put(sum[i], i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) throws Exception {
        SubArray_MaxLength_Sum_Zero sol = new SubArray_MaxLength_Sum_Zero();

        // Sample input
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int result = sol.maxLen(arr);
        System.out.println("Maximum length of subarray with sum 0: " + result);
    }
}