public class LinkedListStack {
    Node first = null;
    Node last = null;

    public LinkedListStack() {

    }

    public void push(int x) {
        Node n = new Node(x);
        if (first == null) {
            first = n;
            last = n;
            return;
        }
        last.next = n;
        last=n;
    }

    public int pop() {
        if (first == null)
            return -1;

        int val = last.data;
        if (first.next == null) {
            first = null;
            last = null;
            return val;
        }

        Node temp = first;



        while (temp.next != last)
            temp = temp.next;

        temp.next = null;
        last = temp;
        return val;
    }

    public int top() {
        if (last == null)
            return -1;

        return last.data;
    }

    public boolean isEmpty() {
        return last == null;
    }
}
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedListStackMain{
    public static void main(String[] args) {
        LinkedListStack s=new LinkedListStack();
        s.push(3);
        s.push(7);
        s.push(8);
        s.push(9);

        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.top();
        s.isEmpty();

    }
}