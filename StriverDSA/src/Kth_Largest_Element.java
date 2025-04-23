import java.util.*;

class Kth_Largest_Element {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = nums.length;

        for (int num : nums) {
            pq.add(num);

            // maintain heap of size k
            if (pq.size() > k) {
                // remove smallest one to track k largest so far
                pq.poll();
            }
        }

        System.out.println(pq.peek());

        return pq.peek();

    }

    public static void main(String args[]) {
        int[] nums = {1,2,3,4,5,6,7,8};

        Kth_Largest_Element kthLargestElement = new Kth_Largest_Element();

        kthLargestElement.findKthLargest(nums, 3);
    }
}