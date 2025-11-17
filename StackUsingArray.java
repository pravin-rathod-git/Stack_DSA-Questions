// Stack class implemented using an array
class Stack {
    int size = 10;              // Maximum capacity of the stack
    int top = -1;               // Pointer to the top element
    int[] arr = new int[size];  // Array to store stack elements

    // Method to push an element into the stack
    public void push(int x) {

        // Overflow check: if top reaches last index
        if (top == size - 1) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }

        top++;                 // Move top to the next position
        arr[top] = x;          // Insert the element
    }

    // Method to pop (remove and return) the top element
    public int pop() {

        // Underflow check: if stack is empty
        if (top == -1) {
            System.out.println("Stack Underflow! Nothing to pop.");
            return -1;         // Return a dummy value
        }

        int x = arr[top];      // Read top element
        top--;                 // Move top backward
        return x;              // Return popped value
    }

    // Method to get the top element without removing it
    public int top() {

        // Check if stack is empty
        if (top == -1) {
            System.out.println("Stack is empty! No top element.");
            return -1;
        }

        return arr[top];
    }

    // Method to get the current size of the stack
    public int size() {
        return top + 1;
    }
}


// Main class to test the Stack implementation
public class StackUsingArray {
    public static void main(String[] args) {

        Stack s = new Stack();  // Create a new stack

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println(s.pop());  // Output: 30
        System.out.println(s.pop());  // Output: 20

        System.out.println(s.top());  // Output: 10
        System.out.println(s.size()); // Output: 1

        // Test underflow
        s.pop();   // Pops 10
        s.pop();   // Underflow
    }
}
