public class CustomSingleLinkedList {
    Node head;
    Node tail;
    int size;

    public CustomSingleLinkedList() {
        this.size = 0;
    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.data = value;
            this.next = next;
        }
    }

    public int size(){
        return size;
    }

    //interview Question
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    //interview Question
    public void insertRecursion(int data,int index){
        Node n=new Node(data);
        Node temp=head;
        insertRecursionHelper(n,index,temp);

    }

    private void insertRecursionHelper(Node data,int index,Node temp){
        if (index==0){
            data.next=temp;
            head=data;
            size+=1;
            return;
        }
        if(index==1){
            data.next=temp.next;
            temp.next=data;
            size+=1;
            return;
        }
        insertRecursionHelper(data,index-1,temp.next);


    }

    public void insertFirst(int data) {
        Node n = new Node(data);
        if (head == null && tail == null) {
            head = n;
            tail = n;
            size += 1;
        } else {
            n.next = head;
            head = n;
            size += 1;
        }
    }

    public void insertLast(int data) {
        Node n = new Node(data);
        if (head == null && tail == null) {
            head = n;
            tail = n;
            size += 1;
        } else {
            tail.next = n;
            tail = n;
            size += 1;
        }
    }

    public void add(int data) {
        Node n = new Node(data);
        if (this.head == null && this.tail == null) {
            this.head = n;
            this.tail = n;
            size += 1;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            //this.node = n;
            this.tail = n;
            size += 1;
        }
    }

    public void insertAtPos(int data,int index){
        if(index==0)
            insertFirst(data);
        else if(index>this.size)
            return;
        else if(index==size)
            insertLast(data);
        else{
            Node n=new Node(data);
            Node temp=head;
            for (int i = 0; i <index-1 ; i++) {
                temp=temp.next;
            }
            Node temp1=temp.next;
            temp.next=n;
            n.next=temp1;
            size+=1;
        }
    }


    public int deleteFirst() {
        if (size > 0) {
            int value = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size -= 1;
            return value;
        }
        return -1;
    }

    public void deleteLast() {
        if (size == 0)
            return;
        if (size == 1) {
            head = null;
            tail = null;
            size-=1;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size-=1;
        }

    }

    public void showList() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println(temp.data);

    }


    public boolean find(int data){
        if(size==0)
            return false;

        Node temp=head;
        while (temp.next!=null){
            if (temp.data==data)
                return true;

            temp=temp.next;
        }
        if (temp.data==data)
            return true;

        return false;
    }

    public Node get(int index){
        Node temp=head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp;
    }
}
