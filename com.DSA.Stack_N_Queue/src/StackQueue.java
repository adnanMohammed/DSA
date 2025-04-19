import java.util.Stack;

public class StackQueue {
    Stack<Integer> in = null;
    int ans=-1;
    int anspeek=-1;

    public StackQueue() {
        in = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (in.isEmpty())
            return -1;
        if (in.size()==1)
            return in.pop();
        popHelper(in);
        return ans;
    }
    private void popHelper(Stack<Integer> in) {
        if (in.size()==1) {
            ans= in.pop();
            return ;
        }
        int temp=in.pop();
        popHelper(in);
        in.push(temp);
    }

    public int peek() {
        if (in.isEmpty())
            return-1;
        if (in.size()==1)
            return in.peek();
        peekHelper(in);
        return anspeek;
    }
    private void peekHelper(Stack<Integer> in) {
        if (in.isEmpty())
            return;
        if (in.size()==1) {
            anspeek= in.peek();
        }
        int temp=in.pop();
        peekHelper(in);
        in.push(temp);
    }

    public boolean isEmpty() {
        return in.empty();
    }
}

class stackMain1{
    public static void main(String[] args) {
        StackQueue q=new StackQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.pop();
    }
}

