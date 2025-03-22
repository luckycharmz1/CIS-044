import java.util.*;
package Lab5;

public class Lab5 {
    public class Lab5 {

        // Problem 1: Binary Search Method (Iterative)
        public static <T extends Comparable<? super T>> boolean inArrayIterativeSorted(T[] anArray, T anEntry) {
            int low = 0;
            int high = anArray.length - 1;
    
            while (low <= high) {
                int mid = (low + high) / 2;
                int comparison = anArray[mid].compareTo(anEntry);
    
                if (comparison == 0) {
                    return true; // Found the element
                } else if (comparison < 0) {
                    low = mid + 1; // Search the right half
                } else {
                    high = mid - 1; // Search the left half
                }
            }
    
            return false; // Element not found
        }
    
        // Problem 2: Modified Selection Sort
        public static <T extends Comparable<? super T>> void modifiedSelectionSort(T[] a, int n) {
            for (int i = 0; i < n / 2; i++) {
                int minIndex = i;
                int maxIndex = i;
    
                // Find min and max in the unsorted portion
                for (int j = i + 1; j < n - i; j++) {
                    if (a[j].compareTo(a[minIndex]) < 0) {
                        minIndex = j;
                    }
                    if (a[j].compareTo(a[maxIndex]) > 0) {
                        maxIndex = j;
                    }
                }
    
                // Swap the min element with the element at position i
                T temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
    
                // Adjust maxIndex if it was affected by the min swap
                if (maxIndex == i) {
                    maxIndex = minIndex;
                }
    
                // Swap the max element with the element at position n - 1 - i
                temp = a[n - i - 1];
                a[n - i - 1] = a[maxIndex];
                a[maxIndex] = temp;
            }
        }
    
        // Main Method for Testing
        public static void main(String[] args) {
            // Test for inArrayIterativeSorted
            Integer[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
            System.out.println("Binary Search Test (Finding 7): " + inArrayIterativeSorted(sortedArray, 7)); // true
            System.out.println("Binary Search Test (Finding 4): " + inArrayIterativeSorted(sortedArray, 4)); // false
    
            // Test for modifiedSelectionSort
            Integer[] array = {5, 1, 12, 9, 3, 7, 6};
            System.out.println("Before Sorting: " + java.util.Arrays.toString(array));
            modifiedSelectionSort(array, array.length);
            System.out.println("After Sorting: " + java.util.Arrays.toString(array));
        }
    }
    
    

}
