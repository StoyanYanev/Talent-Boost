package BinaryTree;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeImplementation<T extends Comparable<T>> implements BinaryTree<T> {
    private Node<T> root;

    private Node<T> addElement(T value, Node<T> r) {
        if (r == null) {
            r = new Node<>(value);
        } else if (value.compareTo(r.data) < 0) {
            r.left = addElement(value, r.left);
        } else if (value.compareTo(r.data) > 0) {
            r.right = addElement(value, r.right);
        }
        return r;
    }

    @Override
    public void add(T value) {
        this.root = addElement(value, this.root);
    }

    public Iterator<T[]> BfsIterator() {
        return new BFSIterator<T>(root);
    }

    public Iterator<T> DfsIterator() {
        return new DFSIterator<T>(root);
    }

    private class BFSIterator<T extends Comparable<T>> implements Iterator {
        private Queue<Node<T>> queue;

        public BFSIterator(Node<T> node) {
            queue = new ArrayDeque<>();
            queue.add(node);
        }

        @Override
        public boolean hasNext() {
            if (queue.isEmpty() == true) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            Node<T> current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            return current;
        }

    }

    private class DFSIterator<T extends Comparable<T>> implements Iterator {
        private Stack<Node<T>> stack;

        public DFSIterator(Node<T> node) {
            stack = new Stack<>();
            stack.push(node);
        }

        @Override
        public boolean hasNext() {
            if (stack.isEmpty() == true) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            Node<T> current = stack.pop();
            if (current.left != null) {
                stack.add(current.left);
            }
            if (current.right != null) {
                stack.add(current.right);
            }
            return current;
        }
    }
}