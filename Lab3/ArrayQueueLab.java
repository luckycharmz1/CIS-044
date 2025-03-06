public class ArrayQueueLab<T> implements QueueInterface<T> {

}

//Problem 1, part 1
public void splice(QueueInterface<T> anotherQueue) {
    if (anotherQueue.isEmpty()) {
        return;
    }

    while (!anotherQueue.isEmpty()) {
        T item = anotherQueue.dequeue();
        this.enqueue(item);
    }
}

//Problem 2, part2
public boolean enqueueNoDupilicate(T item) {
    QueueInterface<T> tempQueue = new ArrayQueueLab<>():
    boolean isDuplicate = false;

    while (!this.isEmpty()) {
        T(currentItem.equals(item)) {
            isDuplicate = true;
        }
        tempQueue.enqueue(currentItem);
    }

    while (!tempQueue.isEmpty()) {
        this.enqueue(tempQueue.dequeue());
    }

    if (isDuplicate) {
        return false;
    }

    this.enqueue(item);
    return false;
}


public static void main(String[] args) {
    ArrayQueueLab<Integer> queue1 = new ArrayQueueLab<>();
    ArrayQueueLab<Integer> queue2 = new ArrayQueueLab<>();
    
    // Enqueue items into the first queue
    queue1.enqueue(1);
    queue1.enqueue(2);
    queue1.enqueue(3);
    
    // Enqueue items into the second queue
    queue2.enqueue(4);
    queue2.enqueue(5);
    
    // Test splice() method
    queue1.splice(queue2);
    System.out.println("Queue 1 after splice: " + queue1); // Should contain 1, 2, 3, 4, 5
    System.out.println("Queue 2 after splice: " + queue2); // Should be empty
    
    // Test enqueueNoDuplicate() method
    boolean added = queue1.enqueueNoDuplicate(3); // Should not add 3 (already present)
    System.out.println("Added 3 again: " + added); // Should print false
    
    added = queue1.enqueueNoDuplicate(6); // Should add 6
    System.out.println("Added 6: " + added); // Should print true
}
