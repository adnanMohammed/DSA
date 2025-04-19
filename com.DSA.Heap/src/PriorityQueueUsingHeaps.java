import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;

public class PriorityQueueUsingHeaps {
    List<Integer> priorityQueue = null;

    public PriorityQueueUsingHeaps() {
        this.priorityQueue = new ArrayList<>();
    }

    public void push(int val) {
        priorityQueue.add(val);
        if (priorityQueue.isEmpty()) {
            return;
        }

        upHeap(priorityQueue.size() - 1);
    }

    public void upHeap(int index) {
        if (index == 0)
            return;

        int parent = parent(index);
        if (priorityQueue.get(index) < priorityQueue.get(parent))
            return;
        if (priorityQueue.get(index) > priorityQueue.get(parent)) {
            swap(priorityQueue, index, parent);
            upHeap(parent);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }
    private int left(int index) {
        return (2*index)+1;
    }
    private int right(int index) {
        return (2*index)+2;
    }

    public void pop() {
        if (priorityQueue.isEmpty())
            return;

        int last=priorityQueue.remove(priorityQueue.size()-1);
        if (priorityQueue.isEmpty())
            return;
        priorityQueue.set(0,last);
        downHeap(0);
    }

    private void downHeap(int index) {
        int max = index, left = left(index), right = right(index);
        if (left < priorityQueue.size() && priorityQueue.get(left) > priorityQueue.get(max))
            max = left;

        if (right < priorityQueue.size() && priorityQueue.get(right) > priorityQueue.get(max))
            max = right;

        if (index != max) {
            swap(priorityQueue, index, max);
            downHeap(max);
        }

    }

    public void swap(List<Integer> list,int from,int to) {
        int temp = list.get(from);
        list.set(from, list.get(to));
        list.set(to, temp);
    }

    public int top() {
        if (priorityQueue.isEmpty())
            return -1;
        return priorityQueue.get(0);
    }

    public boolean empty() {
        if (!priorityQueue.isEmpty())
            return false;
        return true;

    }

    public static void main(String[] args) {
        PriorityQueueUsingHeaps p = new PriorityQueueUsingHeaps();

    }
}