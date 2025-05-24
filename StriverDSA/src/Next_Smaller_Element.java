import java.util.*;

/**
 * Given an array, print the Next Smaller Element (NSE) for every element.
 * The NSE for an element x is the first smaller element on the right side of x in the array.
 * For elements for which no smaller element exists (on the right side), then consider NSE as -1.
 *
 * Examples:
 *
 * Input: [4, 8, 5, 2, 25]
 * Output: [2, 5, 2, -1, -1]
 * Explanation:
 * The first element smaller than 4 having index > 0 is 2.
 * The first element smaller than 8 having index > 1 is 5.
 * The first element smaller than 5 having index > 2 is 2.
 * There are no elements smaller than 4 having index > 3.
 * There are no elements smaller than 4 having index > 4.
 */

class Next_Smaller_Element {

    public int[] nextSmallerElement(int[] nums) {

        int n = nums.length;
        Stack<Integer> stk = new Stack<>();

        int[] result = new int[n];

        for (int i=n-1;i>=0;i--) {

            while (!stk.isEmpty() && stk.peek() >= nums[i]) {
                stk.pop();
            }
            result[i] = stk.isEmpty() ? -1 : stk.peek();

            stk.push(nums[i]);
        }

        return result;

    }

    public static void main(String args[]) {

        int[] nums = {4, 8, 5, 2, 25};

        Next_Smaller_Element nextSmallerElement = new Next_Smaller_Element();
        System.out.println(Arrays.toString(nextSmallerElement.nextSmallerElement(nums)));
    }
}