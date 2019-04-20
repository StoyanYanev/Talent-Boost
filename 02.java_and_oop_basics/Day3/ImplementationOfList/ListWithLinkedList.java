package ImplementationOfList;

public class ListWithLinkedList implements List {

    private Node head;
    private Node tail;
    private int currentSize;

    @Override
    public Integer get(int index) {
        if (index < this.currentSize && index >= 0) {
            Node temp = this.head;
            while (index > 1) {
                temp = temp.next;
                index--;
            }
            return temp.data;
        } else {
            if (index < 0) {
                throw new IllegalArgumentException("The index is negative!");
            } else {
                throw new IllegalArgumentException("The index is bigger than the current size!");
            }
        }
    }

    @Override
    public void put(int index, Integer value){
        if (index <= this.currentSize && index >= 0) {
            Node newNode = new Node(value);
            if (this.head == null || index == 0) {
                add(value);
            } else {
                Node temp = this.head;
                while (index > 1) {
                    index--;
                    temp = temp.next;
                }
                if (temp.next == null) {
                    temp.next = newNode;
                    this.tail = newNode;
                } else {
                    Node nextNode = temp.next;
                    temp.next = newNode;
                    newNode.next = nextNode;
                }
            }
            this.currentSize++;
        } else {
            if (index < 0) {
                throw new IllegalArgumentException("The index is negative!");
            } else {
                throw new IllegalArgumentException("The index is bigger than the current size!");
            }
        }
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }
        this.currentSize++;
    }

    @Override
    public Integer size() {
        return this.currentSize;
    }

    public void print() {
        Node curr = this.head;
        while (curr != null) {
            System.out.printf("%d ", curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}