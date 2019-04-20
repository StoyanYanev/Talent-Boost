package ImproveImplementationsOfStackAndQueue;

import java.util.EmptyStackException;

public class Queue implements Behavior {
    int[] queue;
    int currentSize;
    int maxSize;
    int front;
    int last;
    private static final int MAX_SIZE = 100;

    Queue() {
        this(MAX_SIZE);
    }

    Queue(int size) {
        this.maxSize = size;
        this.queue = new int[this.maxSize];
        this.currentSize = 0;
        this.front = 0;
    }

    @Override
    public void push(int element) {
        if (isFull() == true) {
            this.resize();
        }
        this.last = (this.last + 1) % this.maxSize;
        this.queue[this.last] = element;
        this.currentSize++;
    }

    @Override
    public Integer peek() {
        if (isEmpty() == true) {
            return null;
        }
        return this.queue[this.front];
    }

    @Override
    public int pop() {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        }
        this.front = (this.front + 1) % this.maxSize;
        int element = this.queue[this.front];
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

    @Override
    public boolean isFull() {
        if (this.currentSize == this.maxSize) {
            return true;
        }
        return false;
    }

    @Override
    public void resize() {
        this.maxSize = this.maxSize * 2;
        int[] temp = new int[this.maxSize];
        for (int i = 0; i < this.currentSize; i++) {
            temp[i] = this.queue[i];
        }
        this.queue = temp;
    }
}
