// Queue class implemented using Circular Array
class Queue {
    int size = 16;              // Maximum capacity of the queue
    int start = -1;             // Pointer to the front element
    int end = -1;               // Pointer to the rear element
    int[] arr = new int[size];  // Array to store queue elements
    int currentSize = 0;        // Number of elements currently in the queue

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return currentSize == size;
    }

    // Method to insert an element into the queue
    public void push(int x) {

        // Check for overflow
        if (isFull()) {
            System.out.println("The queue is full");
            return;
        }

        // If queue is empty, initialize pointers
        if (end == -1) {
            start = 0;
            end = 0;
        } 
        // Move end circularly
        else {
            end = (end + 1) % size;
        }

        arr[end] = x; // Insert element
        System.out.println(x + " is pushed inside the queue");
        currentSize++;
    }

    // Method to remove and return the front element
    public int pop() {

        // Underflow condition
        if (isEmpty()) {
            System.out.println("No element inside the queue");
            return -1;
        }

        int x = arr[start];     // Store front element

        start = (start + 1) % size; // Move start circularly
        currentSize--;

        // Reset queue if it becomes empty
        if (currentSize == 0) {
            start = -1;
            end = -1;
        }

        return x;
    }

    // Method to return the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty, no front element");
            return -1;
        }
        return arr[start];
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue();

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Peek: " + q.peek());    // 10
        System.out.println("Popped: " + q.pop());   // 10
        System.out.println("Popped: " + q.pop());   // 20

        System.out.println("Is empty? " + q.isEmpty());
        System.out.println("Is full? " + q.isFull());
    }
}
