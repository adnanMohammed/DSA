public class CustomDeque {
    private int defaultSize = 5;
    private boolean sizeGiven = false;
    private int size = 0;
    int[] deque = null;

    public CustomDeque() {
        deque = new int[defaultSize];
    }

    public CustomDeque(int size) {
        defaultSize = size;
        deque = new int[defaultSize];
        this.sizeGiven = true;
    }

    public int addFirst(int e) {
        if (size == 0) {
            deque[size] = e;
            size += 1;
            return e;
        }
        if (size < defaultSize) {
            int temp = size;
            for (int i = temp; i >= 1; i--) {
                deque[i] = deque[i - 1];
            }
            deque[0] = e;
            size += 1;
            return e;
        }
        if (size >= defaultSize && this.sizeGiven) {
            System.out.println("queue is full");
            return -1;
        }
        if (size >= defaultSize) {
            defaultSize = defaultSize * 2;
            int[] newArr = new int[defaultSize];
            for (int i = 0; i < deque.length; i++) {
                newArr[i] = deque[i];
            }
            deque = newArr;

            int temp = size;
            for (int i = temp; i >= 1; i--) {
                deque[i] = deque[i - 1];
            }
            deque[0] = e;
            size += 1;
            return e;
        }

        return -1;

    }

    public int offerFirst(int e) {
        return addFirst(e);
        //  return -1;
    }

    public int removeFirst() {
        if (size == 0)
            return -1;

        int removed = deque[0];
        for (int i = 0; i < size; i++) {
            deque[i] = deque[i + 1];
        }
        deque[size - 1] = 0;
        size -= 1;
        return removed;
    }

    public int removeLast() {
        if (size == 0)
            return -1;
        int removed = deque[size - 1];
        deque[size - 1] = 0;
        size -= 1;
        return removed;
    }

    public int peekFirst() {
        if(size==0)
            return -1;
        return deque[0];

    }

    public int peekLast() {
        if(size==0)
            return -1;
        return deque[size-1];

    }

    public int getFirst() {
        if(size==0)
            return -1;
        return deque[0];

    }

    public int getLast() {
        if(size==0)
            return -1;
        return deque[size-1];

    }
}
