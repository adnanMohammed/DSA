import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public  List<Integer> mergeKSortedArraysOptimal(int[][] arrays) {
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        List<Integer> result = new ArrayList<>();

        // Step 1: Initialize the heap with the first element of each array
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                minHeap.add(new ArrayEntry(arrays[i][0], i, 0));
            }
        }

        // Step 2: Process the heap until it's empty
        while (!minHeap.isEmpty()) {
            ArrayEntry entry = minHeap.poll();
            result.add(entry.value);

            // If there are more elements in the same array, add the next element to the heap
            if (entry.elementIndex + 1 < arrays[entry.arrayIndex].length) {
                minHeap.add(new ArrayEntry(arrays[entry.arrayIndex][entry.elementIndex + 1], entry.arrayIndex, entry.elementIndex + 1));
            }
        }

        return result;
    }

    public  List<Integer> mergeKSortedArrays(int[][] arrays) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                    minHeap.add(arrays[i][j]);
            }
        }

        List<Integer> ans=new ArrayList<>();

        while (!minHeap.isEmpty())
            ans.add(minHeap.poll());

        return ans;
    }

    public static void main(String[] args) {
        MergeKSortedArrays m = new MergeKSortedArrays();
        int[][] arrays = {
                {1, 5, 7, 9, 10},
                {2, 8, 12, 15},
                {-5, -3, 0, 10},
                {1}
        };
        m.mergeKSortedArrays(arrays);

    }
}

class ArrayEntry {
    int value;
    int arrayIndex;
    int elementIndex;

    public ArrayEntry(int value, int arrayIndex, int elementIndex) {
        this.value = value;
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
    }
}
