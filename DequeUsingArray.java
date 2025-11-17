// Deque implemented using Circular Array
class Deque {
    int size = 10;               // Maximum capacity
    int[] arr = new int[size];   // Array to store elements
    int front = -1;              // Front pointer
    int rear = -1;               // Rear pointer

    // Check if deque is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if deque is full
    public boolean isFull() {
        return (front == 0 && rear == size - 1) ||
               (rear + 1) % size == front;
    }

    // Insert element at front
    public void pushFront(int x) {
        if (isFull()) {
            System.out.println("Deque is full! Cannot push at front.");
            return;
        }

        // If first element
        if (isEmpty()) {
            front = rear = 0;
        }
        // Move front circularly
        else {
            front = (front - 1 + size) % size;
        }

        arr[front] = x;
        System.out.println(x + " inserted at front");
    }

    // Insert element at rear
    public void pushBack(int x) {
        if (isFull()) {
            System.out.println("Deque is full! Cannot push at rear.");
            return;
        }

        // If first element
        if (isEmpty()) {
            front = rear = 0;
        }
        // Move rear circularly
        else {
            rear = (rear + 1) % size;
        }

        arr[rear] = x;
        System.out.println(x + " inserted at back");
    }

    // Remove and return front element
    public int popFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty! Nothing to pop front.");
            return -1;
        }

        int x = arr[front];

        // If only one element left
        if (front == rear) {
            front = rear = -1;
        } 
        else {
            front = (front + 1) % size;
        }

        return x;
    }

    // Remove and return back element
    public int popBack() {
        if (isEmpty()) {
            System.out.println("Deque is empty! Nothing to pop back.");
            return -1;
        }

        int x = arr[rear];

        // If only one element left
        if (front == rear) {
            front = rear = -1;
        } 
        else {
            rear = (rear - 1 + size) % size;
        }

        return x;
    }

    // Get front element
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty, no front element.");
            return -1;
        }
        return arr[front];
    }

    // Get back element
    public int peekBack() {
        if (isEmpty()) {
            System.out.println("Deque is empty, no back element.");
            return -1;
        }
        return arr[rear];
    }
}


// Test Class
public class DequeUsingArray {
    public static void main(String[] args) {
        Deque dq = new Deque();

        dq.pushBack(10);
        dq.pushBack(20);
        dq.pushFront(5);
        dq.pushFront(2);

        System.out.println("Front: " + dq.peekFront());  // 2
        System.out.println("Back: " + dq.peekBack());    // 20

        System.out.println("Popped front: " + dq.popFront()); // 2
        System.out.println("Popped back: " + dq.popBack());   // 20

        System.out.println("Front: " + dq.peekFront()); // 5
        System.out.println("Back: " + dq.peekBack());   // 10
    }
}
