import java.util.EmptyStackException;

public class CustomStack {
    private int size = 0;
    private boolean stackSizeGiven=false;
    private int initialSize = 5;
    private int[] stack = null;

    public CustomStack(){
        stack= new int[initialSize];
    }
    public CustomStack(int stackSize){
        this.stackSizeGiven=true;
        this.initialSize=stackSize;
        stack= new int[initialSize];
    }


    public void push(int e) {
        if (stack == null || size == 0) {
            stack[size] = e;
            size += 1;
            return;
        }
        if(size>=initialSize && stackSizeGiven){
            System.out.println("stack is full");
            return;
        }
        if (size >= initialSize) {
            initialSize = initialSize * 2;
            int[] stackNew = new int[initialSize];
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

    public void pop() throws Exception {
        if (size == 0)
            throw new Exception("the stack is empty");

        size -= 1;
        stack[size] = 0;

    }


    public int peek() {
        if (size == 0)
            throw new EmptyStackException();
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
        for (int j = 0; j <size ; j++) {
            if (stack[j]==i) {
             return size+(j%size);
            }
        }

        return -1;
    }
}
