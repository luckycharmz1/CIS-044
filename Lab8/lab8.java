package Lab8;

import java.util.NoSuchElementException;

public class UnsortedLinkedDictionary<K, V> {

    private Node firstNode; // Head of the list
    private int numberOfEntries;

    public static void main(String[] args) {
        // Add your tests here
        UnsortedLinkedDictionary<String, Integer> dict = new UnsortedLinkedDictionary<>();

        // Add entries
        dict.add("apple", 1);
        dict.add("banana", 2);
        dict.add("cherry", 3);
        System.out.println("Size after additions: " + dict.getSize()); // Should be 3

        // Get value
        System.out.println("Value for 'banana': " + dict.getValue("banana")); // Should be 2

        // Contains key
        System.out.println("Contains 'apple': " + dict.contains("apple")); // true
        System.out.println("Contains 'durian': " + dict.contains("durian")); // false

        // Remove entry
        dict.remove("banana");
        System.out.println("Size after removing 'banana': " + dict.getSize()); // Should be 2
        System.out.println("Contains 'banana': " + dict.contains("banana")); // false

        // Clear dictionary
        dict.clear();
        System.out.println("Is empty after clear? " + dict.isEmpty()); // true
    }

    public UnsortedLinkedDictionary() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public V add(K key, V value) {
        Node currentNode = firstNode;

        // Check for existing key
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                V oldValue = currentNode.getValue();
                currentNode.setValue(value);
                return oldValue;
            }
            currentNode = currentNode.getNextNode();
        }

        // Key not found, insert at beginning
        Node newNode = new Node(key, value, firstNode);
        firstNode = newNode;
        numberOfEntries++;
        return null;
    }

    public V remove(K key) {
        Node currentNode = firstNode;
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                V result = currentNode.getValue();
                if (previousNode == null) {
                    firstNode = currentNode.getNextNode();
                } else {
                    previousNode.setNextNode(currentNode.getNextNode());
                }
                numberOfEntries--;
                return result;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        return null;
    }

    public V getValue(K key) {
        Node currentNode = firstNode;
        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public boolean contains(K key) {
        return getValue(key) != null;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public int getSize() {
        return numberOfEntries;
    }

    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    private class Node {
        private K key;
        private V value;
        private Node next;

        private Node(K searchKey, V dataValue) {
            this(searchKey, dataValue, null);
        }

        private Node(K searchKey, V dataValue, Node nextNode) {
            key = searchKey;
            value = dataValue;
            next = nextNode;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V newValue) {
            value = newValue;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}
