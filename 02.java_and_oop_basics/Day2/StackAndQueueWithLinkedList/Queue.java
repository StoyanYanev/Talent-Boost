package StackAndQueueWithLinkedList;

import java.util.EmptyStackException;

public class Queue implements Behavior {
    Node head;
    Node tail;
    int currentSize;

    @Override
    public void push(int element) {
        Node node = new Node(element);
        if (this.head == null) {
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.currentSize++;
    }

    @Override
    public Integer peek() {
        if (isEmpty() == true) {
            return null;
        }
        return this.head.data;
    }

    @Override
    public int pop() {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        }
        int element = this.head.data;
        this.head = this.head.next;
        this.currentSize--;
        return element;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        if (this.currentSize == 0) {
            return true;
        }
        return false;
    }
}