import java.util.*;

public class LRUCacheDeque {
    int size = 0;
    Deque<Map<Integer, Integer>> dq = new ArrayDeque<>();
    Map<Integer, Map<Integer, Integer>> mtemp = new HashMap<>();
    int capacity;

    public LRUCacheDeque(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (mtemp.containsKey(key)) {
          Map<Integer,Integer> addLast1 = mtemp.get(key);
            dq.remove(addLast1);
            dq.addLast(addLast1);
            return (int)addLast1.values().toArray()[0];
        }
        return -1;
    }

    public void put(int key, int value) {
        Map<Integer, Integer> m = new HashMap();
        m.put(key, value);
        if (!mtemp.containsKey(key) && size < capacity) {
            dq.addLast(m);
            mtemp.put(key, m);
            size++;
        } else if (mtemp.containsKey(key)) {
            dq.remove(mtemp.get(key));
            dq.addLast(m);
            mtemp.put(key,m);
        } else {
            mtemp.remove(dq.getFirst().keySet().toArray()[0]);
            dq.removeFirst();
            dq.addLast(m);
            mtemp.put(key, m);
        }

    }
}

class LRUCacheMain {
    public static void main(String[] args) {
        LRUCacheDeque lr = new LRUCacheDeque(4);
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
