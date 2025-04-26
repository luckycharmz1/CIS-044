package Lab9;

public class BinaryNode<T> {
    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    // Default constructor
    public BinaryNode() {
        this(null); // call next constructor
    }

    // Constructor with data only
    public BinaryNode(T dataPortion) {
        this(dataPortion, null, null); // call next constructor
    }

    // Constructor with data and child references
    public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    }

    // Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T newData) {
        data = newData;
    }

    public BinaryNode<T> getLeftChild() {
        return left;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        left = leftChild;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public BinaryNode<T> getRightChild() {
        return right;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        right = rightChild;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    // Height of the node
    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(BinaryNode<T> node) {
        int height = 0;
        if (node != null) {
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
        return height;
    }

    // Number of nodes in the subtree
    public int getNumberOfNodes() {
        int leftNumber = 0;
        int rightNumber = 0;
        if (left != null) {
            leftNumber = left.getNumberOfNodes();
        }
        if (right != null) {
            rightNumber = right.getNumberOfNodes();
        }
        return 1 + leftNumber + rightNumber;
    }

    // Copy the entire subtree rooted at this node
    public BinaryNode<T> copy() {
        BinaryNode<T> newRoot = new BinaryNode<>(data);
        if (left != null) {
            newRoot.left = left.copy();
        }
        if (right != null) {
            newRoot.right = right.copy();
        }
        return newRoot;
    }
}
