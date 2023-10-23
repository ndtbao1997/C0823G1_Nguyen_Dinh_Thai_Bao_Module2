package ss12_dsa_stack_quece.exec.linkedlist_quece;

public class MyLinkedListQueue {
    class Node{
        public int key;
        public Node next;
        public Node(int key){
            this.key = key;
            this.next = null;
        }
    }
    private Node front;
    private Node rear;
    public MyLinkedListQueue(){
        this.front = null;
        this.rear = null;
    }
    public void enqueue(int key){
        Node temp = new Node(key);
        if (this.rear == null){
            this.front = this.rear = temp;
            return;
        }
        this.rear.next = temp;
        this.rear = temp;
    }
    public Node dequeue(){
        if (this.front == null){
            return null;
        }
        if (this.front == this.rear){
            this.front = this.rear = null;
        }
        Node temp = this.front;
        this.front = this.front.next;
        return  temp;
    }
    public boolean isEmpty(){
        return this.front == null;
    }
    public void displayQueue(){
        if (isEmpty()){
            return;
        } else {
            while (this.front.next != null){
                System.out.println(dequeue().key);
            }
            System.out.println(this.rear.key);
        }
    }
}
