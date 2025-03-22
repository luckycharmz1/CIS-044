package Lab4;

public class List2Lab {
    public class LList2Lab<T> {
        private Node head;
        private int size;

        // Node class to represent each element in the linked list
        private class Node {
            T data;
            Node next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        // Method 1: Get the last index of an item
        public int getLastIndex(T item) {
            Node current = head;
            int index = 0;
            int lastIndex = -1;

            // Traverse through the linked list and check for matching item
            while (current != null) {
                if (current.data.equals(item)) {
                    lastIndex = index;
                }
                current = current.next;
                index++;
            }

            return lastIndex;
        }

        // Method 2: Check if two linked lists are equal
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LList2Lab)) {
                return false;
            }
            LList2Lab<?> otherList = (LList2Lab<?>) other;
            if (this.size != otherList.size) {
                return false;
            }

            Node current1 = head;
            Node current2 = otherList.head;

            // Traverse both lists and compare data in corresponding nodes
            while (current1 != null) {
                if (!current1.data.equals(current2.data)) {
                    return false;
                }
                current1 = current1.next;
                current2 = current2.next;
            }
            return true;
        }

        // Add additional methods
        public static void main(String[] args) {
            LList2Lab<Integer> list1 = new LList2Lab<>();
            list1.add(1);
            list1.add(2);
            list1.add(3);
            list1.add(2);
            System.out.println("Last index of 2: " + list1.getLastIndex(2)); // Should print 3
            System.out.println("Are the lists equal? " + list1.equals(list2)); // Should compare two linked lists
        }

    }

}
