import java.util.Arrays;

public class ImplementQueueUsingArray {
    int size=5;
    int start=0,end=0;
    int[] cQueue=null;
    public ImplementQueueUsingArray() {
    cQueue=new int[size];
    }

    public void push(int x) {
       if (end>=size){
           size=size*2;
           cQueue=Arrays.copyOf(cQueue,size);
       }

       cQueue[end]=x;
       end++;
    }

    public int pop() {
    if (start>=end)
        return -1;

    int temp=cQueue[start];
    start++;
    return temp;
    }

    public int peek() {
    if (start>=end)
        return -1;

    return cQueue[start];
    }

    public boolean isEmpty() {
    if (start>=end)
        return true;
    return false;
    }
}



class ImplementQueueUsingArrayMain {
    public static void main(String[] args) {
        ImplementQueueUsingArray a = new ImplementQueueUsingArray();
        a.push(5);
        a.push(10);
        a.peek();
        a.pop();
        a.pop();
        a.isEmpty();

    }
}
