import java.util.*;

class Next_Greater_Element_Stack {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int k = nums1.length;
        int n = nums2.length;

        // To store final result
        int[] result = new int[k];

        // To store elements of parent array nums2
        Stack<Integer> stk = new Stack<>();

        // Map to store key values of element and its next greater element
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i=0;i<n;i++) {

            // For top element of stack, if current element of nums2[i] is greater then add pair to map
            while (!stk.isEmpty() && nums2[i] > stk.peek()) {
                mp.put(stk.pop(), nums2[i]);
            }

            // Push each element of nums2 to stack
            stk.push(nums2[i]);
        }

        while(!stk.isEmpty()) {
            mp.put(stk.pop(), -1);
        }

        // Generate final result array
        for (int i=0;i<k;i++) {
            result[i] = mp.get(nums1[i]);
            System.out.print(result[i] + " ");
        }

        return result;
    }

    public static void main(String args[]) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        Next_Greater_Element_Stack nextGreaterElement = new Next_Greater_Element_Stack();

        nextGreaterElement.nextGreaterElement(nums1, nums2);
    }
}