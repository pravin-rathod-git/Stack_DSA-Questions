class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class StackIMP {
    Node head;

    // Return tail node
    public Node returnTail() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    // Push element into stack
    public void push(int data) {
        Node newNode = new Node(data, null);

        if (head == null) {
            head = newNode;       // FIXED: you forgot this
        } else {
            Node tail = returnTail();
            tail.next = newNode;
        }
        System.out.println(data + " pushed");
    }

    // Pop element from stack (LIFO)
    public Node pop() {
        if (head == null) {
            System.out.println("Stack is empty");
            return null;
        }

        // If only one element
        if (head.next == null) {
            Node temp = head;
            head = null;
            System.out.println(temp.data + " popped");
            return temp;
        }

        // Multiple nodes → remove last
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        Node popped = temp.next;
        temp.next = null;

        System.out.println(popped.data + " popped");
        return popped;
    }

    // Return top element
    public Node top() {
        if (head == null) return null;
        return returnTail();
    }

    // Print stack elements
    public void printStack() {
        Node temp = head;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackUsingLinkedList {

    public static void main(String[] args) {

        StackIMP s = new StackIMP();

        s.push(10);
        s.push(20);
        s.push(30);

        s.printStack(); // 10 20 30

        System.out.println("Top element: " + s.top().data);

        s.pop(); // removes 30
        s.printStack();

        s.pop(); // removes 20
        s.printStack();

        s.pop(); // removes 10
        s.printStack();

        s.pop(); // empty stack
    }
}
