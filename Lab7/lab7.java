package Lab7;

public class lab7 {
    public static int findMissing(int[] a) {
        int n = a.length;
        int expectedSum = (n + 1) * (n + 2) / 2;
        int actualSum = 0;
    
        for (int num : a) {
            actualSum += num;
        }
    
        return expectedSum - actualSum;
    }
    
}
