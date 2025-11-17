import java.util.*;

public class PostfixToInfix {

    // Function to convert postfix to infix
    public static String postfixToInfix(String s) {

        // Stack should store strings (not characters)
        java.util.Stack<String> stack = new java.util.Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // If operand -> push as string
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            } 
            // Operator -> pop two operands and combine
            else {
                String op1 = stack.pop();  // first popped is second operand
                String op2 = stack.pop();  // second popped is first operand

                // Form Infix: (op2 operator op1)
                String expr = "(" + op2 + c + op1 + ")";

                // Push back to stack
                stack.push(expr);
            }
        }

        // Final infix expression
        return stack.pop();
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        String postfix = "ab+c*";

        System.out.println("Postfix Expression : " + postfix);
        System.out.println("Infix Expression   : " + postfixToInfix(postfix));
    }
}
