package BinarySearchTreeImplementation;

public class BinarySearchTree implements BinaryTree {
    private Node root;

    private Node addHelper(Node r, int key) {
        if (r == null) {
            r = new Node(key);
        } else if (r.data > key) {
            r.left = addHelper(r.left, key);
        } else if (r.data < key) {
            r.right = addHelper(r.right, key);
        }
        return r;
    }

    private Node removeHelper(Node r, int key) {
        if (r != null) {
            if (r.data > key) {
                r.left = removeHelper(r.left, key);
            } else if (r.data < key) {
                r.right = removeHelper(r.right, key);
            } else {
                if (r.left == null) {
                    return r.right;
                } else if (r.right == null) {
                    return r.left;
                }
                r.data = minValue(r.right);
                r.right = removeHelper(r.right, r.data);
            }
        }
        return r;
    }

    private int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    private boolean findHelper(Node r, int key) {
        if (r != null) {
            if (r.data == key) {
                return true;
            } else if (r.data > key) {
                return findHelper(r.left, key);
            } else {
                return findHelper(r.right, key);
            }
        }
        return false;
    }

    private int heightHelper(Node r) {
        if (r != null) {
            int leftHeight = heightHelper(r.left) + 1;
            int rightHeight = heightHelper(r.right) + 1;
            if (leftHeight > rightHeight) {
                return leftHeight;
            } else {
                return rightHeight;
            }
        }
        return 0;
    }

    private void inorderHelper(Node r) {
        if (r != null) {
            inorderHelper(r.left);
            System.out.print(r.data + " ");
            inorderHelper(r.right);
        }
    }


    @Override
    public void add(int key) {
        this.root = this.addHelper(this.root, key);
    }

    @Override
    public void remove(int key) {
        this.root = removeHelper(this.root, key);
    }

    @Override
    public boolean find(int key) {
        return findHelper(this.root, key);
    }

    @Override
    public void inorder() {
        inorderHelper(this.root);
        System.out.println();
    }

    @Override
    public int height() {
        return heightHelper(this.root);
    }
}