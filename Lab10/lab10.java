package Lab10;

public class lab10 {
    public class BinarySearchTreeLab<T extends Comparable<? super T>> {
        private BinaryNode<T> root;
    
        public BinarySearchTreeLab() {
            root = null;
        }
    
        public BinarySearchTreeLab(T rootData) {
            root = new BinaryNode<T>(rootData);
        }
    
        public static void main(String[] args) {
            BinarySearchTreeLab<Integer> bst = new BinarySearchTreeLab<>();
            bst.add(20);
            bst.add(10);
            bst.add(30);
            bst.add(5);
            bst.add(15);
            bst.add(25);
            bst.add(35);
    
            System.out.println("Is Balanced: " + bst.isBalanced()); // true
            System.out.println("Is BST: " + bst.isBST()); // true
            System.out.println("Predecessor of 20: " + bst.getPredecessor(20)); // 15
            System.out.println("Predecessor of 5: " + bst.getPredecessor(5)); // 5 (it's the smallest)
            System.out.println("Predecessor of 100: " + bst.getPredecessor(100)); // null
        }
    
        // P1: isBalanced
        public boolean isBalanced() {
            return isBalanced(root).balanced;
        }
    
        private class BalanceStatus {
            boolean balanced;
            int height;
    
            BalanceStatus(boolean balanced, int height) {
                this.balanced = balanced;
                this.height = height;
            }
        }
    
        private BalanceStatus isBalanced(BinaryNode<T> node) {
            if (node == null) return new BalanceStatus(true, -1);
    
            BalanceStatus left = isBalanced(node.getLeftChild());
            if (!left.balanced) return new BalanceStatus(false, 0);
    
            BalanceStatus right = isBalanced(node.getRightChild());
            if (!right.balanced) return new BalanceStatus(false, 0);
    
            boolean balanced = Math.abs(left.height - right.height) <= 1;
            int height = Math.max(left.height, right.height) + 1;
            return new BalanceStatus(balanced, height);
        }
    
        // P2: isBST
        public boolean isBST() {
            return isBST(root, null, null);
        }
    
        private boolean isBST(BinaryNode<T> node, T min, T max) {
            if (node == null) return true;
    
            T val = node.getData();
            if ((min != null && val.compareTo(min) <= 0) || (max != null && val.compareTo(max) >= 0))
                return false;
    
            return isBST(node.getLeftChild(), min, val) && isBST(node.getRightChild(), val, max);
        }
    
        // P3: getPredecessor
        public T getPredecessor(T entry) {
            BinaryNode<T> current = root;
            BinaryNode<T> predecessor = null;
    
            while (current != null) {
                int cmp = entry.compareTo(current.getData());
                if (cmp > 0) {
                    predecessor = current;
                    current = current.getRightChild();
                } else if (cmp < 0) {
                    current = current.getLeftChild();
                } else {
                    break;
                }
            }
    
            if (current == null) return null;
    
            if (current.getLeftChild() != null) {
                BinaryNode<T> pred = current.getLeftChild();
                while (pred.getRightChild() != null) {
                    pred = pred.getRightChild();
                }
                return pred.getData();
            }
    
            return (predecessor != null) ? predecessor.getData() : entry;
        }
    
        public T get(T entry) {
            return getEntry(root, entry);
        }
    
        private T getEntry(BinaryNode<T> rootNode, T entry) {
            T result = null;
            if (rootNode != null) {
                T rootEntry = rootNode.getData();
                if (entry.compareTo(rootEntry) == 0)
                    result = rootEntry;
                else if (entry.compareTo(rootEntry) < 0)
                    result = getEntry(rootNode.getLeftChild(), entry);
                else
                    result = getEntry(rootNode.getRightChild(), entry);
            }
            return result;
        }
    
        public boolean contains(T entry) {
            return get(entry) != null;
        }
    
        private T addEntry(BinaryNode<T> rootNode, T newEntry) {
            T result = null;
            int comparison = newEntry.compareTo(rootNode.getData());
            if (comparison == 0) {
                result = rootNode.getData();
                rootNode.setData(newEntry);
            } else if (comparison < 0) {
                if (rootNode.hasLeftChild())
                    result = addEntry(rootNode.getLeftChild(), newEntry);
                else
                    rootNode.setLeftChild(new BinaryNode<T>(newEntry));
            } else {
                if (rootNode.hasRightChild())
                    result = addEntry(rootNode.getRightChild(), newEntry);
                else
                    rootNode.setRightChild(new BinaryNode<T>(newEntry));
            }
            return result;
        }
    
        public T add(T newEntry) {
            T result = null;
            if (root == null)
                root = new BinaryNode<T>(newEntry);
            else
                result = addEntry(root, newEntry);
            return result;
        }
    
        class ReturnObject {
            T data;
            public void set(T newData) {
                data = newData;
            }
            public T get() {
                return data;
            }
        }
    
        public T remove(T entry) {
            ReturnObject oldEntry = new ReturnObject();
            BinaryNode<T> newRoot = removeEntry(root, entry, oldEntry);
            root = newRoot;
            return oldEntry.get();
        }
    
        private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, ReturnObject oldEntry) {
            if (rootNode != null) {
                T rootData = rootNode.getData();
                int comparison = entry.compareTo(rootData);
                if (comparison == 0) {
                    oldEntry.set(rootData);
                    rootNode = removeFromRoot(rootNode);
                } else if (comparison < 0) {
                    BinaryNode<T> newLeftChild = removeEntry(rootNode.getLeftChild(), entry, oldEntry);
                    rootNode.setLeftChild(newLeftChild);
                } else {
                    BinaryNode<T> newRightChild = removeEntry(rootNode.getRightChild(), entry, oldEntry);
                    rootNode.setRightChild(newRightChild);
                }
            }
            return rootNode;
        }
    
        private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode) {
            if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
                BinaryNode<T> leftSubtreeRoot = rootNode.getLeftChild();
                BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
                rootNode.setData(largestNode.getData());
                rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
            } else if (rootNode.hasRightChild())
                rootNode = rootNode.getRightChild();
            else
                rootNode = rootNode.getLeftChild();
            return rootNode;
        }
    
        private BinaryNode<T> findLargest(BinaryNode<T> rootNode) {
            if (rootNode.hasRightChild())
                rootNode = findLargest(rootNode.getRightChild());
            return rootNode;
        }
    
        private BinaryNode<T> removeLargest(BinaryNode<T> rootNode) {
            if (rootNode.hasRightChild()) {
                BinaryNode<T> root = removeLargest(rootNode.getRightChild());
                rootNode.setRightChild(root);
            } else {
                rootNode = rootNode.getLeftChild();
            }
            return rootNode;
        }
    
        // ===== BinaryNode class =====
        private class BinaryNode<E> {
            private E data;
            private BinaryNode<E> leftChild;
            private BinaryNode<E> rightChild;
    
            public BinaryNode(E data) {
                this(data, null, null);
            }
    
            public BinaryNode(E data, BinaryNode<E> leftChild, BinaryNode<E> rightChild) {
                this.data = data;
                this.leftChild = leftChild;
                this.rightChild = rightChild;
            }
    
            public E getData() {
                return data;
            }
    
            public void setData(E data) {
                this.data = data;
            }
    
            public BinaryNode<E> getLeftChild() {
                return leftChild;
            }
    
            public void setLeftChild(BinaryNode<E> leftChild) {
                this.leftChild = leftChild;
            }
    
            public boolean hasLeftChild() {
                return leftChild != null;
            }
    
            public BinaryNode<E> getRightChild() {
                return rightChild;
            }
    
            public void setRightChild(BinaryNode<E> rightChild) {
                this.rightChild = rightChild;
            }
    
            public boolean hasRightChild() {
                return rightChild != null;
            }
        }
    }
    
}
