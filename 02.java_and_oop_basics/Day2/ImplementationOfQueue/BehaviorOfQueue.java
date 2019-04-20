package ImplementationOfQueue;

public interface BehaviorOfQueue {
    void enqueue(int element);
    int dequeue();
    Integer peek();
    int size();
    boolean isEmpty();
    boolean isFull();
    void resize();
}