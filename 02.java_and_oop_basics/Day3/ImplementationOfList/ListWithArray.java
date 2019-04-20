package ImplementationOfList;

public class ListWithArray implements List {
    private int[] list;
    private int currentSize;
    private int maxSize;

    private static final int MAX_SIZE = 100;

    private void resize() {
        this.maxSize = this.maxSize * 2;
        int[] temp = new int[this.maxSize];
        for (int i = 0; i < this.currentSize; i++) {
            temp[i] = this.list[i];
        }
        this.list = temp;
    }

    ListWithArray() {
        this(MAX_SIZE);
    }

    ListWithArray(int size) {
        this.maxSize = size;
        this.list = new int[this.maxSize];
        this.currentSize = 0;
    }

    @Override
    public Integer get(int index) {
        if (index < this.currentSize && index >= 0) {
            return this.list[index];
        } else {
            if (index < 0) {
                throw new IllegalArgumentException("The index is negative!");
            } else {
                throw new IllegalArgumentException("The index is bigger than the current size!");
            }
        }
    }

    @Override
    public void put(int index, Integer value) {
        if (index >= 0) {
            if (index >= this.maxSize) {
                while (index >= this.maxSize) {
                    this.maxSize = this.maxSize * 2;
                }
            } else if (this.currentSize + 1 >= this.maxSize) {
                this.maxSize = this.maxSize * 2;
            }

            int start = index;
            int end = this.currentSize;
            if (index > this.currentSize) {
                start = this.currentSize;
            }

            int[] temp = new int[this.maxSize];
            for (int i = 0; i < start; i++) {
                temp[i] = this.list[i];
            }
            temp[index] = value;
            for (int i = start; i < end; i++) {
                temp[i + 1] = this.list[i];
            }
            this.list = temp;
            this.currentSize++;
        } else {
            throw new IllegalArgumentException("The index is negative!");
        }
    }

    @Override
    public void add(int value) {
        if (this.currentSize >= this.maxSize) {
            this.resize();
        }
        this.list[this.currentSize] = value;
        this.currentSize++;
    }

    @Override
    public Integer size() {
        return this.currentSize;
    }
}