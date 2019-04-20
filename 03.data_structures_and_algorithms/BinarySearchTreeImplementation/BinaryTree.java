package BinarySearchTreeImplementation;

public interface BinaryTree {
    void add(int key);

    void remove(int key);

    boolean find(int key);

    void inorder();

    int height();
}