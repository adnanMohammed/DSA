import java.util.Queue;

public class CircularQueue {
    private int default_size = 5;
    int First = 0;
    int End = 0;
    int Size = 0;


    int[] cq = null;

    public CircularQueue() {
        cq = new int[default_size];
    }

    public CircularQueue(int size) {
        this.default_size = size;
        cq = new int[default_size];
    }

    public int add(int data) {
        if (Size != 0 && First == End) {
            System.out.println("Queue is full");
            return -1;
        }
        cq[End] = data;
        Size += 1;
        End = (End + 1) % cq.length;
        return data;
    }

    public int remove() {
        if (Size == 0) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int temp = cq[First];
        First = (First + 1) % cq.length;
        Size -= 1;
        return temp;
    }

    public void showData() {
        int tempFirst = First;
        for (int i = 0; i < Size; i++) {
            System.out.println(cq[tempFirst]);
            tempFirst = (tempFirst + 1) % cq.length;
        }
    }

    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue();
        cq.add(10);
        cq.add(20);
        cq.add(30);
        cq.add(40);
        cq.add(50);
        cq.add(60);
        cq.add(70);
        cq.add(80);
        cq.add(90);
        cq.add(100);
        cq.remove();
        cq.remove();
        cq.showData();

    }
}
