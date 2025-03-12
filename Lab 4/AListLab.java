package Lab4;

public class AListLab {
    public class AListLab<T> {
        private T[] list; // An array to hold the elements
        private int size;
    
        // Method 1: Get the last index of an item
        public int getLastIndex(T item) {
            for (int i = size - 1; i >= 0; i--) {
                if (list[i].equals(item)) {
                    return i;
                }
            }
            return -1; // If item is not found, return -1
        }
    
        // Method 2: Check if two lists are equal
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AListLab)) {
                return false;
            }
            AListLab<?> otherList = (AListLab<?>) other;
            if (this.size != otherList.size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!list[i].equals(otherList.list[i])) {
                    return false;
                }
            }
            return true;
        }
    
        // Add additional methods like constructor, size, etc.
    }
    
    
}
