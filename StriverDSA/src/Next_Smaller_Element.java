import java.util.*;

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