public class ArrayStack2Lab implements StackInterface {
    private int top; // To track the top of the stack
    private int[] stack; // Array to hold the stack elements

    // Constructor to initialize the stack with a default size
    public ArrayStack2Lab(int size) {
        stack = new int[size];
        top = -1; // Initially the stack is empty
    }

    // Problem 1: Implement the display() method
    public void display() {
        if (top == -1) {
            System.out.println("The stack is empty");
        } else {
            // Start from the top of the stack and print each element
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    // Problem 2: Implement the remove(int n) method
    public int remove(int n) {
        if (top == -1) {
            // Stack is empty
            return 0;
        }
        
        int itemsRemoved = 0;

        // Remove up to n items, but don't go beyond the stack's top
        while (n > 0 && top >= 0) {
            stack[top] = 0; // Optional: Clear the removed element
            top--; // Decrement the top index
            itemsRemoved++;
            n--;
        }

        return itemsRemoved;
    }

    // Additional methods to add and remove items from the stack if needed
    public void push(int value) {
        if (top < stack.length - 1) {
            stack[++top] = value;
        } else {
            System.out.println("Stack overflow");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return stack[top--];
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayStack2Lab stack = new ArrayStack2Lab(10); // Create a stack of size 10

        // Test pushing elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Test displaying the stack
        System.out.println("Stack after pushing elements:");
        stack.display();

        // Test removing elements
        int removedCount = stack.remove(3); // Try to remove the top 3 elements
        System.out.println("\nNumber of items removed: " + removedCount);

        // Test displaying the stack after removal
        System.out.println("\nStack after removing 3 elements:");
        stack.display();

        // Test removing more elements than available
        removedCount = stack.remove(5);
        System.out.println("\nNumber of items removed: " + removedCount);

        // Test displaying the stack after more removals
        System.out.println("\nStack after attempting to remove 5 more elements:");
        stack.display();
    }
}
