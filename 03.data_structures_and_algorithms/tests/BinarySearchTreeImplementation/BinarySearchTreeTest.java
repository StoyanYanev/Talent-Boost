package BinarySearchTreeImplementation;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void testBinarySearchTree() {
        BinaryTree tree = new BinarySearchTree();
        assertEquals(0, tree.height());
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(40);
        tree.add(70);
        tree.add(60);
        tree.add(80);
        assertEquals(3, tree.height());

        tree.inorder();

        assertEquals(false, tree.find(100));
        assertEquals(true, tree.find(50));

        tree.remove(100);
        assertEquals(3, tree.height());
        tree.inorder();

        tree.remove(50);
        assertEquals(3, tree.height());
        tree.inorder();

        tree.remove(20);
        assertEquals(3, tree.height());
        tree.inorder();

        tree.remove(40);
        tree.remove(80);
        assertEquals(2, tree.height());
        assertEquals(false, tree.find(40));
    }
}