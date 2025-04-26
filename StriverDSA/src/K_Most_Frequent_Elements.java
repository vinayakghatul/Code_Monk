import java.util.*;

class K_Most_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {

        // store all elements and their frequency in map

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i],0) + 1);
        }

        // custom priority queue for minHeap, use of lambda function as comparator

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            minHeap.add(entry);

            if (minHeap.size() > k) {
                // if heap size is greater then k, then remove smallest pair
                minHeap.poll();
            }
        }

        // generate result array
        int[] result = new int[k];
        int i=0;

        while(!minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> pair = minHeap.poll();
            result[i] = pair.getKey();
            i++;
        }

        for (int j=0;j<k;j++) {
            System.out.print(result[j] + " ");
        }
        return result;

    }

    public static void main(String args[]) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        K_Most_Frequent_Elements kMostFrequentElements = new K_Most_Frequent_Elements();

        kMostFrequentElements.topKFrequent(nums, k);
    }
}