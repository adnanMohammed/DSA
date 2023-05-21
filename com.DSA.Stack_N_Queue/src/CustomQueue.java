import java.util.EmptyStackException;

public class CustomQueue {
    private int size = 0;
    private boolean QueueGivenSize=false;
    private int initialSize = 5;
    private int[] queue = null;

    public CustomQueue(){
        queue= new int[initialSize];
    }
    public CustomQueue(int stackSize){
        this.QueueGivenSize=true;
        this.initialSize=stackSize;
        queue= new int[initialSize];
    }


    public void add(int e) {
        if (size == 0) {
            queue[size] = e;
            size += 1;
            return;
        }
        if(size>=initialSize && QueueGivenSize){
            System.out.println("stack is full");
            return;
        }
        if (size >= initialSize) {
            initialSize = initialSize * 2;
            int[] QueueNew = new int[initialSize];
            for (int i = 0; i < size; i++) {
                QueueNew[i] = queue[i];
            }
            queue = QueueNew;
            queue[size] = e;
            size++;
            return;
        }
        queue[size] = e;
        size += 1;
    }

    public void remove() throws Exception {
        if (size == 0)
            throw new Exception("the stack is empty");

        for (int i = 0; i <size ; i++) {
            queue[i]=queue[i+1];
        }
        size-=1;
        queue[size]=0;


    }


    public int peek() {
        if (size == 0)
            throw new EmptyStackException();

        return queue[0];
    }

    public boolean empty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public int search(int i) {
        for (int j = 0; j <size ; j++) {
            if (queue[j]==i) {
                return j+1;
            }
        }

        return -1;
    }
}
