public class SingleCircularLinkedList {
    Node head;
    Node tail;
    int size;

    public SingleCircularLinkedList() {
        this.size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        if(size==0)
            return;
        Node temp=head;
        while (temp.next!=head){
            System.out.print(temp.data+",");
            temp=temp.next;
        }
        System.out.println(temp.data);
    }

    public void insertLast(int data) {
        Node n = new Node(data);
        if (head == null && tail == null) {
            n.next = n;
            head = n;
            tail = n;
            size += 1;
        } else {
            tail.next = n;
            n.next = head;
            tail = n;
            size += 1;
        }
    }

    public void deleteAtaPos(int index) {
        Node temp = head;
        if (index >= size)
            return;

        if (size == 1) {
            head = null;
            tail = null;
            size -= 1;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size -= 1;

    }

}
