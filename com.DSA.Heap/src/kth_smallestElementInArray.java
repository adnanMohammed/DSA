import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class kth_smallestElementInArray {

    public static void main(String[] args) {
        kth_smallestElementInArray kt=new kth_smallestElementInArray();
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        int ans=kt.findKthSmallest(arr,k);
        System.out.println("ans="+ans);


    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        for (int i:nums) {
            maxHeap.add(i);
        }
        for (int i = 0; i <k-1 ; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public int findKthLargestOptimal(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //O(N) TC
        for (int i : nums) {
            minHeap.add(i);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }

    public int findKthSmallest(int[] nums, int k) {
        // Create a max-heap with a size of K
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add elements to the max-heap
        for (int num : nums) {
            maxHeap.add(num);
            // If heap size exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // The root of the max-heap is the k-th smallest element
        return maxHeap.peek();
    }
}
