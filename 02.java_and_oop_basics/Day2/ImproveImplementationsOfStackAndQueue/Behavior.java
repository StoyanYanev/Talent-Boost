package ImproveImplementationsOfStackAndQueue;

public interface Behavior {
    void push(int element);
    Integer peek();
    int pop();
    int size();
    boolean isEmpty();
    boolean isFull();
    void resize();
}