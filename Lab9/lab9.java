import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

package Lab9;

public class lab9 {
    //package TreePackage;

public class BinaryTreeLab<T> {

    public static void main(String args[]) {
        // Add your tests here
        
        // Example tests
        BinaryTreeLab<Integer> tree = new BinaryTreeLab<>(1);
        tree.setTree(1, 
            new BinaryTreeLab<>(2, new BinaryTreeLab<>(4), new BinaryTreeLab<>(5)), 
            new BinaryTreeLab<>(3)
        );

        System.out.println("Count 1 (using recursion) of 1: " + tree.count1(1)); // Should print 1
        System.out.println("Count 2 (using iterator) of 1: " + tree.count2(1)); // Should print 1
        System.out.println("Count 1 (using recursion) of 5: " + tree.count1(5)); // Should print 1
        System.out.println("Count 2 (using iterator) of 5: " + tree.count2(5)); // Should print 1
        System.out.println("Count 1 (using recursion) of 6: " + tree.count1(6)); // Should print 0

        BinaryTreeLab<Integer> tree2 = new BinaryTreeLab<>(1);
        tree2.setTree(1, 
            new BinaryTreeLab<>(2, new BinaryTreeLab<>(4), new BinaryTreeLab<>(5)), 
            new BinaryTreeLab<>(3)
        );
        System.out.println("Trees are isomorphic: " + BinaryTreeLab.isIsomorphic(tree, tree2)); // Should be true

        BinaryTreeLab<Integer> tree3 = new BinaryTreeLab<>(1);
        tree3.setTree(1, new BinaryTreeLab<>(2), null);
        System.out.println("Trees are isomorphic: " + BinaryTreeLab.isIsomorphic(tree, tree3)); // Should be false
    }

    // O(n) time, O(h) space (height of tree due to recursion)
    public int count1(T anObject) {
        return count1(root, anObject);
    }

    // O(n) time, O(h) space
    private int count1(BinaryNode<T> rootNode, T anObject) {
        if (rootNode == null) {
            return 0;
        }
        int count = 0;
        if (rootNode.getData().equals(anObject)) {
            count = 1;
        }
        return count + count1(rootNode.getLeftChild(), anObject) + count1(rootNode.getRightChild(), anObject);
    }

    // O(n) time, O(h) space for stack in iterator
    public int count2(T anObject) {
        int count = 0;
        Iterator<T> it = getInorderIterator();
        while (it.hasNext()) {
            if (it.next().equals(anObject)) {
                count++;
            }
        }
        return count;
    }

    public static <T> boolean isIsomorphic(BinaryTreeLab<T> t1, BinaryTreeLab<T> t2) {
        return isIsomorphic(t1.root, t2.root);
    }

    private static <T> boolean isIsomorphic(BinaryNode<T> node1, BinaryNode<T> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (!node1.getData().equals(node2.getData())) {
            return false;
        }
        // Check left and right subtrees
        boolean leftIso = isIsomorphic(node1.getLeftChild(), node2.getLeftChild());
        boolean rightIso = isIsomorphic(node1.getRightChild(), node2.getRightChild());
        return leftIso && rightIso;
    }

    // Everything below was already provided:
    protected BinaryNode<T> root;

    public BinaryTreeLab() {
        root = null;
    }

    public BinaryTreeLab(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    public BinaryTreeLab(T rootData, BinaryTreeLab<T> leftTree, BinaryTreeLab<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    }

    public void setTree(T rootData) {
        root = new BinaryNode<T>(rootData);
    }

    public void setTree(T rootData, BinaryTreeLab<T> leftTree, BinaryTreeLab<T> rightTree) {
        privateSetTree(rootData, leftTree, rightTree);
    }

    private void privateSetTree(T rootData, BinaryTreeLab<T> leftTree, BinaryTreeLab<T> rightTree) {
        root = new BinaryNode<T>(rootData);
        if (leftTree != null)
            root.setLeftChild(leftTree.root);
        if (rightTree != null)
            root.setRightChild(rightTree.root);
    }

    public T getRootData() {
        T rootData = null;
        if (root != null)
            rootData = root.getData();
        return rootData;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public int getHeight() {
        return root.getHeight();
    }

    public int getNumberOfNodes() {
        return root.getNumberOfNodes();
    }

    public void inorderTraversal() {
        Stack<BinaryNode<T>> nodeStack = new Stack<BinaryNode<T>>();
        BinaryNode<T> currentNode = root;
        while (!nodeStack.empty() || currentNode != null) {
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            if (!nodeStack.empty()) {
                BinaryNode<T> nextNode = nodeStack.pop();
                System.out.println(nextNode.getData());
                currentNode = nextNode.getRightChild();
            }
        }
    }

    public Iterator<T> getPreorderIterator() {
        return new PreorderIterator();
    }

    public Iterator<T> getInorderIterator() {
        return new InorderIterator();
    }

    private class PreorderIterator implements Iterator<T> {
        private Stack<BinaryNode<T>> nodeStack;

        public PreorderIterator() {
            nodeStack = new Stack<BinaryNode<T>>();
            if (root != null)
                nodeStack.push(root);
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        public T next() {
            BinaryNode<T> nextNode;
            if (hasNext()) {
                nextNode = nodeStack.pop();
                BinaryNode<T> leftChild = nextNode.getLeftChild();
                BinaryNode<T> rightChild = nextNode.getRightChild();
                if (rightChild != null)
                    nodeStack.push(rightChild);
                if (leftChild != null)
                    nodeStack.push(leftChild);
            } else {
                throw new NoSuchElementException();
            }
            return nextNode.getData();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class InorderIterator implements Iterator<T> {
        private Stack<BinaryNode<T>> nodeStack;
        private BinaryNode<T> currentNode;

        public InorderIterator() {
            nodeStack = new Stack<BinaryNode<T>>();
            currentNode = root;
        }

        public boolean hasNext() {
            return !nodeStack.isEmpty() || (currentNode != null);
        }

        public T next() {
            BinaryNode<T> nextNode = null;
            while (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeftChild();
            }
            if (!nodeStack.isEmpty()) {
                nextNode = nodeStack.pop();
                currentNode = nextNode.getRightChild();
            } else
                throw new NoSuchElementException();
            return nextNode.getData();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

}
