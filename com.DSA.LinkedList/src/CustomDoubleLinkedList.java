public class CustomDoubleLinkedList {
    Node head;
    Node tail;
    int size;

    public CustomDoubleLinkedList() {
        this.size=0;
    }

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;

        }
    }


    public int get(int index){
        if(index>=size())
            return -1;
        if(index==0)
            return head.data;
        if(index==size())
            return tail.data;

        Node temp=head;
        for (int i = 0; i <index ; i++) {
            temp=temp.next;
        }
        return temp.data;

    }
    public int size(){
        return size;
    }

    public void deleteAtaPos(int pos) {
        if (pos >= size)
            return;
        if (pos == 0) {
            if (size == 1) {
                head=null;
                tail=null;
                size-=1;
                return;
            }
            head = head.next;
            head.prev=null;

            size -= 1;
            return;
        }
        if (pos == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size -= 1;
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size -= 1;
    }

    public void insertLast(int data){
        Node n=new Node(data);
        if (head==null && tail==null){
            this.head=n;
            this.tail=n;
            size+=1;
        }
        else {
            tail.next=n;
            n.prev=tail;
            tail=n;
            size+=1;
        }
    }

    public void insertAtpos(int data,int pos) {
        Node n = new Node(data);

        if (pos == 0 || size == 0) {
            insertFirst(data);
            return;
        }
        if (pos == size()) {
            insertLast(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next.prev = n;
        temp.next = n;
        n.prev = temp;
        size += 1;
    }

    public void insertFirst(int data){
        Node n=new Node(data);
        if (head==null && tail==null){
            this.head=n;
            this.tail=n;
            size+=1;
        }
        else {
           n.next=head;
           head.prev=n;
           head=n;
           size+=1;
        }
    }


    public void displayReverse(){
        Node temp=tail;
        while(temp.prev!=null) {
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.print(temp.data);


    }

    public void showList() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data+",");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
