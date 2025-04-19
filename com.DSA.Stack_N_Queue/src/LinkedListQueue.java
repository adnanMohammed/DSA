public class LinkedListQueue {
    Node first = null;
    Node last = null;

    public LinkedListQueue() {

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

        int val=first.data;
        if (first==last){
            first=null;
            last=null;
            return val;
        }

        first=first.next;
        return val;
    }

    public int top() {
        if (first == null)
            return -1;

        return first.data;

    }

    public boolean isEmpty() {
        return first == null;
    }
}


class LinkedListQueueMain{
    public static void main(String[] args) {
        LinkedListQueue s=new LinkedListQueue();
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
