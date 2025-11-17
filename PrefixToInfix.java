public class PrefixToInfix {

    // Convert Prefix expression to Infix
    public static String PrefixtoInfix(String s) {

        java.util.Stack<String> stack = new java.util.Stack<>();

        // Scan from right to left for prefix
        for (int i = s.length() - 1; i >= 0; i--) {

            char c = s.charAt(i);

            // If operand -> push to stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(c + "");
            }
            // If operator -> pop two operands and combine
            else {
                String op1 = stack.pop();  // first operand
                String op2 = stack.pop();  // second operand

                String expr = "(" + op1 + c + op2 + ")";

                stack.push(expr);
            }
            
        }

        // Final infix expression is on top of stack
        return stack.pop();
    }

    // MAIN
    public static void main(String[] args) {

        String prefix = "*+AB-CD";
        System.out.println("Prefix : " + prefix);
        System.out.println("Infix  : " + PrefixtoInfix(prefix));
    }
}
