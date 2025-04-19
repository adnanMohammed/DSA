import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class MinHeap {
    private List<Integer> heap = null;
    MinHeap() {
        this.heap = new ArrayList<>();
    }
    //O(logN) TC
    private void insert(int i) {
        heap.add(i);
        heapUp(heap.size() - 1);
    }

    private void heapUp(int index) {
        if (index == 0)
            return;
        int parent = parent(index);
        if (heap.get(parent) < heap.get(index))
            return;
        if (heap.get(parent) > heap.get(index))
            swap(heap, parent, index);
        heapUp(parent);
    }

    // O(logN) TC
    // Remove the minimum element from the heap
    public int remove() {
        if (heap.isEmpty())
            throw new IndexOutOfBoundsException();
        int minReturn = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (heap.size() > 0) {
            heap.set(0, last);
            heapdown(0);
        }
        return minReturn;
    }

    public void heapdown(int index) {
        int min = index, left = left(index), right = right(index);

        if (left < heap.size() && heap.get(min) > heap.get(left))
            min = left;
        if (right < heap.size() && heap.get(min) > heap.get(right))
            min = right;

        if (index != min) {
            swap(heap, index, min);
            heapdown(min);
        }
    }


    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    //O(1) TC constant Time
    private int getMin() {
        if (!heap.isEmpty())
            return heap.get(0);
        return -1;
    }

    public List<Integer> heapSort() {
        List<Integer> ans = new ArrayList<>();
        while (!heap.isEmpty())
            ans.add(remove());
        return ans;
    }

    public static void main(String[] args) {
        MinHeap mh = new MinHeap();
        mh.insert(5);
        mh.insert(6);
        mh.insert(7);
        mh.insert(1);
        mh.insert(2);
        mh.insert(9);
        mh.insert(8);
        List<Integer> Heapsort = mh.heapSort();
        System.out.println(Heapsort);
    }


}