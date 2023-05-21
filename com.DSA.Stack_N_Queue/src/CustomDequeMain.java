import java.util.ArrayDeque;
import java.util.Deque;

public class CustomDequeMain {
    public static void main(String[] args) {
        CustomDeque d = new CustomDeque();
        d.addFirst(10);
        d.addFirst(20);
        d.addFirst(30);
        d.addFirst(40);
        d.getFirst();
        d.getLast();
        d.peekFirst();
        d.peekLast();
        d.removeFirst();
        d.removeLast();
    }
}
