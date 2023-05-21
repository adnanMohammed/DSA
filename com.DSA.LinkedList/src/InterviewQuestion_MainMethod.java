public class InterviewQuestion_MainMethod {
    public static void main(String[] args) {
        InterviewQuestion_LinkedList li = new InterviewQuestion_LinkedList();
        li.insertLast(1);
        li.insertLast(2);
        li.insertLast(3);
        li.insertLast(4);
        li.insertLast(5);

        //  li.insertLast(4);
        //li.insertLast(5);


        int k = 2;
        li.rotateRight(li.head, k);
        li.showList();
    }

}
