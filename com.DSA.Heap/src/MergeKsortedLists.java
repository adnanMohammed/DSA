import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKsortedLists {

    public ListNode mergeKSortedLists(List<ListNode> heads) {
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>();
        for (ListNode head:heads) {
            while (head.next!=null)
                minHeap.add(head);
            head=head.next;
        }
        return new ListNode();

    }

    public static void main(String[] args) {
MergeKsortedLists m=new MergeKsortedLists();
List<ListNode> l=new ArrayList<>();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
