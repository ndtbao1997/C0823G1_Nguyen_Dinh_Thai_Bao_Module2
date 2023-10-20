package ss10_dsa.exec;

public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes = 0;

    private class Node {
        private Node next;
        private E element;

        public Node(E e) {
            this.element = e;
        }

        public E getData() {
            return this.element;
        }
    }

    public MyLinkedList() {
        head = null;
    }

    public void add(int index, E e) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(e);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        numNodes++;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        numNodes++;
    }

    public E removeFirst() {
        if (numNodes == 0) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    public E removeLast() {
        if (numNodes == 0) {
            return null;
        } else if (numNodes == 1) {
            Node temp = head;
            head = tail = null;
            numNodes = 0;
            return temp.element;
        } else {
            Node current = head;
            for (int i = 0; i < numNodes - 2; i++) {
                current = current.next;
            }
            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == numNodes - 1) {
            return removeLast();
        } else {
            Node previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return current.element;
        }
    }

    public int size() {
        return numNodes;
    }

    public void remove(E e) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.element.equals(e)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                numNodes--;
                return;
            }
        }
    }

    public E clone() {
        Node current = head;
        MyLinkedList<E> newList = new MyLinkedList<>();
        while (current != null) {
            newList.addFirst(current.element);
            current = current.next;
        }
        return (E) newList;
    }

    public boolean contains(E e) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(e)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean add(E e) {
        Node newNode = new Node(e);
        if (numNodes == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        numNodes++;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public E getFirst() {
        if (numNodes == 0) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        return head.element;
    }

    public E getLast() {
        if (numNodes == 0) {
            throw new IndexOutOfBoundsException("LinkedList is empty");
        }
        return tail.element;
    }

    public void clear() {
        head = null;
        tail = null;
        numNodes = 0;
    }

    public void printList() {
        Node current = head;

        while (current != null) {
            if (current.next == null) {
                System.out.print(current.element);
            } else {
                System.out.print(current.element + ",");
            }
            current = current.next;
        }
        System.out.println();
    }


}
