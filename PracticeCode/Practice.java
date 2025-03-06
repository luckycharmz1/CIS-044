import java.util.Queue;
import java.util.LinkedList;

public class Practice {
    public static void main(String[] args) {
        // Creating an example queueing and dequeueing
        Queue<String> queue = new LinkedList<>();

        queue.offer("Frank");
        queue.offer("Bob");
        queue.offer("Carlos");
        queue.offer("Jesse");

        // Printing the queue (Dating List)
        System.out.println("Dating List: " + queue);

        // Swiping left (dequeueing the first element)
        System.out.println("Swiped Left On: " + queue.poll());

        // Print the updated queue after the swipe
        System.out.println("Whose left on the Dating List: " + queue);
    }
}
