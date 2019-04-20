package BinaryTree;

public class Node<T extends Comparable<T>> {
    Node left;
    Node right;
    T data;

    Node(T value) {
        this.data = value;
    }
}