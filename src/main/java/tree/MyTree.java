package tree;

import java.util.NoSuchElementException;

public class MyTree<Key extends Comparable, Value> {
    private Node root = null;

    public boolean isEmpty() {
        return root == null;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    public int size() {
        return size(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int height() {
        return height(root);
    }

    private Value get(Key key, Node node) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        if (cmp < 0) {
            return get(key, node.left);
        } else {
            return get(key, node.right);
        }
    }

    public Value get(Key key) {
        return get(key, root);
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node node) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        if (node == null) {
            return new Node(key, value, 1, 0);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(key, value, node.left);
        } else {
            node.right = put(key, value, node.right);
        }

        node.size = size(node.left) + size(node.right) + 1;
        reHeight();

        return node;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    public Value max() {
        return max(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    public Value min() {
        return min(root).value;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = removeMin(node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;
        reHeight();


        return node;
    }

    public void removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = removeMin(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = removeMin(node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        reHeight();


        return node;
    }

    public void removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = removeMax(root);
    }

    public void remove(Key key) {
        root = remove(key, root);
    }

    private Node remove(Key key, Node node) {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node tmp = node;
            node = max(tmp.left);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
        } else if (cmp < 0) {
            node.left = remove(key, node.left);
        } else {
            node.right = remove(key, node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        reHeight();

        return node;
    }

    public boolean isBalanced() {
        if (root.left.height == root.right.height) {
            return true;
        } else if (root.left.height - root.right.height < 2 && root.left.height - root.right.height > -2) {
            return true;
        } else {
            return false;
        }
    }

    private void reHeight() {
        if (root.left != null) {
            root.left.height = root.left.size - 1;
        }

        if (root.right != null) {
            root.right.height = root.right.size - 1;
        }
        if (root.left != null && root.right != null) {
            root.height = root.left.height + root.right.height;
        }

    }

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }
}
