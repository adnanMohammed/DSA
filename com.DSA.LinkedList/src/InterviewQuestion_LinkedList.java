public class InterviewQuestion_LinkedList {
    Node head;
    Node tail;
    int size;

    public void bubblesort() {
        bubbleSort(size-1,0);
    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node() {

        }

        public Node(int value, Node next) {
            this.data = value;
            this.next = next;
        }
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Node ReverseList(Node head){
        if (head==null)
            return head;
        Node prev=null;
        Node curr=head;
        Node next=curr.next;
        while (curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if (next!=null)
                next=next.next;
        }
        this.head=prev;
        return head;
    }

    public void ReverseAListUsingRecursion(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        ReverseAListUsingRecursion(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }

    public void bubbleSort(int row, int col){
        if(row==0)
            return;
        if(col<row){
            Node first=get(col);
            Node second=get(col+1);
            if(first.data> second.data){
                if(first==head){
                    Node temp=second.next;
                    head=first.next;
                    head.next=first;
                    head.next.next=temp;
                }else {
                    Node prev=get(col-1);
                    first.next=second.next;
                    second.next=first;
                    prev.next=second;
                }
            }
            bubbleSort(row,col+1);
        }else{
           bubbleSort(row-1,0);
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


    //https://leetcode.com/problems/merge-two-sorted-lists/
    public Node mergeTwoList(Node list1, Node list2) {
        Node temp = new Node();
        Node tail = temp;
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            while (list1 != null) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            }
        } else {
            while (list2 != null) {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }

        }

        return temp.next;
    }


    public Node deleteDuplicates(Node head) {
        if (head == null)
            return head;
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public void showList() {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println(temp.data);

    }

    public void showList(Node head) {
        Node temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println(temp.data);

    }

    //https://leetcode.com/problems/linked-list-cycle/

    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    //find the length of linked list cycle
    public int cycleCount(Node head) {
        int size = 0;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = slow.next;
                size += 1;
                while (slow != fast) {
                    slow = slow.next;
                    size += 1;
                }
                return size;
            }
        }
        return size;

    }


    //142. Linked List Cycle II
    public Node detectCycle(Node head) {
        int size = cycleCount(head);
        if (size == 0)
            return null;
        Node first = head;
        Node second = head;
        for (int i = 0; i < size; i++) {
            second = second.next;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }


    //876. Middle of the Linked List
    //https://leetcode.com/problems/middle-of-the-linked-list/
    public Node middleNode(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size += 1;
            temp = temp.next;
        }
        int tempSize = size / 2;
        for (int i = 0; i < tempSize; i++) {
            head = head.next;
        }
        return head;
    }

    //876. Middle of the Linked List
    //https://leetcode.com/problems/middle-of-the-linked-list/
    //optimized solution
    public Node middleNodeoptimized(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    //very imp Google
    //202. Happy Number https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareRoot(slow);
            fast = squareRoot(squareRoot(fast));
        }
        while (slow != fast);
        if (slow == 1)
            return true;
        else
            return false;
    }

    public int squareRoot(int n) {
        int ans = 0;
        while (n > 0) {
            int temp = n % 10;
            ans += temp * temp;
            n = n / 10;
        }
        return ans;
    }


    //206. Reverse Linked List

    public Node reverseList(Node head) {
        Node tail = head;
        while (tail.next != null) {
            Node temp = tail.next;
            tail.next = temp.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }

    //148. Sort List https://leetcode.com/problems/sort-list/
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return merge(left, right);
    }

    Node merge(Node list1, Node list2) {
        Node dummyHead = new Node();
        Node tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    Node getMid(Node head) {
        Node midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public Node reverseBetween(Node head, int left, int right) {
        if(left==right)
            return head;
        Node prev=null;
        Node current=head;
        for(int i=0;i<left-1;i++){
        prev=current;
        current=current.next;
        }
        Node last=prev;
        Node newEnd=current;
        Node next=current.next;
        for (int i = 0; i < ((right-left)+1) ; i++) {
            current.next=prev;
            prev=current;
            current=next;
            if (next!=null){
                next=next.next;
            }
        }
        if(last!=null){
            last.next=prev;
        }
        else {
            head=prev;
        }
        newEnd.next=current;
        return head;
    }



    public boolean Palindrome(Node head) {
        if(head==null || head.next==null)
            return false;
        Node mid = getMid(head);
        Node prev = mid;
        Node current = prev.next;
        Node next =null;
        if(current!=null) {
             next = current.next;
        }
        while (current != null) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }

        }

        while (head != null) {
            if (head.data != prev.data) {
                return false;
            }
            head = head.next;
            prev = prev.next;
        }

        return true;
    }


    public void reorderList(Node head) {
        Node mid = getMid(head);
        Node prev = mid;
        // prev.next = null;
        Node curr = null;
        if (mid != null) {
            curr = prev.next;
        }
        prev.next = null;
        Node next = curr.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        Node temp1 = null;
        Node temp2 = null;

        while (head != null) {
            if (temp1 == null) {
                temp1 = head;
                temp2 = temp1;
                head = head.next;
            } else {
                temp2.next = head;
                temp2 = temp2.next;
                head = head.next;
            }

            if (prev != null) {
                temp2.next = prev;
                temp2 = temp2.next;
                prev = prev.next;
            }
        }
        if (prev != null) {
            temp2.next = prev;
        }
        this.head = temp1;

    }



    public Node reverseKGroup(Node head, int k) {
        int count = 0;
        if (head == null || head.next == null)
            return head;
        Node prev = null;
        Node curr = head;
        Node newLast =null;
        Node next = curr.next;
        Node newEnd=null;
        while (true) {
            newLast = newEnd;
            newEnd = curr;
            count += 1;
            for (int i = 0; i < k; i++) {
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null)
                    next = next.next;
            }
            if (count == 1) {
                head = prev;
            }
            newEnd.next = curr;
            //prev=newEnd;

            if (newLast != null && count > 1) {
                newLast.next = prev;
            }
            int countNode = 0;
            Node currTemp = curr;
            while (currTemp != null) {
                if (countNode >= k)
                    break;
                currTemp = currTemp.next;
                countNode += 1;
            }
            if (countNode < k)
                break;
        }
      this.head=head;
        return head;
    }


    public Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        int size = 1;
        //get the size of a list
        while (temp.next != null) {
            size += 1;
            temp = temp.next;
        }
        //even if we rotate the list will be same as earlier
        if(k==size)
            return head;

        temp.next = head;
        int tail = 0;
        Node tail1 = head;

        tail=(k<size)? size - k:size-( k % size);
        for (int i = 1; i < tail; i++) {
            tail1 = tail1.next;
        }
        this.head = tail1.next;
        tail1.next = null;

        return head;


    }

}
