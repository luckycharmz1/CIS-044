package Lab4;

public class List2Lab {
    public int getLastIndex(T item) {
        Node current = head;
        int index = 0;
        int lastIndex = -1;
    
        // Traverse through the list and check for matching item
        while (current != null) {
            if (current.data.equals(item)) {
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
    
        return lastIndex;
    }
    
}
