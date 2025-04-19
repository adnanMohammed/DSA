import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;
    int size=0;
    DoublyLinkedList head=null;
    DoublyLinkedList tail=null;
    Map<Integer,DoublyLinkedList> mTemp=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        Map<Integer,Integer> m1=new HashMap<>();
        m1.put(-1,-1);
        this.head=new DoublyLinkedList(m1);
        this.tail=new DoublyLinkedList(m1);
        head.next=tail;
        tail.prev=head;

    }

    public int get(int key) {
        if (mTemp.containsKey(key)){
            DoublyLinkedList remove=mTemp.get(key);
            remove.prev.next=remove.next;
            remove.next.prev=remove.prev;

            DoublyLinkedList prev = tail.prev;
            remove.next=tail;
            prev.next=remove;
            remove.prev=prev;
            tail.prev=remove;
            return mTemp.get(key).data.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(key, value);
        DoublyLinkedList node = new DoublyLinkedList(m);


        if (!mTemp.containsKey(key) && size < capacity) {
            DoublyLinkedList prev = tail.prev;
            node.next = tail;
            prev.next = node;
            node.prev = prev;
            tail.prev=node;
            mTemp.put(key,node);
            size++;
        }
        else if (mTemp.containsKey(key)){
           DoublyLinkedList node1= mTemp.get(key);
            DoublyLinkedList prevTemp= node1.prev;
            prevTemp.next=node1.next;
            node1.next.prev=prevTemp;
            DoublyLinkedList prev = tail.prev;
            node.next = tail;
            prev.next = node;
            node.prev = prev;
            tail.prev=node;
            mTemp.put(key,node);

        }
        else {
            mTemp.remove(head.next.data.keySet().toArray()[0]);
            head.next = head.next.next;
            head.next.prev = head;
            DoublyLinkedList prev = tail.prev;
            node.next = tail;
            prev.next = node;
            node.prev = prev;
            tail.prev=node;
            mTemp.put(key,node);
        }

    }
}

class DoublyLinkedList {
    Map<Integer, Integer> data;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    public DoublyLinkedList(Map<Integer, Integer> data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class LRUMain{
    public static void main(String[] args) {
        LRUCache lr = new LRUCache(4);
        lr.put(2, 6);
        lr.put(4, 7);
        lr.put(8, 11);
        lr.put(7, 10);
        System.out.println(lr.get(2));
        System.out.println(lr.get(8));
        lr.put(5, 6);
        System.out.println(lr.get(7));
        lr.put(5, 7);
    }
}
