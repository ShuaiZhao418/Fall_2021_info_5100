package Question1;


public class LinkedList {

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // TC = O(n)  SC = O(1)
    public void addAtPosition(int index, int element){
        if (index > size) {
            return ;
        }
        if (index == 0) {
            // add at head
            synchronized (this) {
                Node prev = head;
                head = new Node(element);
                head.next = prev;
                size++;
            }
        } else {
            synchronized (this) {
                size++;
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node node = new Node(element);
                node.next = current.next;
                current.next = node;
            }
        }
    }
    // TC = O(n)  SC = O(1)
    public void removeAtPosition(int index, int element){
        if (index > size) {
            return ;
        }
        synchronized (this) {
            size--;
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
    // TC = O(n)  SC = O(1)
    public int getFirst() {
        return get(0);
    }
    // TC = O(n)  SC = O(1)
    public int getLast() {
        return get(size);
    }
    public int get(int index) {
        synchronized (this) {
            if (index >= size) {
                return -1;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.val;
        }
    }
    public int size(){
        return size;
    }
}
class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}