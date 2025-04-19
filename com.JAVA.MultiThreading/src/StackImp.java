public class StackImp {
    private int[] stack;
    private int capacity;
    private int stackTop=-1;

    public StackImp(int capacity){
        this.capacity=capacity;
        stack=new int[this.capacity];
    }

    public boolean push(int data) {
        if (isFull())
            return false;
        stackTop++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stack[stackTop] = data;

        return true;
    }

    public boolean isFull() {
        if(stackTop>=capacity)
            return true;
        return false;
    }

    public boolean isEmpty() {
        if (stackTop<0)
            return true;
        return false;
    }

    public int pop(){
        if(isEmpty())
            return Integer.MIN_VALUE;
       int tempdata= stack[stackTop];
       stack[stackTop]=Integer.MIN_VALUE;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stackTop--;
       return tempdata;
    }
}
