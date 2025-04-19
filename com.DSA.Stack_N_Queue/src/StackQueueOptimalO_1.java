import java.util.Stack;
//Implement Queue using one Stack
public class StackQueueOptimalO_1 {
    Stack < Integer > input = new Stack < > ();
    Stack < Integer > output = new Stack < > ();
    /** Initialize your
     * data structure here. */
    public StackQueueOptimalO_1() {

    }

    /** Push element x
     *  to the back of queue. */
    public void push(int x) {
        System.out.println("The element pushed is " + x);
        input.push(x);
    }

    /** Removes the
     * element from in
     * front of queue and returns that element. */
    public int pop() {
        // shift input to output
        if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }


        int x = output.peek();
        output.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        // shift input to output
        if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        return output.peek();
    }
    int size() {
        return (output.size() + input.size());
    }

}

class StackQueueMain{
    public static void main(String[] args) {
        StackQueueOptimalO_1 s=new StackQueueOptimalO_1();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.pop());
        s.push(6);
        s.push(7);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}