import java.util.*;

class MyStack {

    Queue<Integer> q1;   // main queue (always stores stack elements)
    Queue<Integer> q2;   // helper queue

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element x onto stack
    public void push(int x) {
        // Step 1: Put new element in q2
        q2.add(x);

        // Step 2: Move all elements from q1 -> q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Removes the element on top of the stack
    public int pop() {
        return q1.remove();   // front element is always the top
    }
    
    // Returns the top element
    public int top() {
        return q1.peek();
    }
    
    // Returns true if the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}


public class StackUsingQueue {
    public static void main(String[] args) {
        
        MyStack st = new MyStack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.top());    // 30
        System.out.println("Pop: " + st.pop());            // 30
        System.out.println("Pop: " + st.pop());            // 20

        System.out.println("Top element: " + st.top());    // 10
        System.out.println("Is stack empty? " + st.empty()); // false

        st.pop();  // removing 10
        System.out.println("Is stack empty? " + st.empty()); // true
    }
}
