package ImproveImplementationsOfStackAndQueue;

import ImplementationOfStack.BehaviorOfStack;

import java.util.EmptyStackException;

public class Stack implements BehaviorOfStack {
    int[] stack;
    int currentSize;
    int maxSize;
    private static final int MAX_SIZE = 100;

    Stack() {
        this(MAX_SIZE);
    }

    Stack(int size) {
        this.maxSize = size;
        this.stack = new int[this.maxSize];
        this.currentSize = 0;
    }

    @Override
    public void push(int element) {
        if (isFull() == true) {
            this.resize();
        }
        this.stack[currentSize] = element;
        this.currentSize++;
    }

    @Override
    public Integer peek() {
        if (isEmpty() == false) {
            return null;
        }
        return this.stack[this.currentSize];
    }

    @Override
    public int pop() {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        }
        int lastElement = this.stack[this.currentSize];
        this.currentSize--;
        return lastElement;
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
        if (this.currentSize >= this.maxSize) {
            return true;
        }
        return false;
    }

    @Override
    public void resize() {
        this.maxSize = this.maxSize * 2;
        int[] temp = new int[this.maxSize];
        for (int i = 0; i < this.currentSize; i++) {
            temp[i] = this.stack[i];
        }
        this.stack = temp;
    }
}