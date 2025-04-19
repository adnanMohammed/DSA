import java.util.Arrays;

public class ImplementStackUsingArray {
    int size=5;
    int counter=0;
    int[] cStack=null;

    public ImplementStackUsingArray() {
        cStack=new int[size];
    }

    public void push(int x) {
        if (counter>=size){
           cStack= Arrays.copyOf(cStack,size*2);
        }
        cStack[counter++]=x;
    }

    public int pop() {
        if (counter>0) {
            int temp=cStack[counter-1];
            counter--;
            return temp;
        }

        return -1;
    }

    public int top() {
        if (counter>0)
            return cStack[counter-1];

        return -1;

    }

    public boolean isEmpty() {
        if (counter==0)
            return true;
        return false;
    }
}


class ImplementStackUsingArrayMain {
    public static void main(String[] args) {
        ImplementStackUsingArray a = new ImplementStackUsingArray();
        a.push(5);
        a.push(10);
        a.top();
        a.pop();
        a.isEmpty();
    }
}