import java.util.*;

/**
 * Problem Statement: You are given a read-only array of N integers with
 * values also in the range [1, N] both inclusive. Each integer appears exactly
 * once except A which appears twice and B which is missing.
 * The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.
 *
 * Example 1:
 * Input Format:  array[] = {3,1,2,5,3}
 * Result: {3,4)
 * Explanation: A = 3 , B = 4
 * Since 3 is appearing twice and 4 is missing
 */

class Missing_Repeating_Number {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;

        int sumN = n*(n+1)/2;
        int sqSumN = n*(n+1)*(2*n+1)/6;

        int actualSum = 0;
        int actualSqSum = 0;


        for (int i=0;i<n;i++) {
            actualSum = actualSum + arr[i];
            actualSqSum = actualSqSum + (arr[i]*arr[i]);
        }

        // x-y
        int diff = sumN - actualSum;

        // x^2-y^2
        int sqDiff = sqSumN - actualSqSum;

        // x+y = x^2-y^2/x-y
        int temp = sqDiff/diff;

        int missing = (temp + diff)/2;
        int repeat = (temp - diff)/2;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeat);
        result.add(missing);

        return result;

    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 2, 4};
        Missing_Repeating_Number missingRepeatingNumber = new Missing_Repeating_Number();
        System.out.println(missingRepeatingNumber.findTwoElement(arr));
    }
}
