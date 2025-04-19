import java.util.Comparator;
import java.util.PriorityQueue;

public class K_thLargestElementInArray {
    public int kthLargestElement(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.peek();
    }
    public  int findKthLargest(int[] nums, int k) {
        // Create a min-heap (priority queue)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Add elements to the min-heap
        for (int num : nums) {
            minHeap.add(num);
            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap is the k-th largest element
        return minHeap.peek();
    }


    public static void main(String[] args) {
        K_thLargestElementInArray kt = new K_thLargestElementInArray();
        int[] nums = {5, 6, 7, 1, 2, 9, 8, 10};
        int k = 5;
        int ans = kt.findKthLargest(nums, k);
        System.out.println("ans=" + ans);
    }
}
