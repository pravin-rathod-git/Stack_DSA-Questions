import java.util.Stack;

class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push element into the queue
    public void push(int x) {
        // Step 1: Move all elements from s1 → s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Step 2: Push new element into s1
        s1.push(x);

        // Step 3: Move everything back from s2 → s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Removes the element at the front of the queue
    public int pop() {
        if (s1.isEmpty()) return -1;
        return s1.pop();  // s1 always stores queue in correct order
    }

    // Get the front element
    public int peek() {
        if (s1.isEmpty()) return -1;
        return s1.peek();
    }

    // Return whether the queue is empty
    public boolean empty() {
        return s1.isEmpty();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        q.push(10);
        q.push(20);
        q.push(30);

        System.out.println("Peek: " + q.peek());  // 10
        System.out.println("Pop: " + q.pop());    // 10
        System.out.println("Peek: " + q.peek());  // 20

        System.out.println("Is Empty? " + q.empty()); // false

        q.pop();
        q.pop();

        System.out.println("Is Empty? " + q.empty()); // true
    }
}
