package Lab7;

public class lab7 {
    public class Lab7 {
    
        public static void main(String[] args) {
            // Test for findMissing
            int[] A1 = {3, 6, 5, 1, 4};
            int[] A2 = {4, 7, 5, 2, 6, 1};
            System.out.println("Missing from A1: " + findMissing(A1)); // Expected: 2
            System.out.println("Missing from A2: " + findMissing(A2)); // Expected: 3
    
            // Test for countingSort
            int[] A = {9, 2, 4, 8, 9, 4, 3, 2, 8, 1, 2, 7, 2, 5};
            countingSort(A, 9);
            System.out.print("Sorted array: ");
            for (int num : A) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    
        public static int findMissing(int[] a) {
            int n = a.length;
            int expectedSum = (n + 1) * (n + 2) / 2;
            int actualSum = 0;
    
            for (int num : a) {
                actualSum += num;
            }
    
            return expectedSum - actualSum;
        }
    
        public static void countingSort(int[] a, int n) {
            int[] count = new int[n]; // Count array for values from 1 to n
    
            // Count frequencies
            for (int num : a) {
                count[num - 1]++;
            }
    
            // Overwrite the original array with sorted values
            int index = 0;
            for (int i = 0; i < n; i++) {
                while (count[i] > 0) {
                    a[index++] = i + 1;
                    count[i]--;
                }
            }
        }
    }
    
}
