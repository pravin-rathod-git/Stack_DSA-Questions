import java.util.Stack;

class MinStack {

    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);

        // push min value at each level
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        } else {
            minSt.push(minSt.peek());
        }
    }

    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
            minSt.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}

public class MinStackImplementation {
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(-2);
        ms.push(0);
        ms.push(-3);

        System.out.println("Min: " + ms.getMin()); // -3

        ms.pop();
        System.out.println("Top: " + ms.top());    // 0
        System.out.println("Min: " + ms.getMin()); // -2
    }
}
