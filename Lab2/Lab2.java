public class Lab2 {
	public static void main(String[] arg) {
		// write your test code here
	}
	// Problem 4
	public static int min(int[] a, int begin, int end) {
    if (begin == end) {
        return a[begin]; // Base case: one element
    }
    int mid = (begin + end) / 2;
    int leftMin = min(a, begin, mid);
    int rightMin = min(a, mid + 1, end);
    return Math.min(leftMin, rightMin); // Return the minimum of the two halves
}

public static void main(String[] arg) {
    int[] a = { 2, 3, 5, 7, 11, 13, 17, 19, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 23, 29, 31, 37, 41, 43 };
    System.out.println(min(a, 0, a.length - 1)); // Test the min method
}


	
	// Problem 5
	public static long computePay(int day) {
    if (day == 1) {
        return 1; // Base case: 1 cent on the first day
    }
    return 2 * computePay(day - 1); // Recursive step: double the pay from the previous day
}

public static long computeSavings(int day) {
    if (day == 1) {
        return 1; // Base case: savings on the first day
    }
    return computePay(day) + computeSavings(day - 1); // Add today's pay to total savings
}

public static void main(String[] arg) {
    System.out.println("Pay on day 39: " + computePay(39));
    System.out.println("Savings by day 39: " + computeSavings(39));
}

		
}