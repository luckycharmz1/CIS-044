import java.util.Iterator;
import java.util.Random;
import java.util.ArrayList;

/**
 * A solitaire matching game in which you have a list of random integer values
 * between 10 and 99.
 * You remove from the list any pair of consecutive integers whose first or
 * second digits match.
 * If all values are removed, you win.
 */
public class SolitaireGame {

    /**
     * Initializes the list with 40 random 2-digit numbers.
     */
    public static void initializeList(ArrayList<Integer> theList) {
        Random rand = new Random();
        for (int i = 0; i < 40; i++) {
            int randomNumber = 10 + rand.nextInt(90); // Generates a random number between 10 and 99
            theList.add(randomNumber);
        }
    }

    /**
     * Sees whether two numbers are removable.
     * 
     * @param x The first 2-digit integer value.
     * @param y The second 2-digit integer value.
     * @return True if x and y match in the first or second digit.
     */
    public static boolean removable(Integer x, Integer y) {
        int firstDigitX = x / 10; // First digit of x
        int secondDigitX = x % 10; // Second digit of x
        int firstDigitY = y / 10; // First digit of y
        int secondDigitY = y % 10; // Second digit of y

        // Check if either the first or second digits match
        return firstDigitX == firstDigitY || secondDigitX == secondDigitY;
    }

    /**
     * Display the contents of theList using an Iterator.
     */
    public static void displayList(ArrayList<Integer> theList) {
        Iterator<Integer> iterator = theList.iterator();
        System.out.print("[");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Scans over the list and removes any pairs of values that are removable.
     * 
     * @param theList The list of 2-digit integers to scan over.
     * @return True if any pair of integers was removed.
     */
    public static boolean scanAndRemovePairs(ArrayList<Integer> theList) {
        Iterator<Integer> iterator = theList.iterator();
        ArrayList<Integer> toRemove = new ArrayList<>();
        Integer prev = null;

        while (iterator.hasNext()) {
            Integer current = iterator.next();

            if (prev != null && removable(prev, current)) {
                toRemove.add(prev);
                toRemove.add(current);
                System.out.println("Removed: " + prev + " " + current);
            }

            prev = current;
        }

        // Remove the marked pairs from the list
        if (!toRemove.isEmpty()) {
            theList.removeAll(toRemove);
            return true; // Pairs were removed
        }

        return false; // No pairs were removed
    }

    public static void main(String args[]) {
        ArrayList<Integer> theList = new ArrayList<>();
        initializeList(theList);

        // Display the initial list
        System.out.print("The list is originally: ");
        displayList(theList);

        // Keep scanning and removing pairs until either the list is empty or no more
        // pairs can be removed
        while (!theList.isEmpty()) {
            if (!scanAndRemovePairs(theList)) {
                System.out.println("No more pairs to remove.");
                break;
            }

            // Display the list after removing a pair
            System.out.print("The list is now: ");
            displayList(theList);
        }

        // If the list is empty, we won!
        if (theList.isEmpty()) {
            System.out.println("The list is empty. You win!");
        }
    }
}
