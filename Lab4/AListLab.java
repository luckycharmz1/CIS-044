package Lab4;

public class AListLab {
    public int getLastIndex(T item) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1; // item not found
    }
    
}
