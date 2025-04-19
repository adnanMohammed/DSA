import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();

    public ImplementQueueUsingStack() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int temp=s2.peek();
        s2.pop();

        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return temp;
    }

    public int peek() {
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int temp=s2.peek();
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return temp;
    }

    public boolean empty() {
        if (s1.isEmpty())
            return true;
        return false;
    }
}

class ImplementQueueUsingStackMain{
    public static void main(String[] args) {
        ImplementQueueUsingStack obj = new ImplementQueueUsingStack();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        obj.push(60);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }

}
