package Lab8;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class lab8 {
    

public class UnsortedLinkedDictionary<K, V> {
public static void main(String args[])
{
// Add you tests here
}
public UnsortedLinkedDictionary() {
} // end default constructor
public V add(K key, V value) {
} // end add
public V remove(K key) {
} // end remove
public V getValue(K key) {
} // end getValue
public boolean contains(K key) {
} // end contains
public boolean isEmpty() {
} // end isEmpty
public int getSize() {
} // end getSize
public final void clear() {
} // end clear
private class Node {
private K key;
private V value;
private Node next;
private Node(K searchKey, V dataValue) {
key = searchKey;
value = dataValue;
next = null;
} // end constructor
private Node(K searchKey, V dataValue, Node nextNode) {
key = searchKey;
value = dataValue;
next = nextNode;
} // end constructor
private K getKey() {
return key;
} // end getKey
private V getValue() {
return value;
} // end getValue
private void setValue(V newValue) {
value = newValue;
} // end setValue
private Node getNextNode()
{
return next;
} // end getNextNode
private void setNextNode(Node nextNode) {
next = nextNode;
} // end setNextNode
} // end Node
} // end UnsortedLinkedDictionary

}
