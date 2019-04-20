package StackAndQueueWithLinkedList;

import java.util.EmptyStackException;

public class Stack implements Behavior {
    Node head;
    int currentSize;

    @Override
    public void push(int element) {
        Node node = new Node(element);
        node.next = this.head;
        this.head = node;
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
        int element = this.peek();
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