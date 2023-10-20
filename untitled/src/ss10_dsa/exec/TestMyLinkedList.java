package ss10_dsa.exec;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Number> listNumber = new MyLinkedList<>();
        listNumber.add(1);
        listNumber.add(2);
        listNumber.add(1,3);
        listNumber.addFirst(4);
        listNumber.addLast(5);
        listNumber.printList();
        listNumber.remove(4);
        listNumber.printList();
        System.out.println(listNumber.indexOf(2));
        listNumber.add(6);
        listNumber.printList();
        System.out.println(listNumber.get(2));
        System.out.println(listNumber.getFirst());
        System.out.println(listNumber.getLast());
        listNumber.clear();
        listNumber.printList();
    }
}
