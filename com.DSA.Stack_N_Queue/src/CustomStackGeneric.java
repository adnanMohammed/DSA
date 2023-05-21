public class CustomStackGeneric<T> {
    private int size = 0;
    private int initialSize = 5;
    //private T[] stack = new T[5];
    private T[] stack = (T[]) new Object[5];

    public void push(T e) {
        if (stack == null || size == 0) {
            stack[size] = e;
            size += 1;
            return;
        }
        if (size >= initialSize) {
            initialSize = initialSize * 2;
            T[] stackNew = (T[]) new Object[initialSize];
            for (int i = 0; i < size; i++) {
                stackNew[i] = stack[i];
            }
            stack = stackNew;
            stack[size] = e;
            size++;
            return;
        }
        stack[size] = e;
        size += 1;
    }

    public void pop() {
        if (size == 0)
            return;

        size -= 1;
        stack[size] = null;

    }


    public Object peek() {
        if (size == 0)
            return -1;
        int peekindex = size - 1;
        return stack[peekindex];
    }

    public boolean empty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public int search(int i) {
        for (int j = 0; j < size; j++) {
            if (stack[j].equals(i))
                return j;
        }
        return -1;
    }
}
