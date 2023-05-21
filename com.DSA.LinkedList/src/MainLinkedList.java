public class MainLinkedList {

    public static void main(String[] args) {
        CustomSingleLinkedList cs=new CustomSingleLinkedList();
        cs.insertLast(2);
        cs.insertLast(5);
        cs.insertLast(10);
        cs.insertRecursion(1,0);

        cs.insertRecursion(3,2);
        cs.insertRecursion(8,4);
        cs.insertRecursion(15,6);
        cs.insertRec(20,3);
        cs.showList();
        cs.insertRec(25,4);
        cs.insertRec(0,10);

        /*SingleCircularLinkedList sl = new SingleCircularLinkedList();
        sl.insertLast(1);
       /* sl.insertLast(2);
        sl.insertLast(3);
        sl.insertLast(4);
        sl.display();
        sl.deleteAtaPos(1);
        sl.display();
        sl.deleteAtaPos(3);
        sl.display();
        sl.deleteAtaPos(2);
        sl.deleteAtaPos(0);
        sl.deleteAtaPos(0);
        sl.display();
       /* CustomDoubleLinkedList li = new CustomDoubleLinkedList();
        li.insertLast(10);
        li.insertLast(15);
        li.insertLast(50);
        li.insertFirst(1);
        li.insertFirst(2);
        li.insertFirst(3);
        li.showList();
        System.out.println(  li.size());
        li.insertAtpos(55,3);
        li.insertAtpos(56,0);
        li.insertAtpos(55,li.size());
        System.out.println(  li.size());
        li.showList();
       li.deleteAtaPos(3);
       li.showList();
       li.deleteAtaPos(0);
        li.deleteAtaPos(0);
        li.deleteAtaPos(0);
        li.deleteAtaPos(0);
       li.deleteAtaPos(li.size());
       li.deleteAtaPos(li.size()-1);
       li.showList();
        System.out.println();
       li.displayReverse();

      /*  CustomSingleLinkedList l = new CustomSingleLinkedList();
        l.insertFirst(8);
        l.insertFirst(15);
        l.insertFirst(7);
        l.insertFirst(59);
        l.insertFirst(15);
        l.insertFirst(98);
        l.insertFirst(65);
        l.insertAtPos(10, l.size());
        l.get(2);
        l.find(15);
        l.deleteFirst();
        l.deleteLast();
        System.out.println("below is insert last");
        l.insertLast(8);
        l.insertLast(15);
        l.insertLast(7);
        l.insertLast(59);
        l.insertLast(15);
        l.insertLast(98);
        l.add(5);
        l.add(10);
        l.add(98);
        l.add(110);
        l.add(13);
        l.add(90);
        l.showList();*/
    }
}
